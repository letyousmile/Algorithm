import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++) {
			int[] input = new int[8];
			int[] queue = new int[9];
			int f = 0;
			int r = 0;
			int tc = Integer.parseInt(br.readLine());
			
			String[] srr = br.readLine().split(" ");
			for(int j=0;j<8;j++) {
				input[j] = Integer.parseInt(srr[j]);
				queue[++r] = input[j];
			}
			int minus = 0;
			while(queue[r]!=0) {
				for(int j=0;j<9;j++) {
					System.out.print(queue[j]+" ");
				}
				System.out.println();
				minus = ((minus)%5)+1;
				if(++f==9) f = 0;
				int first = queue[f];
				if(++r==9) r =0;
				queue[r] = first-minus;
				if(queue[r]<0) queue[r] = 0;
			}
			int[] answer = new int[8];
			
			System.out.print("#"+tc+" ");
			for(int j=f+1;j<9;j++)
				System.out.print(queue[j]+" ");
			for(int j=0;j<f;j++)
				System.out.print(queue[j]+" ");
		}
	}
}	
