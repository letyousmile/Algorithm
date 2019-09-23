import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static Long N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			N = Long.parseLong(br.readLine());
			int turn = game2();
			System.out.print("#"+(i+1)+" ");
			if(turn%2==1) {
				System.out.println("Bob");
			}else {
				System.out.println("Alice");
			}
		}
	}
	public static int game2() {
		if(N==1) return 1;
		long start = 2;
		long end = 2;
		int vec = 1;
		while(end<=N) {
			start = end;
			end = 2+((8*(pow(vec++)-1))/3);
		}
		if(N<(start+end)/2) {
			return 0;
		}else {
			return 1;
		}
	}
	public static long pow(int n) {
		long result = 1;
		for(int i=0;i<n;i++) {
			result*=4;
		}
		return result;
	}
}
