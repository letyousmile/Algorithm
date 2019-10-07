import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_1249_보급로_육성현 {
	static class Pair implements Comparable<Pair>{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Integer.valueOf(d[this.y][this.x]).compareTo(d[o.y][o.x]);
		}
	}
	static int[][] d = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	static int min;
	static int N;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int[][] map = new int[100][100];
	static Pair[] pair = new Pair[1000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			min = 0;
			N = Integer.parseInt(br.readLine());
			for(int j=0;j<N;j++) {
				String input = br.readLine();
				for(int k=0;k<N;k++) {
					map[j][k] = input.charAt(k)-'0';
					visited[j][k] = false;
				}
			}
//			System.out.println(min);
			dijkstra();
//			System.out.println(min);
			sb.append("#"+(i+1)+" "+d[N-1][N-1]+"\n");
		}
		System.out.print(sb);
	}
	public static void dijkstra() {
		int min = N*N*9;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				d[i][j] = min; 
			}
		}
		d[0][0] = 0;
		boolean[][] visited = new boolean[N][N];
		visited[0][0]=true;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0,0));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int y = p.y;
			int x = p.x;
			for(int i=0;i<4;i++) {
				int newy = y+dy[i];
				int newx = x+dx[i];
				if(newy<0||newx<0||newy==N||newx==N||visited[newy][newx]) continue;
				d[newy][newx] = Math.min(d[newy][newx],d[y][x]+map[newy][newx]);
				pq.add(new Pair(newy,newx));
				visited[newy][newx]=true;
			}
		}
	}
}
