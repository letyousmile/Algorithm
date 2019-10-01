import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2636_치즈_육성현 {
	static int R,C;
	static int[][] map;
	static class Obj{
		int y;
		int x;
		public Obj(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int time= 0;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {1,-1,0,0};
	static int total=0;
	static int[] num = new int[10000];
	static int remain;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		R = Integer.parseInt(srr[0]);
		C = Integer.parseInt(srr[1]);
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			String input = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = input.charAt(j*2)-'0';
				total+=map[i][j];
			}
		}
		bfs();
		System.out.println(time);
		System.out.println(remain);
	}
	public static void bfs() {
		Obj[] q = new Obj[R*C];
		boolean[][] visited = new boolean[R][C];
		boolean[][] melt = new boolean[R][C];
		int sum = 0;
		while(sum!=total) {
			remain = total-sum;
//			for(int i=0;i<R;i++) {
//				for(int j=0;j<C;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			time++;
			int f= -1;
			int r= -1;
			q[++r]=new Obj(0,0);
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(melt[i][j]&&map[i][j]==0) {
						visited[i][j]=true;
						q[++r]=new Obj(i,j);
					}
				}
			}
			while(r!=f) {
				Obj here = q[++f];
				if(map[here.y][here.x]==1) {
					sum++;
					map[here.y][here.x]=0;
					melt[here.y][here.x]=true;
					continue;
				}
				for(int i=0;i<4;i++) {
					int y = here.y+dy[i];
					int x = here.x+dx[i];
					if(y<0||x<0||y==R||x==C||visited[y][x]) continue;
					visited[y][x]=true;
					q[++r] = new Obj(y,x);
				}
			}
		}
	}
}
