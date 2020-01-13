import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1987_알파벳_육성현 {
	static int R,C;
	static int max;
	static int[][] map;
	static boolean[] visited = new boolean[26];
	static int time= 0;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		R = Integer.parseInt(srr[0]);
		C = Integer.parseInt(srr[1]);
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			String input = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		visited[map[0][0]]=true;
		dfs(0,0,1);
		System.out.println(max);
	}
	public static void dfs(int y,int x,int time) {
		for(int i=0;i<4;i++) {
			int newy = y +dy[i];
			int newx = x + dx[i];
			if(newy<0||newx<0||newy==R||newx==C||visited[map[newy][newx]]) continue;
			visited[map[newy][newx]]=true;
			dfs(newy,newx,time+1);
			visited[map[newy][newx]]=false;
		}
		if(time>max) max = time;
	}
}
