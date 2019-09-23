import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution{
	static int N;
	static int[][] map = new int[100][100];
	static class Matrix implements Comparable<Matrix>{
		int r;
		int c;
		public Matrix(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return r+" "+c+" ";
		}
		@Override
		public int compareTo(Matrix o) {
			if(this.r*this.c==o.r*o.c) {
				return Integer.valueOf(this.r).compareTo(o.r);
			}else {
				return Integer.valueOf(this.r*this.c).compareTo(o.r*o.c);
			}
		}
		
		
	}
	static List<Matrix> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			for(int j=0;j<N;j++) {
				String[] input = br.readLine().split(" ");
				for(int k=0;k<N;k++) {
					map[j][k] = Integer.parseInt(input[k]);
				}
			}
			list = new ArrayList<>();
			cal();
			System.out.print("#"+(i+1)+" "+list.size()+" ");
			for(int j=0;j<list.size();j++) {
				System.out.print(list.get(j));
			}
			System.out.println();
		}
	}
	public static void cal() {
		boolean[][] visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&map[i][j]!=0) {
					int y = i;
					int x = j;
					while(y<N&&map[y][x]!=0) {
						y++;
					}
					y--;
					while(x<N&&map[y][x]!=0) {
						x++;
					}
					x--;
//					System.out.println(y+" "+x);
					list.add(new Matrix(y-i+1,x-j+1));
					for(int k=i;k<=y;k++) {
						for(int l=j;l<=x;l++) {
							visited[k][l]=true;
						}
					}
				}
			}
		}
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
		Collections.sort(list);
	}
}
