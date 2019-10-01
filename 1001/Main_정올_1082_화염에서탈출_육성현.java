import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_정올_1082_화염에서탈출_육성현 {
	static int R,C;
	static char[][] map;
	static class Obj{
		int y;
		int x;
		int t=0;
		boolean isPerson=false;
		public Obj(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		public Obj(int y, int x, int t, boolean isPerson) {
			super();
			this.y = y;
			this.x = x;
			this.t = t;
			this.isPerson = isPerson;
		}
		
	}
	static List<Obj> fire = new ArrayList<>();
	static Obj person;
	static boolean[][] visited;
	static int endy;
	static int endx;
	static int time= -1;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		R = Integer.parseInt(srr[0]);
		C = Integer.parseInt(srr[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String input = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j]=='*') {
					visited[i][j]=true;
					fire.add(new Obj(i,j));
				}else if(map[i][j]=='S') {
					person = new Obj(i,j);
					person.isPerson=true;
					visited[i][j]=true;
				}else if(map[i][j]=='D') {
					endy=i;
					endx=j;
				}else if(map[i][j]=='X') {
					visited[i][j]=true;
				}
			}
		}
		bfs();
		if(time==-1) {
			System.out.println("impossible");
		}else {
			System.out.println(time);
		}
	}
	public static void bfs() {
		Obj[] q = new Obj[R*C];
		int f = -1;
		int r = -1;
		for(int i=0;i<fire.size();i++) {
			q[++r] = fire.get(i);
		}
		q[++r] = person;
		while(f!=r) {
			Obj here = q[++f];
//			System.out.println(here.y+" "+here.x);
//			if(here.isPerson) {
//				System.out.println("사람"+here.y+" "+here.x);
//			}
			if(here.y==endy&&here.x==endx) {
				time = here.t;
				break;
			}
			for(int i=0;i<4;i++) {
				int y=here.y+dy[i];
				int x = here.x+dx[i];
				boolean vec = here.isPerson;
				int t = here.t+1;
				if(y<0||x<0||y==R||x==C||visited[y][x]) continue;
				if(!here.isPerson&&y==endy&&x==endx) continue;
				q[++r]=new Obj(y,x,t,vec);
				visited[y][x]=true;
			}
		}
	}
}
