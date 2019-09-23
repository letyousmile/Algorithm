import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14501_퇴사_육성현 {
	static int N;
	static int[] T;
	static int[] P;
	static int[] cache;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		cache = new int[N];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			T[i] = Integer.parseInt(input[0]);
			P[i] = Integer.parseInt(input[1]);
		}
		init();
		System.out.println(work(0));
	}
	public static void init() {
		for(int i=0;i<N;i++) {
			cache[i] = -1;
		}
	}
	public static int work(int loc) {
		if(loc==N) return 0;
		if(loc>N) return -15000;
		if(cache[loc]!=-1) return cache[loc];
		return cache[loc] = max(P[loc]+work(loc+T[loc]),work(loc+1));
	}
	public static int max(int a,int b) {
		return a>b?a:b;
	}
}
