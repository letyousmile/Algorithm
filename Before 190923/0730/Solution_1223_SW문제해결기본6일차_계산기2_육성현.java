import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<=10;i++) {
			int N = Integer.parseInt(br.readLine());
			int[] stack = new int[1000000];
			int top = 0;
			String srr = br.readLine();
			stack[top] = srr.charAt(0)-'0';
			for(int j=1;j<N;j+=2) {
				if(srr.charAt(j)=='*') {
					stack[top] = stack[top] * (srr.charAt(j+1)-'0');
				}else {
					stack[++top] = srr.charAt(j+1)-'0';
				}
			}
			int sum = 0;
			for(int j=0;j<=top;j++) {
				sum+=stack[j];
			}
			System.out.println("#"+(i+1)+" "+sum);
		}
	}
}
