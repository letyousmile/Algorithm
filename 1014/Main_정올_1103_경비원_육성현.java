import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_1103_경비원_육성현 {
	static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Pair[] pair;
	static int N, M, T;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		T = Integer.parseInt(br.readLine());
		pair = new Pair[T + 1];
		for (int i = 0; i <= T; i++) {
// System.out.println(i);
			String[] input = br.readLine().split(" ");
			int d = Integer.parseInt(input[0]);
			int s = Integer.parseInt(input[1]);
// pair[i] = new Pair(d,s);
			if (d == 1) {
				pair[i] = new Pair(M, s);
			} else if (d == 2) {
				pair[i] = new Pair(0, s);
			} else if (d == 3) {
				pair[i] = new Pair(M - s, 0);
			} else if (d == 4) {
				pair[i] = new Pair(M - s, N);
			}
		}
		guard();
		System.out.println(result);
	}

	public static void guard() {
		int t = 2 * N + 2 * M;
		for (int i = 0; i < T; i++) {
			int y = pair[T].y;
			int x = pair[T].x;
			int r = 0;
			int d = -1;
			if(y==0) {
				d = 0;
			}else if(x==0) {
				d = 3;
			}else if(y==M) {
				d = 2;
			}else if(x==N) {
				d = 1;
			}
			int y2 = pair[i].y;
			int x2 = pair[i].x;
			while (x != x2 || y != y2) {
//					System.out.println(x + " " + y + " " + r + " " + d);
				if (x == N && d == 0) {
					if (y == M)
						d = 3;
					else
						d = 1;
				} else if (y == M && d == 1) {
					if (x == 0)
						d = 1;
					else
						d = 2;
				} else if (x == 0 && d == 2) {
					if (y == M)
						d = 3;
					else
						d = 1;
				} else if (y == 0 && d == 3) {
					if (x == N)
						d = 2;
					else
						d = 0;
				}
				x = x + dx[d];
				y = y + dy[d];
				r++;
			}
//			System.out.println(r);
			if (t - r < r) r = t - r;
			result += r;
		}
	}
}