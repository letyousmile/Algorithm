import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution_1494_사랑의카운슬러기_육성현{
	static int N;
	static class L implements Comparable<L>{
		int y;
		int x;
		public L(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(L o) {
			if(this.y==o.y) {
				return Integer.valueOf(this.x).compareTo(o.x);
			}
			return Integer.valueOf(this.y).compareTo(o.y);
		}
		
	}
	static L[] l = new L[20];
	static boolean[] visited;
	static long min;
	static boolean vec=false;
	static int num = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];
			min = Long.MAX_VALUE;
//			for(int j=0;j<N;j++) {
//				String[] input = br.readLine().split(" ");
//				l[j] = new L(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
//			}
			num = 0;
			make_permutation(0, 0);
			System.out.println("#"+(i+1)+" "+min);
//			System.out.println(N+" "+num);
		}
	}
	
	public static void make_permutation(int num,int loc) {
		if(num==N/2) {
			cal();
		}else {
			for(int i=loc;i<N;i++) {
				if(!visited[i]) {
					visited[i]=true;
					make_permutation(num+1,i+1);
					visited[i] = false;
				}
			}
		}
	}
	public static void cal() {
		num++;
		long ysum = 0;
		long xsum = 0;
		for(int i=0;i<N;i++) {
			if(visited[i]) {
				System.out.print(i+" ");
//				ysum-=l[i].y;
//				xsum-=l[i].x;
//			}else {
//				ysum+=l[i].y;
//				xsum+=l[i].x;
			}
		}
		System.out.println();
//		ysum*=ysum;
//		xsum*=xsum;
//		long result = ysum+xsum;
//		if(result<min) min = result;
	}
}
