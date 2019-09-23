import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int[][] map = new int[1000][1000];
	static int max;
	static int start;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			for(int j=0;j<N;j++) {
				String[] input = br.readLine().split(" ");
				for(int k=0;k<N;k++) {
					map[j][k] = Integer.parseInt(input[k]);
				}
			}
			max = Integer.MIN_VALUE;
			search();
			System.out.println("#"+(i+1)+" "+start+" "+max);
		}
	}
	public static int move(int y,int x) {
		int now = map[y][x];
		for(int i=0;i<4;i++) {
			int newy = y+dy[i];
			int newx = x+dx[i];
			if(newy<0||newx<0||newy==N||newx==N) continue;
			if(map[newy][newx]==now+1) {
				return 1+move(newy,newx);
			}
		}
		return 1;
	}
	public static void search() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int s = map[i][j];
				int num = move(i,j);
				if(num>max) {
					max = num;
					start = s;
				}else if(num==max&&start>s) {
					start = s;
				}
			}
		}
	}
}
