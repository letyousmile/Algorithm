import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14502_연구소_육성현{
	static class Virus{
		int y;
		int x;
		public Virus(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
	static int N,M;
	static int[][] map;
	static int total;
	static int numOfVirus;
	static int max;
	static Virus[] virus = new Virus[64];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		total = N*M;
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(input[j]);
				if(map[i][j]==1) total--;
				else if(map[i][j]==2) virus[numOfVirus++] = new Virus(i,j);
			}
		}
		backtrack();
		System.out.println(max);
	}
	public static void bfs() {
		int safe = total - 3;
		Virus[] q = new Virus[64];
		int[] dy = {0,0,1,-1};
		int[] dx = {1,-1,0,0};
		boolean[][] visited = new boolean[N][M];
		int f = -1;
		int r = -1;
		for(int i=0;i<numOfVirus;i++) {
			q[++r] = virus[i];
			visited[virus[i].y][virus[i].x] = true;
		}
		while(f!=r) {
			Virus here = q[++f];
			safe--;
			for(int i=0;i<4;i++) {
				int newy=here.y+dy[i];
				int newx=here.x+dx[i];
				if(newy<0||newx<0||newy==N||newx==M) {
					continue;
				}
				if(map[newy][newx]!=1&&!visited[newy][newx]) {
					q[++r] = new Virus(newy,newx);
					visited[newy][newx] = true;
				}
			}
		}
		if(safe>max) {
			max = safe;
		}
	}
	public static void backtrack() {
		for(int i=0;i<N*M;i++) {
			for(int j=i+1;j<N*M;j++) {
				for(int k=j+1;k<N*M;k++) {
					int y_1 = i/M;
					int x_1 = i%M;
					int y_2 = j/M;
					int x_2 = j%M;
					int y_3 = k/M;
					int x_3 = k%M;
					if(map[y_1][x_1]==0&&map[y_2][x_2]==0&&map[y_3][x_3]==0) {
						map[i/M][i%M] = 1;
						map[j/M][j%M] = 1;
						map[k/M][k%M] = 1;
						bfs();
						map[i/M][i%M] = 0;
						map[j/M][j%M] = 0;
						map[k/M][k%M] = 0;
					}
				}
			}
		}
	}
}
