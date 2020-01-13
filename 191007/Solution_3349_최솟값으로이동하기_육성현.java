import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3349_최솟값으로이동하기_육성현 {
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int result;
	static int W,H,N;
	static Pair[] pair = new Pair[1000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			String[] srr = br.readLine().split(" ");
			W = Integer.parseInt(srr[0]);
			H = Integer.parseInt(srr[1]);
			N = Integer.parseInt(srr[2]);
			
			for(int j=0;j<N;j++) {
				String[] input = br.readLine().split(" ");
				pair[j] = new Pair(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
			}
			func();
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}
	public static void func() {
		result = 0;
		int x = 1;
		int y = 1;
		for(int i=0;i<N;i++) {
			Pair now = pair[i];
			if(now.x>x&&now.y>y) {
				int diff = Math.min(now.x-x,now.y-y);
				result+=diff;
				y+=diff;
				x+=diff;
			}else if(now.x<x&&now.y<y) {
				int diff = Math.min(x-now.x, y-now.y);
				result+=diff;
				y-=diff;
				x-=diff;
			}
			System.out.println(x+" "+y);
			result+=Math.abs(now.y-y);
			result+=Math.abs(now.x-x);
			y = now.y;
			x = now.x;
//			System.out.println(result+" "+x+" "+y);
		}
	}
}
