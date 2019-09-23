import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_15686_치킨배달_육성현{
	static class Ch{
		int y;
		int x;
		public Ch(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static class Home{
		int y;
		int x;
		int d = 0;
		public Home(int y, int x) {
			this.y = y;
			this.x = x;
		}
		public Home(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
	static Ch[] chosen;
	static Ch[] ch = new Ch[13];
	static Home[] home;
	static int N,M;
	static int[][] map;
	static int numOfCh = 0;
	static int numOfHome = 0;
	static int min = 10001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr=br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		home = new Home[2*N];
		map = new int[N][N];
		chosen = new Ch[M];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j]==2) {
					ch[numOfCh++] = new Ch(i,j);
				}else if(map[i][j]==1) {
					home[numOfHome++] = new Home(i,j);
				}
			}
		}
		backtrack(0,0);
		System.out.println(min);
	}
	public static void cal() {
		int sum = 0;
		for(int i=0;i<numOfHome;i++) {
			int temp = 100;
			Home start = home[i];
			for(int j=0;j<M;j++) {
				Ch chicken = chosen[j];
				int d = Math.abs(start.y-chicken.y)+Math.abs(start.x-chicken.x);
				if(d<temp) temp = d;
			}
			sum+=temp;
		}
		if(sum<min) {
			min = sum;
		}
	}
	public static void backtrack(int loc,int num) {
		if(num==M) {
			cal();
		}else {
			for(int i=loc;i<numOfCh;i++) {
				chosen[num] = ch[i];
				backtrack(i+1,num+1);
			}
		}
	}
}
