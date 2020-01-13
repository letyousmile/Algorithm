import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_3074_입국심사_육성현 {
	static long N, M;
	static long min;
	static long[] q = new long[100000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String[] srr = br.readLine().split(" ");
			N = Long.parseLong(srr[0]);
			M = Long.parseLong(srr[1]);
			min = Long.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				q[j] = Long.parseLong(br.readLine());
				if(q[j]<min) min = q[j];
			}
			sb.append("#" + (i + 1) + " " + func() + "\n");
		}
		System.out.print(sb);
	}
	public static long func() {
		long start = 0;
		long end = min*M;
		long mid = 0;
		long p =0;
		while(start<end) {
			p = 0;
			mid = (end+start)/2;
			for(int i=0;i<N;i++) {
				p+=mid/q[i];
			}
			if(p==M) {
				end = mid;
//				while(true) {
//					p = 0;
//					mid--;
//					for(int i=0;i<N;i++) {
//						p+=mid/q[i];
//					}
//					if(mid<0||p!=M) {
//						return mid+1;
//					}
//				}
			}else if(p>M) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return start;
	}
}
