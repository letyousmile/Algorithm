import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_15683_감시_육성현{
	static class Tv{
		int y;
		int x;
		int w;
		public Tv(int y, int x, int w) {
			super();
			this.y = y;
			this.x = x;
			this.w = w;
		}
		
	}
	
	static Tv[] tv = new Tv[8];
	static int numOfTv;
	static int[] list;
	static int N,M;
	static int[][] map;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr=br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		min = N*M;
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j]!=0&&map[i][j]!=6) {
					tv[numOfTv++] = new Tv(i,j,map[i][j]);
				}
			}
		}
		list = new int[numOfTv];
		backtrack(0);
		System.out.println(min);
	}
	public static void watch() {
		// 0 남쪽, 1 동쪽, 2 북쪽 ,3 서쪽
		boolean[][] visited = new boolean[N][M];
		int[] dy = {1,0,-1,0};
		int[] dx = {0,1,0,-1};
		for(int i=0;i<numOfTv;i++) {
			Tv tv1 = tv[i];
			int d = list[i];
			int y;
			int x;
			switch (tv1.w) {
			case 1:
				y=tv1.y;
				x=tv1.x;
				while(x>=0&&y>=0&&x<M&&y<N) {
					if(map[y][x]==6) break;
					visited[y][x]=true;
					y+=dy[d];
					x+=dx[d];
				}
				break;
			case 2:
				y=tv1.y;
				x=tv1.x;
				while(x>=0&&y>=0&&x<M&&y<N) {
					if(map[y][x]==6) break;
					visited[y][x]=true;
					y+=dy[d];
					x+=dx[d];
				}
				y=tv1.y;
				x=tv1.x;
				while(x>=0&&y>=0&&x<M&&y<N) {
					if(map[y][x]==6) break;
					visited[y][x]=true;
					y+=(dy[d]*-1);
					x+=(dx[d]*-1);
				}
				break;
			case 3:
				y=tv1.y;
				x=tv1.x;
				while(x>=0&&y>=0&&x<M&&y<N) {
					if(map[y][x]==6) break;
					visited[y][x]=true;
					y+=dy[d];
					x+=dx[d];
				}
				y=tv1.y;
				x=tv1.x;
				d=(d+1)%4;
				while(x>=0&&y>=0&&x<M&&y<N) {
					if(map[y][x]==6) break;
					visited[y][x]=true;
					y+=dy[d];
					x+=dx[d];
				}
				break;
			case 4:
				y=tv1.y;
				x=tv1.x;
				while(x>=0&&y>=0&&x<M&&y<N) {
					if(map[y][x]==6) break;
					visited[y][x]=true;
					y+=dy[d];
					x+=dx[d];
				}
				y=tv1.y;
				x=tv1.x;
				d=(d+1)%4;
				while(x>=0&&y>=0&&x<M&&y<N) {
					if(map[y][x]==6) break;
					visited[y][x]=true;
					y+=dy[d];
					x+=dx[d];
				}
				y=tv1.y;
				x=tv1.x;
				d=(d+1)%4;
				while(x>=0&&y>=0&&x<M&&y<N) {
					if(map[y][x]==6) break;
					visited[y][x]=true;
					y+=dy[d];
					x+=dx[d];
				}
				break;
			case 5:
				for(int j=0;j<4;j++) {
					y=tv1.y;
					x=tv1.x;
					while(x>=0&&y>=0&&x<M&&y<N) {
						if(map[y][x]==6) break;
						visited[y][x]=true;
						y+=dy[j];
						x+=dx[j];
					}
				}
				break;
			default:
				break;
			}
		}
		int num=0;
//		System.out.println();
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(visited[i][j]) {
//					System.out.print(7+ " ");
//				}
//				else if(map[i][j]==6) {
//					System.out.print(map[i][j]+" ");
//				}else {
//					System.out.print(map[i][j]+" ");
//				}
//				
//			}
//			System.out.println();
//		}
//		System.out.println();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]&&map[i][j]!=6) {
					num++;
				}
			}
		}
		if(num<min) min = num;
	}
	public static void backtrack(int loc) {
		if(loc==numOfTv) {
			watch();
		}else {
			if(tv[loc].w==2) {
				for(int i=0;i<2;i++) {
					list[loc]=i;
					backtrack(loc+1);
				}
			}else if(tv[loc].w==5) {
				list[loc]=0;
				backtrack(loc+1);
			}else {
				for(int i=0;i<4;i++) {
					list[loc]=i;
					backtrack(loc+1);
				}
			}
		}
	}
}
