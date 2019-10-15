import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_14889_스타트와링크_육성현 {
	static boolean[] team = new boolean[20];
	static int[] team1 = new int[20];
	static int[] team2 = new int[20];
	static int N;
	static int[][] ability;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				ability[i][j] = Integer.parseInt(input[j]);
			}
		}
		func(0,0);
		System.out.println(min);
	}
	public static void func(int loc,int num) {
		if(num==N/2) {
			int num1 = 0;
			int num2 = 0;
			for(int i=0;i<N;i++) {
				if(team[i]) {
					team1[num1++] = i;
				}else {
					team2[num2++] = i;
				}
			}
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0;i<num1;i++) {
				for(int j=0;j<num1;j++) {
					sum1+=ability[team1[i]][team1[j]];
					sum2+=ability[team2[i]][team2[j]];
				}
			}
			if(Math.abs(sum1-sum2)<min) min = Math.abs(sum1-sum2);
		}else {
			for(int i=loc;i<N;i++) {
				team[i] = true;
				func(i+1,num+1);
				team[i] = false;
			}
		}
	}
}
