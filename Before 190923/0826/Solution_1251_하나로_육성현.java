import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution{
	static class Node implements Comparable<Node>{
		int from;
		int to;
		double s;
		public Node(int from, int to, double s) {
			super();
			this.from = from;
			this.to = to;
			this.s = s;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Double.valueOf(this.s).compareTo(o.s);
		}
		@Override
		public String toString() {
			return "Node [s=" + s + "]";
		}
		
	}
	static class Pos{
		double x;
		double y;
		public Pos(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int V;
	static double E;
	static Node[] node;
	static double sum;
	static int num;
	static long[][] d;
	static long[] D;
	static int[] p;
	static double result;
	static Pos[] pos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			V = Integer.parseInt(br.readLine());
			d = new long[V][V];
			D = new long[V];
			node = new Node[(V*V-V)/2];
			pos = new Pos[V];
			p = new int[V+1];
			for(int j=0;j<=V;j++) {
				p[j] = j;
			}
			String[] srr = br.readLine().split(" ");
			String[] srr2 = br.readLine().split(" ");
			for(int j=0;j<V;j++) {
				pos[j] = new Pos(Double.parseDouble(srr[j]),Double.parseDouble(srr2[j]));
			}
			E = Double.parseDouble(br.readLine());
			int n=0;
			for(int j=0;j<V;j++) {
				for(int k=j+1;k<V;k++) {
					node[n++] =new Node(j,k,((pos[j].x-pos[k].x)*(pos[j].x-pos[k].x) +(pos[j].y-pos[k].y)*(pos[j].y-pos[k].y)));
				}
			}
			sum = 0.0;
			num = 0;
			kruskal();
//			System.out.println(sum);
			result = (double)sum*E;
			System.out.println("#"+(i+1)+" "+Math.round(result));
		}
	}
	public static void kruskal() {
		Arrays.sort(node);
//		System.out.println(Arrays.toString(node));
		for(int i=0;i<node.length;i++) {
			if(num==V-1) break;
			connect(node[i].from,node[i].to,node[i].s);
		}
	}
	public static int parent(int x) {
		if(p[x]!=x) {
			return p[x] = parent(p[x]);
		}else {
			return x;
		}
	}
	public static void connect(int from,int to,double s) {
		if(parent(from)!=parent(to)) {
			p[parent(from)] = to;
			sum+=s;
			num++;
		}
	}
}
