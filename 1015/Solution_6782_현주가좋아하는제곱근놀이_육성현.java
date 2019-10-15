import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_6782_현주가좋아하는제곱근놀이_육성현 {
	static long N;
	static long num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=T;i++) {
			N = Long.parseLong(br.readLine());
			num = 0;
			func();
			
			sb.append("#"+(i)+" "+num+"\n");
		}
		System.out.print(sb);
	}
	public static void func() {
		while(N!=2) {
			System.out.println(N);
			long a = (long)Math.sqrt(N);	
			if(a*a==N) {
				N = a;
				num++;
			}else if((a-1*a-1)==N) {
				N = a-1;
				num++;
			}
			else {
				num += (a+1)*(a+1)-N;
				N = (a+1)*(a+1);
			}
		}
	}
}
