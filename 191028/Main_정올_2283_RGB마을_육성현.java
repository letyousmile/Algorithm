import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_2283_RGB마을_육성현 {
	static int N;
	static int[][] map;
	static int[][] cache;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		cache = new int[N][3];
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				cache[i][j]=-1;
			}
		}
		for(int i=0;i<3;i++) {
			paint(0,i);
		}
		int result = Math.min(cache[0][0], Math.min(cache[0][1], cache[0][2]));
		System.out.println(result);
	}
	public static int paint(int loc,int c) {
		if(loc==N) return 0;
		if(cache[loc][c]!=-1) return cache[loc][c];
		if(c==0) return cache[loc][c] = Math.min(paint(loc+1,1), paint(loc+1,2))+map[loc][0];
		else if(c==1) return cache[loc][c] = Math.min(paint(loc+1,0), paint(loc+1,2))+map[loc][1];
		else return cache[loc][c] = Math.min(paint(loc+1,1), paint(loc+1,0))+map[loc][2];
	}
}
