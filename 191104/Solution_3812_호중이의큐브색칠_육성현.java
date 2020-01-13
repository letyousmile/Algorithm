import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3812_호중이의큐브색칠_육성현 {
	static int X,Y,Z,A,B,C,N;
	static long[][] answer;
	static long[] temp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			String[] input = br.readLine().split(" ");
			X = Integer.parseInt(input[0]);
			Y = Integer.parseInt(input[1]);
			Z = Integer.parseInt(input[2]);
			A = Integer.parseInt(input[3]);
			B = Integer.parseInt(input[4]);
			C = Integer.parseInt(input[5]);
			N = Integer.parseInt(input[6]);
			func();
			sb.append("#"+(i+1)+" ");
			for(int j=0;j<N;j++) {
				sb.append(answer[4][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static void func() {
		answer = new long[5][N];
		for(int i=0;i<X;i++) {
			answer[0][Math.abs(i-A)%N]++;
		}
		for(int i=0;i<Y;i++) {
			answer[1][Math.abs(i-B)%N]++;
		}
		for(int i=0;i<Z;i++) {
			answer[2][Math.abs(i-C)%N]++;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				answer[3][(i+j)%N] += answer[0][i]*answer[1][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				answer[4][(i+j)%N] += answer[3][i]*answer[2][j];
			}
		}
	}
}
