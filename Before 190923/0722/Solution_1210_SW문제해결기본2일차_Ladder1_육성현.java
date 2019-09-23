import java.util.Scanner;

public class Z11_Solution_1210_SW문제해결기본2일차_Ladder1_육성현 {
	public static int[][] ladder;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = 10;
		for(int i=0;i<10;i++) {
			ladder = new int[100][100];
			int testNumber = sc.nextInt();
			int now = input();
			System.out.println(now);
			for(int j=99;j>=0;j--) {
				if(now+1<100&&ladder[j][now+1]==1) {
					while(now+1<100&&ladder[j][now+1]==1) {
						now++;
					}
				}
				else if(now-1>=0&&ladder[j][now-1]==1) {
					while(now-1>=0&&ladder[j][now-1]==1) {
						now--;
					}
				}
				//System.out.println(now);
			}
			System.out.println("#"+(testNumber)+" "+now);
		}
	}//end of main
	public static int input() {
		int start=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				ladder[i][j]=sc.nextInt();
				if(ladder[i][j]==2)
					start=j;
			}
		}
		return start;
	}
}//end of class
