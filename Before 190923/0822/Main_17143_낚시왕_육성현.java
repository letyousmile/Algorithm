import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17143_낚시왕_육성현 {
	static class Shark{
		int y;
		int x;
		int s;
		int d;
		int z;
		public Shark(int y, int x, int s, int d, int z) {
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static int me = -1;
	static Shark[] shark;
	static int R,C,M;
	static long[] arr;
	static boolean[] alive;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static double min = Double.MAX_VALUE;
	static int[][] map;
	static int[][] cmap;
	static int result = 0;
	static int[] sharkList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		R = Integer.parseInt(srr[0]);
		C = Integer.parseInt(srr[1]);
		map = new int[R][C];
		M = Integer.parseInt(srr[2]);
		sharkList = new int[M];
		shark = new Shark[10001];
		alive = new boolean[10001];
		for(int i=0;i<M;i++) {
			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0])-1;
			int c = Integer.parseInt(input[1])-1;
			int s = Integer.parseInt(input[2]);
			int d = Integer.parseInt(input[3])-1;
			int z = Integer.parseInt(input[4]);
			map[r][c] = z;
			sharkList[i] = z;
			shark[z] = new Shark(r,c,s,d,z);
			alive[z] = true;
		}
		Arrays.sort(sharkList);
		for(int i=0;i<C;i++) {
//			show();
			me++;
			fishing();
			sharkMove();
		}
		System.out.println(result);
	}
	public static void show() {
		System.out.println(me);
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void fishing() {
//		System.out.println();
		for(int i=0;i<R;i++) {
			if(map[i][me]!=0) {
				result+=map[i][me];
				alive[map[i][me]]=false;
				map[i][me] = 0;
				break;
			}
		}
	}
	public static void sharkMove() {
		cmap= new int[R][C];
		for(int i=M-1;i>=0;i--) {
			if(alive[sharkList[i]]) {
				Shark s = shark[sharkList[i]];
				int d = s.d;
				int r = s.y;
				int c = s.x;
				map[r][c]=0;
				int z = s.z;
				if(d==0) {
					r = s.y - s.s;
					if(r<=0) {
						r = Math.abs(r);
						if((r/(R-1))%2==0) {
							r = (r%(R-1));
							d = 1;
						}else {
							r = R-1-(r%(R-1));
							d = 0;
						}
					}
				}else if(d==1) {
					r = s.y + s.s;
					if(r>=R) {
						if((r/(R-1))%2==0) {
							r = (r%(R-1));
							d = 1;
						}else {
							r = R-1-(r%(R-1));
							d = 0;
						}
					}
				}else if(d==2) {
					c = s.x + s.s;
					if(c>=C) {
						if((c/(C-1))%2==0) {
							c = (c%(C-1));
							d = 2;
						}else {
							c = C-1-(c%(C-1));
							d = 3;
						}
					}
				}else if(d==3) {
					c = s.x - s.s;
					if(c<=0) {
						c=Math.abs(c);
						if((c/(C-1))%2==0) {
							c = (c%(C-1));
							d = 2;
						}else {
							c = C-1-(c%(C-1));
							d = 3;
						}
					}
				}
//				System.out.println(r+" "+c+" "+z);
				shark[z].y=r;
				shark[z].x=c;
				shark[z].d=d;
				if(cmap[r][c]>z) {
					alive[z] = false;
				}else {
					cmap[r][c] = z;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]=cmap[i][j];
			}
		}
	}
}
