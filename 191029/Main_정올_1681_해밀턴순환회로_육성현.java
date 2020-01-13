import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_1681_해밀턴순환회로_육성현 {
	static int N;
	static int[][] map;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		min = N*100;
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		deliver(0,0,0, new boolean[N]);
		System.out.println(min);
	}
	public static void deliver(int cost, int loc, int num, boolean[] visited) {
		if(cost>min) return;
		else if(num==N-1) {
			if(map[loc][0]==0) return;
			cost = cost + map[loc][0];
			if(min>cost) {
				min = cost;
			}
		}
		else {
			for(int i=1;i<N;i++) {
				if(!visited[i]&&map[loc][i]!=0) {
					visited[i] = true;
					deliver(cost+map[loc][i],i,num+1,visited);
					visited[i] = false;
				}
			}
		}
	}
}
