import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4301_콩많이심기_육성현 {
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);

			sb.append("#" + (i + 1) + " " + func() + "\n");
		}
		System.out.print(sb);
	}

	public static int func() {
		int result = 0;
		int vec = 0;
		for(int i=0;i<N;i++) {
			vec = 0;
			for(int j=0;j<M;j++) {
//				System.out.println(i+" "+j);
				if((i%4==2||i%4==3)&&j==0) {
					j+=1;
					continue;
				}
				if(vec==2) {
					j+=1;
					vec=0;
					continue;
				}
				result++;
				vec++;
//				System.out.println(result);
			}
		}
		return result;
	}
}
