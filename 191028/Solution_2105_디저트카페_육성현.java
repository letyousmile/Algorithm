import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2105_디저트카페_육성현 {
	static int result;
	static int N;
	static int[] dy = { 1, 1, -1, -1 };
	static int[] dx = { 1, -1, -1, 1 };
	static Person[] q = new Person[10000];

	static class Person {
		int y;
		int x;
		int d;
		int r;
		int c;
		int l;
		boolean[] visited = new boolean[101];

		public Person(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Person [y=" + y + ", x=" + x + ", d=" + d + ", r=" + r + ", c=" + c + ", l=" + l + ", visited="
					+ Arrays.toString(visited) + "]";
		}

	}

	static int[][] map = new int[20][20];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			input();
			dessert();
			sb.append("#" + (i + 1) + " " + result + "\n");
		}
		System.out.print(sb);
	}

	public static void dessert() {
		for (int i = 0; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				search(i, j);
			}
		}
	}

	public static void search(int y, int x) {
		Person start = new Person(y, x, 0);
		start.visited[map[y][x]] = true;
		start.r = 0;
		start.c = 0;
		start.l =1;
		int f = -1;
		int r = -1;
		q[++r] = start;
		while (f != r) {
			Person here = q[++f];
			if (here.r == 0 && here.c == 1 && here.d == 3) {
				if (here.l > result) {
					result = here.l;
					continue;
				}
			}else if(here.r==0&&here.c==0 &&here.d==3 &&here.y==y&&here.x==x) {
				if (here.l > result) {
					result = here.l;
					continue;
				}
			}
			// 매 순간 꺽거나 진행하거나
			// 진행
			int d = here.d;
			int newy = here.y + dy[d];
			int newx = here.x + dx[d];
			if (newy >= 0 && newx >= 0 && newy < N && newx < N && !here.visited[map[newy][newx]]) {
				Person there = new Person(newy, newx, d);
				System.arraycopy(here.visited, 0, there.visited, 0, 101);
				there.visited[map[newy][newx]] = true;
				there.l = here.l + 1;
				if (d == 0) {
					there.r = here.r + 1;
					there.c=here.c;
				} else if (d == 1) {
					there.r=here.r;
					there.c = here.c + 1;
				} else if (d == 2) {
					there.r = here.r - 1;
					there.c=here.c;
				} else if (d == 3) {
					there.r=here.r;
					there.c = here.c - 1;
				}else {
					there.r=here.r;
					there.c=here.c;
				}
				q[++r] = there;
			}
			
			// 꺽어주기
			if (!(d==0&&here.l==1)&&d != 3) {
				d = here.d + 1;
				newy = here.y + dy[d];
				newx = here.x + dx[d];
				if(d==3&&here.c==1&&here.r==0&&newy >= 0 && newx >= 0 && newy < N && newx < N) {
					Person there = new Person(newy, newx, d);
					there.l = here.l;
					there.c = here.c -1;
					q[++r] = there;
				}
				if (newy >= 0 && newx >= 0 && newy < N && newx < N && !here.visited[map[newy][newx]]) {
					Person there = new Person(newy, newx, d);
					System.arraycopy(here.visited, 0, there.visited, 0, 101);
					there.visited[map[newy][newx]] = true;
					there.l = here.l + 1;
					if (d == 0) {
						there.r = here.r + 1;
						there.c=here.c;
					} else if (d == 1) {
						there.c = here.c + 1;
						there.r=here.r;
					} else if (d == 2) {
						there.r = here.r - 1;
						there.c=here.c;
					} else if (d == 3) {
						there.c = here.c - 1;
						there.r=here.r;
					}else {
						there.r=here.r;
						there.c=here.c;
					}
					q[++r] = there;
				}
			}
		}
	}

	public static void input() throws NumberFormatException, IOException {
		result = -1;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] srr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
			}
		}
	}
}
