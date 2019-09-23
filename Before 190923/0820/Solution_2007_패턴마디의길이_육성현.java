import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_2007_패턴마디의길이_육성현{
	static String input;
	static int len;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			input = br.readLine();
			System.out.println("#"+(i+1)+" "+check());
		}
	}
	public static int check() {
		char[] arr = new char[10];
		for(int i=0;i<10;i++) {
			boolean vec = true;
			String sub = input.substring(0, i+1);
			for(int j=1;j<20/(i+1);j++) {
//				System.out.println(input.substring(j*(i+1), (j+1)*(i+1)));
				if(!sub.equals(input.substring(j*(i+1), (j+1)*(i+1)))) {
					vec = false;
					break;
				}
//				System.out.println(input.substring(j,j+i+1));
			}
			if(vec) {
//				System.out.println(sub);
				return (i+1);
			}
		}
		return -1;
	}
}