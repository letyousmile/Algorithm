import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Magic{
		int y;
		int x;
		int s;
		public Magic(int y, int x, int s) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
		}
		
	}
	static boolean[] visited;
	static Magic[] magic;
	static int N,M,K;
	static int[][] omap;
	static int[][] cmap;
	static int min = 250001;
	static int[] magicList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		K = Integer.parseInt(srr[2]);
		omap = new int[N][M];
		magic = new Magic[K];
		magicList = new int[K];
		visited = new boolean[K];
		cmap = new int[N][M];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				omap[i][j]=Integer.parseInt(input[j]);
			}
		}
		for(int i=0;i<K;i++) {
			String[] input = br.readLine().split(" ");
			int y = Integer.parseInt(input[0])-1;
			int x = Integer.parseInt(input[1])-1;
			int s = Integer.parseInt(input[2]);
			
			magic[i] = new Magic(y,x,s);
		}
		permutation(0);
		System.out.println(min);
	}
	public static void rotate() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				cmap[i][j]=omap[i][j];
			}
		}
		for(int i=0;i<K;i++) {
			int y = magic[magicList[i]].y;
			int x = magic[magicList[i]].x;
			int s = magic[magicList[i]].s;
			for(int j=1;j<=s;j++) {
				int nexty=y-j;
				int nextx=x-j;
				int temp = cmap[nexty][nextx];
				for(int k=0;k<2*j;k++) {
//					System.out.println(nexty+" "+nextx);
					cmap[nexty][nextx] = cmap[nexty+1][nextx];
					nexty=nexty+1;
				}
				for(int k=0;k<2*j;k++) {
//					System.out.println(nexty+" "+nextx);
					cmap[nexty][nextx]=cmap[nexty][nextx+1];
					nextx=nextx+1;
				}
				for(int k=0;k<2*j;k++) {
//					System.out.println(nexty+" "+nextx);
					cmap[nexty][nextx]=cmap[nexty-1][nextx];
					nexty=nexty-1;
				}
				for(int k=0;k<2*j-1;k++) {
//					System.out.println(nexty+" "+nextx);
					cmap[nexty][nextx]=cmap[nexty][nextx-1];
					nextx=nextx-1;
				}
//				System.out.println(nexty+" "+nextx);
				cmap[nexty][nextx]=temp;
//				for(int k=0;k<N;k++) {
//					for(int l=0;l<M;l++) {
//						System.out.print(cmap[k][l]+" ");
//					}
//					System.out.println();
//				}
			}
		}
		for(int i=0;i<N;i++) {
			int temp = 0;
			for(int j=0;j<M;j++) {
				temp+=cmap[i][j];
			}
			if(temp<min) min = temp;
		}
	}
	public static void permutation(int loc) {
		if(loc==K) {
			rotate();
		}else {
			for(int i=0;i<K;i++) {
				if(!visited[i]) {
					visited[i]=true;
					magicList[loc]=i;
					permutation(loc+1);
					visited[i]=false;
				}
			}
		}
	}
}
