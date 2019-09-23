import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int K;
	static int num;
	static boolean[][] queen;
	static int[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1;i<=10;i++) {
			int vec = 1;
			N = Integer.parseInt(br.readLine());
			for(int j=0;j<N;j++) {
				String[] input = br.readLine().split(" ");
				String op = input[1];
				if(op.equals("-")||op.equals("+")||op.equals("*")||op.equals("/")) {
					if(input.length!=4) {
						vec = 0;
					}
				}else if(op.charAt(0)>=0||op.charAt(0)<=9) {
					if(input.length!=2) {
						vec = 0 ;
					}
				}
			}
			System.out.println("#"+(i)+" "+vec);
		}
	}
}
