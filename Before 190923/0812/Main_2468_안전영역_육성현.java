import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int N;
	static int[][] map;
	static int m = 1;
	static int min;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		
		N = Integer.parseInt(srr[0]);
		map = new int[N][N];
		min = 100;
		max = 0;
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(input[j]);
				if(map[i][j]<min) min = map[i][j];
				if(map[i][j]>max) max = map[i][j];
			}
		}
		jangma();
		System.out.println(m);
	}
	public static void jangma() {
		for(int i=min;i<max;i++) {
			bfs(i);
		}
	}
	public static void bfs(int h) {
		boolean[][] visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]<=h) {
					visited[i][j]=true;
				}
			}
		}
		Pair[] q = new Pair[N*N];
		int f = -1;
		int r = -1;
		int num = 0;
		int[] dy = {0,0,1,-1};
		int[] dx = {1,-1,0,0};
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					visited[i][j]=true;
					num++;
					q[++r] = new Pair(i,j);
				}
				while(f!=r) {
					Pair here = q[++f];
					for(int k=0;k<4;k++) {
						int newy=here.y+dy[k];
						int newx=here.x+dx[k];
						if(newy<0||newx<0||newy==N||newx==N) continue;
						if(!visited[newy][newx]) {
							visited[newy][newx]=true;
							q[++r] = new Pair(newy,newx);
						}
					}
				}
			}
		}
		if(num>m) m = num;
	}
}
