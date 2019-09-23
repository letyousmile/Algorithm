import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution{
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int s;
		public Node(int from, int to, int s) {
			super();
			this.from = from;
			this.to = to;
			this.s = s;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.valueOf(this.s).compareTo(o.s);
		}
	}
	static int V,E;
	static Node[] node;
	static long sum;
	static int num;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] srr = br.readLine().split(" ");
			V = Integer.parseInt(srr[0]);
			p = new int[V+1];
			for(int j=0;j<=V;j++) {
				p[j] = j;
			}
			E = Integer.parseInt(srr[1]);
			node = new Node[E];
			for(int j=0;j<E;j++) {
				String[] input = br.readLine().split(" ");
				int from = Integer.parseInt(input[0]);
				int to = Integer.parseInt(input[1]);
				int s = Integer.parseInt(input[2]);
				node[j] = new Node(from,to,s);
			}
			sum = 0;
			num = 0;
			kruskal();
			System.out.println("#"+(i+1)+" "+sum);
		}
	}
	public static void kruskal() {
		Arrays.sort(node);
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
	public static void connect(int from,int to,int s) {
		if(parent(from)!=parent(to)) {
			p[parent(from)] = to;
			sum+=s;
			num++;
		}
	}
}
