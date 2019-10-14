import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1717_집합의_표현_육성현 {
	static int[] p;
	static int[] r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		
		int N = Integer.parseInt(srr[0]);
		p = new int[N+1];
		r = new int[N+1];
		for(int i=0;i<=N;i++) {
			p[i]=-1;
			r[i]=1;
		}
		int M = Integer.parseInt(srr[1]);
		for(int i=0;i<M;i++) {
//			System.out.println(Arrays.toString(p));
//			System.out.println(Arrays.toString(r));
			String[] input = br.readLine().split(" ");
			if(input[0].equals("0")) {
				union(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
			}else {
				query(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
			}
		}
	}
	public static int parent(int a) {
//		System.out.println(a+" "+p[a]);
		if(p[a]!=-1) {
			return p[a]=parent(p[a]);
		}else {
			return a;
		}
	}
	public static void union(int a, int b) {
		int x = parent(a);
		int y = parent(b);
		if(x!=y) {
			if(r[x]>r[y]) {
				p[y]=x;
				r[x]+=r[y];
			}else {
				p[x]=y;
				r[y]+=r[x];
			}
		}
	}
	public static void query(int a,int b) {
		if(parent(a)==parent(b)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
