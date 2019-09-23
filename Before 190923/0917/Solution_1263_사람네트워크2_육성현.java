import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int min;
	static int N;
	static int[][] map = new int[1000][1000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=T;i++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					map[j][k] = Integer.parseInt(input[1+(j*N)+k]);
					if(j!=k&&map[j][k]==0) map[j][k] = N+1;
				}
			}
			min = Integer.MAX_VALUE;
			fluid();
			sb.append("#"+i+" "+min+"\n");
		}
		System.out.println(sb);
	}
	public static void fluid() {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
				}
			}
		}
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int j=0;j<N;j++) {
				sum+=map[i][j];
			}
			if(sum<min) min = sum;
		}
	}
}
