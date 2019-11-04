import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_1733_오목_육성현 {
	static int winner;
	static int y,x;
	static boolean[][][] visited = new boolean[19][19][4];
	static int[][] map = new int[19][19];
	static int[] dy= {1,1,1,0};
	static int[] dx= {-1,0,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<19;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<19;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		func();
		if(winner==0) {
			System.out.println(winner);
		}else {
			System.out.println(winner);
			System.out.println(y+" "+x);
		}
	}
	public static void func() {
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j]!=0) {
					int p =map[i][j];
					for(int k=0;k<4;k++) {
						if(visited[i][j][k]) continue;
						int num = 1;
						int newy=i+dy[k];
						int newx=j+dx[k];
						while(newy>=0&&newx>=0&&newy<19&&newx<19&&map[newy][newx]==p) {
							visited[newy][newx][k]=true;
							newy+=dy[k];
							newx+=dx[k];
							num++;
						}
						if(num==5) {
							winner = p;
							if(k==0) {
								y=newy;
								x=newx+2;
							}else {
								y = i+1;
								x = j+1;
							}
							return;
						}
					}
				}
			}
		}
	}
}
