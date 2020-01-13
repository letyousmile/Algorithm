import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_6719_성수의프로그래밍강좌시청_육성현 {
	public static void main(String[] args) throws IOException {
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			int N, K;
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[0]);
			K = Integer.parseInt(srr[1]);
			int[] M = new int[N];
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				M[j] = Integer.parseInt(input[j]);
			}
			Arrays.sort(M);
			double result = 0;
			for(int j=0;j<K;j++) {
				result+=(double)M[N-K+j];
				result/=2;
			}
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}
}
