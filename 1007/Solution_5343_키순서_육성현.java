import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5343_키순서_육성현 {
	static int N,M;
	static int[][] small;
	static int[][] big;
	static int[] snum;
	static int[] bnum;
	static boolean[] visited;
	public static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().split(" ")[0]);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine().split(" ")[0]);
			M = Integer.parseInt(br.readLine().split(" ")[0]);
			small = new int[N+1][N];
			big = new int[N+1][N];
			snum = new int[N+1];
			bnum = new int[N+1];
			visited = new boolean[N+1];
			for(int j=0;j<M;j++) {
				String[] srr = br.readLine().split(" ");
				int s = Integer.parseInt(srr[0]);
				int l = Integer.parseInt(srr[1]);
				small[l][snum[l]++] = s;
				big[s][bnum[s]++] = l;
			}
			func();
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}
	public static void func() {
		result = 0;
		for(int i=1;i<=N;i++) {
			int x = up(i,new boolean[N+1])+down(i,new boolean[N+1]);
//			System.out.println(x+" "+i);
			if(x==N-1) result++;
		}
	}
	public static int up(int loc,boolean[] visited) {
		int temp = 0;
		for(int i=0;i<bnum[loc];i++) {
			if(visited[big[loc][i]]) continue;
			visited[big[loc][i]]=true;
			temp+=1+up(big[loc][i],visited);
		}
		return temp;
	}
	public static int down(int loc, boolean[] visited) {
		int temp = 0;
		for(int i=0;i<snum[loc];i++) {
			if(visited[small[loc][i]]) continue;
			visited[small[loc][i]]=true;
			temp+=1+down(small[loc][i],visited);
		}
		return temp;
	}
}
