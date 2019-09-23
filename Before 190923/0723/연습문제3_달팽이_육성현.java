import java.util.Arrays;

public class 연습문제3_달팽이_육성현 {
	public static boolean[][] sorted = new boolean[5][5];
	public static void main(String[] args) {
		int[][] arr = {{9,20,2,18,11},
				{19,1,25,3,21},
				{8,24,10,17,7},
				{15,4,16,5,6},
				{12,13,22,23,14}};
		for(int i=0;i<arr.length;i++)
			System.out.println(Arrays.toString(arr[i]));
		
		int[] arr2 = new int[25];
		int index = 0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				arr2[index++]=arr[i][j];
			}
		}
		Arrays.sort(arr2);

		insert(arr,arr2);
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.println(Arrays.toString(arr[i]));
	}
	public static void insert(int[][] arr,int[] arr2) {
		int a = arr.length*2;
		int y=0;
		int x=-1;
		int[] dy= {0,1,0,-1};
		int[] dx= {1,0,-1,0};
		int d = 0;
		int index = 0;
		while(a>1) {
			for(int i=0;i<a/2;i++) {
				y=y+dy[d];
				x=x+dx[d];
				arr[y][x] =arr2[index++]; 
			}
			a--;
			d=(d+1)%4;
		}
	}
}
