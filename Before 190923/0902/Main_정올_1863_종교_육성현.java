import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		n = Integer.parseInt(srr[0]);
		m = Integer.parseInt(srr[1]);
		List<Integer>[] graph = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			String[] input = br.readLine().split(" ");
			int from;
			int to;
			from = Integer.parseInt(input[0]);
			to = Integer.parseInt(input[1]);
//			System.out.println(from+" "+to);
			graph[from].add(to);
			graph[to].add(from);
		}
		int num = 0;
		boolean[] visited = new boolean[n+1];
		int[] q = new int[50000];
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				num++;
				int f = -1;
				int r = -1;
				q[++r]=i;
				visited[i] = true;
				while(f!=r) {
					int here = q[++f];
//					System.out.println(here);
					for(int j=0;j<graph[here].size();j++) {
						if(!visited[graph[here].get(j)]) {
							visited[graph[here].get(j)]=true;
							q[++r]=graph[here].get(j);
						}
					}
				}
			}
		}
		System.out.println(num);
	}
}
