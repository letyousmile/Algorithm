import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution{
	static class Pair{
		int y;
		int x;
		String s = new String("");
		int m = 0;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static char[][] map = new char[4][4];
	static int num;
	static Set<String> set;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			set = new HashSet<>();
			for(int j=0;j<4;j++) {
				String[] input = br.readLine().split(" ");
				for(int k=0;k<4;k++) {
					map[j][k] = input[k].charAt(0);
				}
			}
			travel();
			System.out.println("#"+(i+1)+" "+set.size());
		}
	}
	public static void travel() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				bfs(i,j);
			}
		}
	}
	public static void bfs(int y,int x) {
		Pair start = new Pair(y,x);
		start.s=start.s+map[y][x];
//		System.out.println(start.s);
		start.m = 1;
		Pair[] q = new Pair[10000];
		int f = -1;
		int r = -1;
		q[++r] = start;
		while(f!=r) {
			Pair here = q[++f];
//			System.out.println(here.s);

			if(here.m==7) {
				set.add(here.s);
				continue;
			}
			for(int i=0;i<4;i++) {
				int newy=here.y+dy[i];
				int newx=here.x+dx[i];
				if(newy<0||newx<0||newy==4||newx==4) continue;
				Pair there = new Pair(newy,newx);
				there.s=here.s+map[newy][newx];
//				System.out.println(there.s);
				there.m = here.m+1;
				q[++r] = there;
			}
		}
	}
}