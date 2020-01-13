import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5672_올해의조련사_육성현 {
	static int N;
	static char[] bird = new char[2001];
	static StringBuilder result;
	static int[][] cache= new int[2001][2001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine().trim());
			for(int j=0;j<N;j++) {
				bird[j] = br.readLine().charAt(0);
			}
			init();
			makeResult();
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}
	public static void makeResult() {
		int f = 0;
		int r = N-1;
		for(int i=0;i<N;i++) {
//			System.out.println(f+" "+r+" "+cache[f][r]);
			if(cache[f][r]<0) {
				result = result.append(bird[f++]);
			}else if(cache[f][r]>0) {
				result = result.append(bird[r--]);
			}else if(f==r) {
				result = result.append(bird[f]);
			}
//			System.out.println(f+" "+r);
		}
	}
	public static void init() {
		result = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(bird[i]<bird[j]) {
					cache[i][j] = -1;
				}else if(bird[i]>bird[j]) {
					cache[i][j]=1;
				}else {
					cache[i][j]=0;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(cache[i][j]==0) {
					cache[i][j] = order(i+1,j-1);
				}
			}
		}
	}
	public static int order(int f, int r) {
		if(f>=r) {
			return -1;
		}else if(cache[f][r]==0) {
			return order(f+1,r-1);
		}else {
			return cache[f][r];
		}
	}
}
