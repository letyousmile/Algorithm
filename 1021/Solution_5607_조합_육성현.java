import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5607_조합_육성현 {
	static long[] fact = new long[1000001];
	static final int D = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		makeFact();
		for(int i=0;i<T;i++) {
			int N, R;
			String[] input = br.readLine().split(" ");
			
			N = Integer.parseInt(input[0]);
			R = Integer.parseInt(input[1]);
//			System.out.println(fact[R]);
//			System.out.println(pow(fact[R],D-2));
			long result = (fact[N]*pow(fact[R],D-2))%D;
//			System.out.println(result);
			result = (result * pow(fact[N-R],D-2))%D;
//			System.out.println(result);
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}
	public static long pow(long x, long y) {
//		System.out.println(x+" "+y);
		if(y==0) return 1;
		else if(y==1) return x%D;
		else if(y%2==0) return pow(x*x%D,y/2)%D;
		else return (x*pow(x*x%D,(y-1)/2))%D;
	}
	public static void makeFact() {
		for(int i=0;i<=100000;i++) {
			if(i>=1) {
				fact[i] = (fact[i-1]*i)%D;
			}else {
				fact[i] = 1;
			}
		}
	}
}
