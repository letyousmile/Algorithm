import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mabangjin4_육성현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[num][num];
		int q = num/4;
		boolean[][] s = new boolean[num][num];
		for(int i=q;i<num-q;i++) {
			for(int j=0;j<q;j++) {
				s[i][j]=true;
			}
			for(int j=num-q;j<num;j++) {
				s[i][j]=true;
			}
		}
		for(int j=q;j<num-q;j++) {
			for(int i=0;i<q;i++) {
				s[i][j]=true;
			}
			for(int i=num-q;i<num;i++) {
				s[i][j]=true;
			}
		}
		boolean[] n = new boolean[num*num+1];
		for(int i=0;i<num*num;i++) {
			int y = i/num;
			int x = i%num;
			if(s[y][x]) {
				continue;
			}else {
				arr[y][x] = i+1;
				n[i+1] = true;
			}
		}
		int d = num*num;
		for(int i=0;i<num*num;i++) {
			int y = i/num;
			int x = i%num;
			if(s[y][x]) {
				while(n[d]) {
					d--;
				}
				arr[y][x] = d;
				n[d]=true;
			}
		}
		for(int i=0;i<num;i++) {
			int sum = 0;
			for(int j=0;j<num;j++) {
//				System.out.print(arr[i][j]+" ");
				sum+=arr[i][j];
			}
			System.out.println("행의 합"+sum);
		}
		for(int j=0;j<num;j++) {
			int sum = 0;
			for(int i=0;i<num;i++) {
//				System.out.println(arr[j][i]+" ");
				sum+=arr[i][j];
			}
			System.out.println("열의 합"+sum);
		}
		int sum1=0;
		int sum2=0;
		for(int j=0;j<num;j++) {
			sum1+=arr[j][j];
			sum2+=arr[num-j-1][j];
		}
		if(sum1==sum2) {
			System.out.println("대각선의 합은 "+sum1+" "+sum2);
		}
	}
}
