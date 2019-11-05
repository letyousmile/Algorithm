import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3289_서로소집합_육성현 {
	static int[] p = new int[1000001];
	static int[] rank = new int[1000001];
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			sb.append("#"+(i+1)+" ");
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[0]);
			M = Integer.parseInt(srr[1]);
			init();
			for(int j=0;j<M;j++) {
				String[] input = br.readLine().split(" ");
				int o = Integer.parseInt(input[0]);
				int from = Integer.parseInt(input[1]);
				int to = Integer.parseInt(input[2]);
				
				if(o==0) {
					connect(from,to);
				}else if(o==1) {
					sb.append(check(from,to));
				}
				for(int k=1;k<=N;k++) {
					System.out.print(p[k]+" ");
				}
				System.out.println();
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static int parent(int x) {
//		System.out.println(x+" "+p[x]);
		if(p[x]!=x) {
			return p[x] = parent(p[x]);
		}else {
			return x;
		}
	}
	public static void func(int from, int to) {
		int p1 = p[from];
		int p2 = p[to];
		p[p2]=p1;
	}
	public static void connect(int from, int to) {
		if(parent(from)==parent(to)) {
			return;
		}else {
			func(from,to);
		}
	}
	public static char check(int from, int to) {
		if(parent(from)==parent(to)) return '1';
		else return '0';
	}
	public static void init() {
		for(int i=0;i<=N;i++) {
			p[i]=i;
			rank[i]=0;
		}
	}
}
