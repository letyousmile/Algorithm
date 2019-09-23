import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int N,L,R;
	static int[][] map;
	static int num = 0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N=Integer.parseInt(srr[0]);
		L=Integer.parseInt(srr[1]);
		R=Integer.parseInt(srr[2]);
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(input[j]);
			}
		}
		func();
		System.out.println(num);
	}
	public static void func() {
		boolean vec = false;
		boolean[][] visited = new boolean[N][N];
		int[][] team = new int[N][N];
		int[] p = new int[N*N];
		int teamNumber = -1;
		Pair[] q = new Pair[N*N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					++teamNumber;
					int f = -1;
					int r = -1;
					q[++r] = new Pair(i,j);
					int sum = map[i][j];
					visited[i][j] = true;
					team[i][j] = teamNumber;
					int l = 1;
					while(f!=r) {
						Pair here = q[++f];
						for(int k=0;k<4;k++) {
							int newy = here.y+dy[k];
							int newx = here.x+dx[k];
							if(newy<0||newx<0||newy==N||newx==N||visited[newy][newx]) continue;
							int v = Math.abs(map[newy][newx]-map[here.y][here.x]);
							if(v>=L&&v<=R) {
								q[++r] = new Pair(newy,newx);
								visited[newy][newx] = true;
								team[newy][newx] = teamNumber;
								vec = true;
								l++;
								sum+=map[newy][newx];
							}
						}
					}
					p[teamNumber] = sum/l;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = p[team[i][j]];
			}
		}
		if(vec) {
			func();
			num++;
		}
	}
}