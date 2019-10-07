import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_4963_섬의개수_육성현 {
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int[] dy= {0,0,1,-1,1,1,-1,-1};
	static int[] dx = {1,-1,0,0,1,-1,1,-1};
	static int w,h;
	static int[][] map = new int[50][50];
	static Pair[] q = new Pair[2500];
	static boolean[][] visited = new boolean[50][50];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] srr = br.readLine().split(" ");
			w = Integer.parseInt(srr[0]);
			h = Integer.parseInt(srr[1]);
			if(w==0||h==0) break;
			for(int i=0;i<h;i++) {
				String input = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j] = input.charAt(j*2)-'0';
					visited[i][j] = false;
				}
			}
			System.out.println(func());
		}
	}
	public static int func() {
		int num = 0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(visited[i][j]) continue;
				else if(map[i][j]==1){
					bfs(i,j);
					num++;
				}
			}
		}
		return num;
	}
	public static void bfs(int y,int x) {
//		System.out.println(y+" "+x);
		int f = -1;
		int r = -1;
		q[++f] = new Pair(y,x);
		visited[y][x] =true;
		while(f!=r) {
			Pair here = q[++r];
//			System.out.println(here.y+" "+here.x);
			for(int i=0;i<8;i++) {
				int newy = here.y+dy[i];
				int newx = here.x+dx[i];
				if(newy<0||newx<0||newy==h||newx==w||visited[newy][newx]||map[newy][newx]==0) continue;
				visited[newy][newx] = true;
				q[++f] = new Pair(newy,newx);
			}
		}
	}
}
