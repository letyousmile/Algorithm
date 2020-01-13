import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2640_색종이만들기_육성현 {
	static int N;
	static int[][] map;
	static int blue = 0;
	static int white = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = input.charAt(j*2)-'0';
			}
		}
		cut(N,0,0);
		System.out.println(white);
		System.out.println(blue);
	}
	public static void cut(int num, int y,int x) {
		if(num==1) {
			if(map[y][x]==1) blue++;
			else white++;
//			System.out.println(num+" "+y+" "+x);
			return;
		}
		int c = map[y][x];
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				if(map[i+y][j+x]!=c) {
					int d = num/2;
					cut(d,y,x);
					cut(d,y+d,x);
					cut(d,y,x+d);
					cut(d,y+d,x+d);
					return;
				}
			}
		}
//		System.out.println(num+" "+y+" "+x);
		if(c==1) blue++;
		else white++;
	}
}
