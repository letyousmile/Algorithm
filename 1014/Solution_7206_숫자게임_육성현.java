import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7206_숫자게임_육성현 {
	static int max;
	static boolean[] visited = new boolean[10000000];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
//			for(int j=0;j<=1000000;j++) {
//				visited[j]=false;
//			}
			max = 0;
			split(N, 0);
			sb.append("#" + (i + 1) + " " + max + "\n");
//			System.out.println("으악");
		}
		System.out.print(sb);
	}
	public static void split(int x, int num) {
//		System.out.println(x);
//		if(visited[x]) return;
//		visited[x] =true;
		int f;
		int r;
		int d=10;
		if (x > 9999) {
			for(int i=0;i<4;i++) {
				f = x/d;
				r = x%d;
				split(f*r,num+1);
				if(i==0) {
					int d2=10;
					for(int j=0;j<3;j++) {
						int f2 = f/d2;
						int r2 = f%d2;
						split(f2*r2*r,num+1);
						d2*=10;
					}
				}else if(i==1) {
					int d2=1;
					for(int j=0;j<3;j++) {
						int f2 = f/d2;
						int r2 = f%d2;
						split(f2*r2*r,num+1);
						d2*=10;
					}
				}else if(i==2) {
					int d2=1;
					for(int j=0;j<3;j++) {
						int f2 = r/d2;
						int r2 = r%d2;
						split(f*f2*r2,num+1);
						d2*=10;
					}
				}else if(i==3) {
					int d2=10;
					for(int j=0;j<3;j++) {
						int f2 = r/d2;
						int r2 = r%d2;
						split(f*f2*r2,num+1);
						d2*=10;
					}
				}
				d = d*10;
			}
		} else if (x > 999) {
			for(int i=0;i<3;i++) {
				f = x/d;
				r = x%d;
				split(f*r,num+1);
				d = d*10;
				if(i==0) {
					int d2=10;
					for(int j=0;j<2;j++) {
						int f2 = f/d2;
						int r2 = f%d2;
						split(f2*r2*r,num+1);
						d2*=10;
					}
				}else if(i==1) {
					int d2=10;
					for(int j=0;j<1;j++) {
						int f2 = f/d2;
						int r2 = f%d2;
						split(f2*r2*r,num+1);
						d2*=10;
					}
				}else if(i==2) {
					int d2=10;
					for(int j=0;j<2;j++) {
						int f2 = r/d2;
						int r2 = r%d2;
						split(f*f2*r2,num+1);
						d2*=10;
					}
				}
			}
		} else if (x > 99) {
			int a =x/100;
			int b = (x%100)/10;
			int c = x%10;
			for(int i=0;i<2;i++) {
				f = x/d;
				r = x%d;
				split(f*r,num+1);
				d = d*10;
			}
			split(a*b*c,num+1);
		} else if (x > 9) {
			for(int i=0;i<1;i++) {
				f = x/d;
				r = x%d;
				split(f*r,num+1);
				d = d*10;
			}
		} else {
			if (num > max)
				max = num;
			return;
		}
	}
}
