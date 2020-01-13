import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_2543_타일채우기_육성현 {
	static int[][] map;
	static int N;
	static int holey;
	static int holex;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		String[] srr = br.readLine().split(" ");
		holey = Integer.parseInt(srr[0]);
		holex = Integer.parseInt(srr[1]);
		int size = N;
		drawSquare(size,0,0,0,0);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void drawSquare(int size, int y,int x, int vecy,int vecx) {
		int d = size/2;
		int vec1 = (holey-vecy)/d;
		int vec2 = (holex-vecx)/d;	
		if(size==2) {
			if(vec1==0&&vec2==0) { 
//				drawSquare(size/2,y,x);
				draw(1,size,y,x);
//				draw(zero(size/2,y,x),size,0,0);
			}else if(vec1==0&&vec2==1) {
//				drawSquare(size/2,y,x+size/2);
				draw(2,size,y,x);
//				draw(zero(size/2,y,x),size,0,N/2);
			}else if(vec1==1&&vec2==0) {
//				drawSquare(size/2,y+size/2,x);
				draw(3,size,y,x);
//				draw(zero(size/2,y,x),size,N/2,0);
			}else if(vec1==1&&vec2==1) {
//				drawSquare(size/2,y+size/2,x+size/2);
				draw(4,size,y,x);
//				draw(zero(size/2,y,x),size,N/2,N/2);
			}
			return;
		}
		
		if(vec1==0&&vec2==0) { 
			drawSquare(size/2,y,x,vecy,vecx);
			draw(1,size,y,x);
//			draw(zero(size/2,y,x),size,0,0);
		}else if(vec1==0&&vec2==1) {
			drawSquare(size/2,y,x+size/2,vecy,vecx+size/2);
			draw(2,size,y,x);
//			draw(zero(size/2,y,x),size,0,N/2);
		}else if(vec1==1&&vec2==0) {
			drawSquare(size/2,y+size/2,x,vecy+size/2,vecx);
			draw(3,size,y,x);
//			draw(zero(size/2,y,x),size,N/2,0);
		}else if(vec1==1&&vec2==1) {
			drawSquare(size/2,y+size/2,x+size/2,vecy+size/2,vecx+size/2);
			draw(4,size,y,x);
//			draw(zero(size/2,y,x),size,N/2,N/2);
		}
	}
	public static void draw(int num, int size,int y,int x) {
		if(size==2) {
			if(num==1) {
				map[y][x+1]=1;
				map[y+1][x]=1;
				map[y+1][x+1]=1;
			}else if(num==2) {
				map[y][x]=2;
				map[y+1][x]=2;
				map[y+1][x+1]=2;
			}else if(num==3) {
				map[y][x]=3;
				map[y][x+1]=3;
				map[y+1][x+1]=3;
			}else if(num==4) {
				map[y][x]=4;
				map[y][x+1]=4;
				map[y+1][x]=4;
			}
		}else {
			if(num==1) {
				draw(3,size/2,y,x+size/2);
				draw(1,size/2,y+size/4,x+size/4);
				draw(2,size/2,y+size/2,x);
				draw(1,size/2,y+size/2,x+size/2);
			}else if(num==2) {
				draw(4,size/2,y,x);
				draw(2,size/2,y+size/4,x+size/4);
				draw(2,size/2,y+size/2,x);
				draw(1,size/2,y+size/2,x+size/2);
			}else if(num==3) {
				draw(4,size/2,y,x);
				draw(3,size/2,y+size/4,x+size/4);
				draw(3,size/2,y,x+size/2);
				draw(1,size/2,y+size/2,x+size/2);
			}else if(num==4) {
				draw(4,size/2,y,x);
				draw(4,size/2,y+size/4,x+size/4);
				draw(3,size/2,y,x+size/2);
				draw(2,size/2,y+size/2,x);
			}
		}
	}
}
