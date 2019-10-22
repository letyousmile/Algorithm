import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mabangjin_육성현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[num][num];
		int locy = 0;
		int locx = num/2;
		for(int i=0;i<num*num;i++) {
				arr[locy][locx] = i+1;
 
                if((i+1) % num == 0){
                        locy++;
                }else{
                        locy--;
                        locx++;
                }
                if(locy < 0) locy = num-1;
                if(locy >= num) locy = 0;
                if(locx < 0) locx = num-1;
                if(locx >= num) locx = 0;
		}
		for(int i=0;i<num;i++) {
			int sum = 0;
			for(int j=0;j<num;j++) {
//				System.out.print(arr[i][j]+" ");
				sum+=arr[i][j];
			}
			System.out.println(i+"행의 합"+sum);
		}
		for(int j=0;j<num;j++) {
			int sum = 0;
			for(int i=0;i<num;i++) {
//				System.out.println(arr[j][i]+" ");
				sum+=arr[i][j];
			}
			System.out.println(j+"열의 합"+sum);
		}
		int sum1 =0;
		int sum2 =0;
		for(int j=0;j<num;j++) {
			sum1+=arr[j][j];
			sum2+=arr[num-1-j][j];
		}
		System.out.println("대각선의 합"+sum1);
		System.out.println("대각선2의 합"+sum2);
	}
}
