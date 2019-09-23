import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution_1247_SW문제해결응용3일차_최적경로_육성현{
	static class Pair{
		int y;
		int x;
		public Pair(int x, int y) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Pair [y=" + y + ", x=" + x + "]";
		}
		
	}
	static Pair start;
	static Pair end;
	static int[] list;
	static int N;
	static Pair[] cust;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			min =Integer.MAX_VALUE;
			cust = new Pair[N];
			list = new int[N];
			for(int j=0;j<N;j++) {
				list[j] = j;
			}
			String[] input = br.readLine().split(" ");
			start = new Pair(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
			end = new Pair(Integer.parseInt(input[2]),Integer.parseInt(input[3]));
//			System.out.println(start);
//			System.out.println(end);
			for(int j=0;j<2*N;j+=2) {
				cust[j/2] = new Pair(Integer.parseInt(input[j+4]),Integer.parseInt(input[j+5]));
			}
			make_permutation(0,0);
			System.out.println("#"+(i+1)+" "+min);
		}
	}
	public static void travel() {
		int result = 0;
		result+=(Math.abs(start.y-cust[list[0]].y)+Math.abs(start.x-cust[list[0]].x));
		for(int i=0;i<N-1;i++) {
			result+=(Math.abs(cust[list[i]].y-cust[list[i+1]].y) + Math.abs(cust[list[i]].x-cust[list[i+1]].x));
		}
		result+=(Math.abs(end.y-cust[list[N-1]].y)+Math.abs(end.x-cust[list[N-1]].x));
		if(result<min) min = result;
	}
	public static void make_permutation(int loc,int num) {
		if(num==N) {
			travel();
		}else {
			for(int i=loc;i<N;i++) {
				int temp = list[loc];
				list[loc] = list[i];
				list[i] = temp;
				make_permutation(loc+1,num+1);
				temp = list[loc];
				list[loc] = list[i];
				list[i] = temp;
			}
		}
	}
}