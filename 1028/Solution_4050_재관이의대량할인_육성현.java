import java.util.Arrays;
import java.util.Scanner;

public class Solution_4050_재관이의대량할인_육성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++) {
			int N=sc.nextInt();
			int[] arr = new int[N];
			for(int j=0;j<N;j++) {
				arr[j]=sc.nextInt();
			}
			Arrays.sort(arr);
			int num=0;
			int sum=0;
			for(int j=arr.length-1;j>=0;j--) {
				if(num%3==2){
                    num++;
					continue;
                }
				num++;
				sum+=arr[j];
			}
			System.out.println("#"+(i+1)+" "+sum);
		}
		
	}
}
