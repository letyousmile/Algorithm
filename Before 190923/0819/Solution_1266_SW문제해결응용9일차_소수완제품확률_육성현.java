import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

class Solution_1266_SW문제해결응용9일차_소수완제품확률_육성현{
	static int A;
	static int B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(comb(6,2));
		int T= Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] input = br.readLine().split(" ");
			A = Integer.parseInt(input[0]);
			B = Integer.parseInt(input[1]);
			System.out.print("#"+(i+1)+" ");
			System.out.printf("%.6f\n",prime());
		}
	}
	public static double prime() {
		double pA = make(A);
		double pB = make(B);
		return (pA * (1-pB)) + ((1-pA) * pB) + (pA*pB);
	}
	public static double make(int p) {
		double rp = (double)p/100;
		return func(2,rp)+func(3,rp)+func(5,rp)+func(7,rp)+func(11,rp)+func(13,rp)+func(17,rp);
	}
	public static double comb(int n,int r) {
		if(r==0) return 1.0;
		if(n==r) return 1.0;
		else if (n>0&&r>0) return comb(n-1,r-1) + comb(n-1,r);
		else return -1;
	}
	public static double func(int num, double p) {
		double result = comb(18,num);
		for(int i=0;i<num;i++) {
			result *=p;
		}
		for(int i=0;i<18-num;i++) {
			result *=(1-p);
//			if(num==3) System.out.println(result);
		}
		return result;
	}
}