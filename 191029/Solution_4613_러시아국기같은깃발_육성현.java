import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4613_러시아국기같은깃발_육성현 {
	static int N,M;
	static String[] flag;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[0]);
			flag = new String[N];
			M = Integer.parseInt(srr[1]);
			for(int j=0;j<N;j++) {
				flag[j] = br.readLine();
			}
			min = 2501;
			func();
			sb.append("#"+(i+1)+" "+min+"\n");
		}
		System.out.print(sb);
	}
	public static void func() {
		int r = 0;
		for(int i=0;i<M;i++) {
			char c1 = flag[0].charAt(i);
			char c2 = flag[N-1].charAt(i);
			if(c1!='W') r++;
			if(c2!='R') r++;
		}
		for(int i=1;i<N-1;i++) {
			int x = find(i);
			if(x<min) {
				min = x;
			}
		}
		min+=r;
	}
	public static int find(int loc) {
//		System.out.println("들어옴"+loc);
		int result = 0;
		for(int i=1;i<loc;i++) {
			for(int j=0;j<M;j++) {
				if(flag[i].charAt(j)!='W') result++;
			}
		}
		int m = 2501;
		for(int i=1;i<N-loc;i++) {
			int x = 0;
			int j = N-1-loc-i;
			for(int k=0;k<i;k++) {
				for(int l=0;l<M;l++) {
					if(flag[loc+k].charAt(l)!='B') x++;
				}
			}
			for(int k=0;k<j;k++) {
				for(int l=0;l<M;l++) {
					if(flag[loc+i+k].charAt(l)!='R') x++;
				}
			}
//			System.out.println(loc+" "+i+" "+j);
			if(x<m) m =x;
		}
//		System.out.println(m);
		return m+result;
	}
}
