import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4014_활주로건설_육성현 {
	static int N,X;
	static int[][] map = new int[20][20];
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[0]);
			X = Integer.parseInt(srr[1]);
			for(int j=0;j<N;j++) {
				String[] input = br.readLine().split(" ");
				for(int k=0;k<N;k++) {
					map[j][k] = Integer.parseInt(input[k]);
				}
			}
			func();
			sb.append("#"+(i+1)+" "+num+"\n");
		}
		System.out.print(sb);
	}
	public static void func() {
		num = 0;
		// 가로
		for(int i=0;i<N;i++) {
			int same = 1;
			
			int before = map[i][0];
			int now = map[i][0];
			boolean vec = true;
			for(int j=1;j<N;j++) {
//				System.out.println(same);
				before = now;
				now = map[i][j];
//				System.out.println(before+" "+now);
				if(now==before) {
					same++;
				}else if(before-now==1) {
					if(N-j<X) {
						vec = false;
						break;
					}else {
						for(int k=1;k<X;k++) {
							if(map[i][j+k]!=now) {
								vec=false;
								break;
							}
						}
						same =0;
						j+=X-1;
					}
				}else if(before-now==-1) {
					if(same<X) {
						vec = false;
						break;
					}else {
//						System.out.println("들어옴");
						same = 1;
					}
				}else {
					vec = false;
					break;
				}
				if(!vec) break;
			}
			if(vec) {
//				System.out.println(i+"가로");
				num++;
			}
		}
		// 세로
		for(int i=0;i<N;i++) {
			int same = 1;
			
			int before = map[0][i];
			int now = map[0][i];
			boolean vec = true;
			for(int j=1;j<N;j++) {
//				System.out.println(same);
				before = now;
				now = map[j][i];
//				System.out.println(before+" "+now+" "+j);
				if(now==before) {
					same++;
				}else if(before-now==1) {
					if(N-j<X) {
						vec = false;
						break;
					}else {
						for(int k=1;k<X;k++) {
							if(map[j+k][i]!=now) {
								vec=false;
								break;
							}
						}
						j+=X-1;
						same =0;
					}
				}else if(before-now==-1) {
					if(same<X) {
						vec = false;
						break;
					}
					same=1;
				}else {
					vec = false;
					break;
				}
				if(!vec) break;
			}
			if(vec) {
//				System.out.println(i+"세로");
				num++;
			}
		}
	}
}
