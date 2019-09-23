import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String now = "http://www.acm.org/";
		String[] fs = new String[100];
		int ft = -1;
		String[] bs = new String[100];
		int bt = -1;
		while(true) {
			String input[] = br.readLine().split(" ");
			if(input[0].equals("BACK")) {
				if(bt==-1) {
					System.out.println("Ignored");
					continue;
				}
				fs[++ft] = now;
				now = bs[bt--];
			}else if(input[0].equals("FORWARD")) {
				if(ft==-1) {
					System.out.println("Ignored");
					continue;
				}
				bs[++bt] = now;
				now = fs[ft--];
			}else if(input[0].equals("QUIT")) {
				break;
			}else {
				bs[++bt] = now;
				now = input[1];
				ft = -1;
			}
			System.out.println(now);
		}
	}
}
