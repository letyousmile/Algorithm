import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int N,M,K;
	static int num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N=Integer.parseInt(input[0]);
		M=Integer.parseInt(input[1]);
		K=Integer.parseInt(input[2]);
		threeSixNine();
		System.out.println(num);
	}
	public static void threeSixNine() {
		int order = 0;
		for(int i=0;i<M;i++) {
			order = i%N;
			if(order==K&&check(i+1)) {
				num++;
			}
		}
	}
	public static boolean check(int x) {
		for(int i=2;i<=Math.sqrt(x);i++) {
			if(x%i==0) return false;
		}
		return true;
	}
}
