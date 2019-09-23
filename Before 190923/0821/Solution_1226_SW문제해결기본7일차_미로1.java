import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution{
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int pos;
	static int[][] map;
	static Pair start;
	static Pair end;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<10;i++) {
			int T = Integer.parseInt(br.readLine());
			pos = 0;
			map = new int[16][16];
			for(int j=0;j<16;j++) {
				String input = br.readLine();
				for(int k=0;k<16;k++) {
					map[j][k] = input.charAt(k)-'0';
					if(map[j][k]==2) {
						start = new Pair(j,k);
					}else if(map[j][k]==3) {
						end = new Pair(j,k);
					}
				}
			}
			travel();
			System.out.println("#"+T+" "+pos);
		}
	}
	public static void travel() {
		boolean[][] visited = new boolean[16][16];
		Pair[] s = new Pair[256];
		int top = -1;
		s[++top] = start;
		visited[start.y][start.x]=true;
		while(top!=-1) {
			Pair here = s[top--];
			if(map[here.y][here.x]==3) {
				pos=1;
				return;
			}
			for(int i=0;i<4;i++) {
				int newy=here.y+dy[i];
				int newx=here.x+dx[i];
				if(newy<0||newx<0||newx==16||newy==16||map[newy][newx]==1||visited[newy][newx]) continue;
				s[++top] = new Pair(newy,newx);
				visited[newy][newx]=true;
			}
		}
	}
}