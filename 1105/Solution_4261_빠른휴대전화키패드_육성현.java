import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4261_빠른휴대전화키패드_육성현 {
	static char[][] board= {{},
			{},
			{'a','b','c'},
			{'d','e','f'},
			{'g','h','i'},
			{'j','k','l'},
			{'m','n','o'},
			{'p','q','r','s'},
			{'t','u','v'},
			{'w','x','y','z'}};
	static int[] x = new int[1000];
	static int N;
	static String S;
	static String[] input;
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			String[] srr = br.readLine().split(" ");
			S = srr[0];
			N = Integer.parseInt(srr[1]);
			input = br.readLine().split(" ");
			func();
			sb.append("#"+(i+1)+" "+num+"\n");
		}
		System.out.print(sb);
	}
	public static void func() {
		num = 0;
		int len = S.length();
		for(int i=0;i<S.length();i++) {
			x[i] = S.charAt(i)-'0';
		}
		for(int i=0;i<N;i++) {
			boolean b = false;
			if(len==input[i].length()) {
				for(int j=0;j<len;j++) {
					char c = input[i].charAt(j);
					b = false;
					for(int k=0;k<board[x[j]].length;k++) {
//						System.out.println(c+" "+board[x[j]][k]);
						if(c==board[x[j]][k]) {
							b = true;
							break;
						}
					}
					if(!b) {
						break;
					}
				}
			}
			if(!b) {
				continue;
			}else {
				num++;
			}
		}
	}
}
