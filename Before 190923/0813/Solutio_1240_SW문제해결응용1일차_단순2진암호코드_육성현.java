import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N,K;
	static int[][] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[0]);
			K = Integer.parseInt(srr[1]);
			list = new int[N][K];
			for(int j=0;j<N;j++) {
				String input = br.readLine();
				for(int k=0;k<K;k++) {
					list[j][k] = input.charAt(k)-'0';
				}
			}
			int start = 0;
			int end = 0;
			int c = 0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<K;k++) {
					if(list[j][k]==1) {
						c = j;
						end = k;
					}
				}
			}
			int[] num = new int[8];
			start = end-55;
			for(int j=0;j<8;j++) {
				int[] pw = new int[4];
				int loc = 0;
				int vec = 0;
				int nvec = 1;
				for(int k=1;k<7;k++) {
					if(list[c][start+k]==vec) {
						nvec++;
					}else {
						vec=(vec+1)%2;
						pw[loc++] = nvec;
						nvec = 1;
					}
					
				}
				pw[loc] = nvec;
				start = start+7;
				num[j] = decode(pw);
//				System.out.println("come");
//				System.out.println(Arrays.toString(pw));
			}
//			System.out.println(Arrays.toString(num));
			int answer = check(num);
			System.out.println("#"+(i+1)+" "+answer);
//			check();
		}
	}
	public static int check(int[] num) {
		int result = 0;
		for(int i=0;i<7;i+=2) {
			result+=num[i];
		}
		result*=3;
		for(int i=1;i<7;i+=2) {
			result+=num[i];
		}
		result+=num[7];
		if(result%10 == 0) {
			int last = 0;
			for(int i=0;i<8;i++) {
				last+=num[i];
			}
			return last;
		}else {
			return 0;
		}
	}
	public static int decode(int[] pw) {
		if(pw[0]==1) {
			if(pw[1]==4) {
				return 3;
			}
			else if(pw[3]==3) {
				return 8;
			}
			else if(pw[3]==4) {
				return 6;
			}
			else if(pw[1]==1) {
				return 4;
			}else if(pw[1]==2) {
				return 5;
			}else if(pw[1]==3) {
				return 7;
			}
		}else if(pw[0]==2) {
			if(pw[1]==2) {
				return 1;
			}else {
				return 2;
			}
		}else if(pw[0]==3) {
			if(pw[1]==2)
				return 0;
		}
		return 9;
	}
}
