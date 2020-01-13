import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_7396_종구의딸이름짓기_육성현 {
	static class Pair{
		int y;
		int x;
		int lev;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		public Pair(int y, int x, int lev) {
			super();
			this.y = y;
			this.x = x;
			this.lev = lev;
		}
		
	}
	static int[] dy = {0,1};
	static int[] dx = {1,0};
    static int N,M;
    static String result;
    static boolean[][] visited = new boolean[2000][2000];
    static char[][] map = new char[2000][2001];
    static Pair[] q = new Pair[4000000];
    static char[] lev = new char[4000];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
            String[] srr = br.readLine().split(" ");
            N = Integer.parseInt(srr[0]);
            M = Integer.parseInt(srr[1]);
            for(int j=0;j<N;j++) {
                map[j] = br.readLine().toCharArray();
            }
            result = new String();
            func2();
            sb.append("#"+(i+1)+" "+result+"\n");
        }
        System.out.print(sb);
    }
    public static void func2() {
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			visited[i][j]=false;
    		}
    	}
    	for(int i=0;i<N+M;i++) {
    		lev[i] = 'z';
    	}
    	int f = -1;
    	int r = -1;
    	Pair start = new Pair(0,0);
    	start.lev = 0;
    	lev[0] = map[0][0];
    	q[++r] = start;
    	while(f!=r) {
    		Pair here = q[++f];
    		if(map[here.y][here.x]>lev[here.lev]) continue;
    		for(int i=0;i<2;i++) {
    			int newy = here.y+dy[i];
    			int newx = here.x+dx[i];
    			int newl = here.lev+1;
    			if(newy==N||newx==M||visited[newy][newx]||map[newy][newx]>lev[newl]) continue;
    			q[++r] = new Pair(newy,newx,newl);
    			visited[newy][newx]=true;
    			lev[newl] = map[newy][newx];
    		}
    	}
    	for(int i=0;i<M+N-1;i++) {
    		result = result+lev[i];
    	}
    }
}