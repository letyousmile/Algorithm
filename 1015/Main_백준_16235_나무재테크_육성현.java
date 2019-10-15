import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main_백준_16235_나무재테크_육성현 {
	static class Tree implements Comparable<Tree>{
		int y;
		int x;
		int z;
		public Tree(int y, int x, int z) {
			super();
			this.y = y;
			this.x = x;
			this.z = z;
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return Integer.valueOf(this.z).compareTo(o.z);
		}
		
	}
	static int[] dx = {-1,0,1,-1,1,-1,0,1};
	static int[] dy = {-1,-1,-1,0,0,1,1,1};
	static int N,M,K;
	static int[][] A;
	static int[][] map;
	static List<Tree> dead;
	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static PriorityQueue<Tree> after = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		
		N = Integer.parseInt(srr[0]);
		map = new int[N][N];
		A = new int[N][N];
		M = Integer.parseInt(srr[1]);
		K = Integer.parseInt(srr[2]);
		
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				A[i][j] = Integer.parseInt(input[j]);
				map[i][j] =5;
			}
		}
		
		for(int i=0;i<M;i++) {
			String[] input = br.readLine().split(" ");
			int y = Integer.parseInt(input[0])-1;
			int x = Integer.parseInt(input[1])-1;
			int z = Integer.parseInt(input[2]);
			pq.add(new Tree(y, x, z));
		}
		for(int i=0;i<K;i++) {
			spring();
			summer();
			fall();
			winter();
		}
//		int num = 0;
//		for(int i=0;i<pq.size();i++) {
//			if(!pq.get(i).dead) {
//				num++;
//			}
//		}
		System.out.println(pq.size());
	}
	public static void spring() {
		dead = new ArrayList<>();
		while(!pq.isEmpty()){
			Tree t = pq.poll();
			if(map[t.y][t.x]>=t.z) {
				map[t.y][t.x]-=t.z;
				t.z++;
				after.add(t);
			}else {
				dead.add(t);
			}
		}
	}
	public static void summer() {
		for(int i=0;i<dead.size();i++) {
			Tree t =dead.get(i);
			map[t.y][t.x]+=(t.z/2);
		}
	}
	public static void fall() {
		while(!after.isEmpty()) {
			Tree t = after.poll();
			pq.add(t);
			if(t.z%5==0) {
				for(int j=0;j<8;j++) {
					int newy = t.y+dy[j];
					int newx = t.x+dx[j];
					if(newy<0||newx<0||newy==N||newx==N) continue;
					pq.add(new Tree(newy,newx,1));
				}
			}
		}
	}
	public static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]+=A[i][j];
			}
		}
	}
}
