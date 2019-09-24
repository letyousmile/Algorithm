import java.util.Scanner;

public class Solution_4796_의석이의_우뚝_선_산 {
	static int[] h = new int[50000];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			N = sc.nextInt();
			for(int j=0;j<N;j++) {
				h[j] = sc.nextInt();
			}
			sb.append("#" + (i + 1) + " " + func() + "\n");
		}
		System.out.print(sb);
	}
	public static int func() {
		int result = 0;
		boolean u = true;
		int up = 0;
		int down = 0;
		for(int i=0;i<N-1;i++) {
			if(h[i]<h[i+1]) {
				if(u) {
					up++;
				}else {
					u = true;
//					System.out.println(up+" "+down);
					result+=up*down;
//					System.out.println(i+"시작");
					up = 1;
					down = 0;
				}
			}else if(h[i]>h[i+1]) {
				if(u) {
					u=false;
//					System.out.println(i+"꼭대기");
				}
				down++;
			}
		}
		if(down!=0) {
			result+=up*(down);
		}
		return result;
	}
}
