import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_6109_추억의2048게임_육성현 {
	static int N;
	static String order;
	static int[][] map = new int[20][20];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[0]);
			order = srr[1];
			for (int j = 0; j < N; j++) {
				String[] input = br.readLine().split(" ");
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(input[k]);
				}
			}
//			print();
			func();
			sb.append("#"+(i+1)+"\n");
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					sb.append(map[j][k]+" ");
				}
				sb.append("\n");
			}
//			print();
		}
		System.out.print(sb);
	}
	public static void print() {
		for(int j=0;j<N;j++) {
			for(int k=0;k<N;k++) {
				System.out.print(map[j][k]+" ");
			}
			System.out.println();
		}
		
	}
	public static void func() {
		if (order.equals("up")) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						int x = 1;
						while (i + x < N && map[i + x][j] == 0) {
							x++;
						}
						if (i + x != N) {
							for (int k = 0; i+x+k<N; k++) {
								map[i + k][j] = map[i + x + k][j];
								map[i + k + x][j] = 0;
							}
						}
					}
				}
			}
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						int x = 1;
						while (i + x < N && map[i + x][j] == 0) {
							x++;
						}
//						System.out.println(x);
						if (i + x != N) {
							for (int k = 0; i+x+k<N; k++) {
								map[i + k][j] = map[i + x + k][j];
								map[i + k + x][j] = 0;
							}
						}
//						System.out.println(i+" "+j);
//						print();
					}
					if (map[i][j] == map[i + 1][j]) {
						map[i][j] = 2*map[i][j];
						map[i+1][j] = 0;
					}
				}
			}
		} else if (order.equals("down")) {
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						int x = 1;
						while (i - x >= 0 && map[i - x][j] == 0) {
							x++;
						}
						if (i - x >= 0) {
							for (int k = 0; i-x-k>=0; k++) {
								map[i - k][j] = map[i - x - k][j];
								map[i - k - x][j] = 0;
							}
						}
					}
				}
			}
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						int x = 1;
						while (i - x >= 0 && map[i - x][j] == 0) {
							x++;
						}
//						System.out.println(x);
						if (i -x >=0) {
							for (int k = 0; i-x-k>=0; k++) {
								map[i - k][j] = map[i - x - k][j];
								map[i - k - x][j] = 0;
							}
						}
//						System.out.println(i+" "+j);
//						print();
					}
					if (map[i][j] == map[i - 1][j]) {
						map[i][j] = 2*map[i][j];
						map[i-1][j] = 0;
					}
				}
			}
		} else if (order.equals("left")) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if (map[i][j] == 0) {
						int x = 1;
						while (j + x < N && map[i][j+x] == 0) {
							x++;
						}
						if (j + x != N) {
							for (int k = 0; j+x+k<N; k++) {
								map[i][j+k] = map[i][j+x+k];
								map[i][j+x+k] = 0;
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if (map[i][j] == 0) {
						int x = 1;
						while (j + x < N && map[i][j+x] == 0) {
							x++;
						}
//						System.out.println(x);
						if (j + x != N) {
							for (int k = 0; j+x+k<N; k++) {
								map[i][j+k] = map[i][j+x+k];
								map[i][j+k+x] = 0;
							}
						}
//						System.out.println(i+" "+j);
//						print();
					}
					if (map[i][j] == map[i][j+1]) {
						map[i][j] = 2*map[i][j];
						map[i][j+1] = 0;
					}
				}
			}
		} else if (order.equals("right")) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0; j--) {
					if (map[i][j] == 0) {
						int x = 1;
						while (j - x >= 0 && map[i][j-x] == 0) {
							x++;
						}
						if (j - x >= 0) {
							for (int k = 0; j-x-k>=0; k++) {
								map[i][j-k] = map[i][j-x-k];
								map[i][j-k-x] = 0;
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0; j--) {
					if (map[i][j] == 0) {
						int x = 1;
						while (j - x >= 0 && map[i][j-x] == 0) {
							x++;
						}
//						System.out.println(x);
						if (j -x >=0) {
							for (int k = 0; j-x-k>=0; k++) {
								map[i][j-k] = map[i][j-k-x];
								map[i][j-k-x] = 0;
							}
						}
//						System.out.println(i+" "+j);
//						print();
					}
					if (map[i][j] == map[i][j-1]) {
						map[i][j] = 2*map[i][j];
						map[i][j-1] = 0;
					}
//					System.out.println(i+" "+j);
//					print();
				}
			}
		}
	}
}
