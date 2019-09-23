import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N;
	static int[] arr;
	static int[] trr = new int[2];
	static int len;
	static int max;
	static int ten;
	static int i;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(i=0;i<tc;i++) {
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[1]);
			arr = new int[srr[0].length()];
			for(int j=0;j<srr[0].length();j++) {
				arr[j] = srr[0].charAt(j)-'0';
			}
			len = srr[0].length();
			ten = 1;
			for(int j=1;j<len;j++) {
				ten*=10;
			}
			max = 0;
			if(N>=len-1) {
				N=len-1+((N-len+1)%2);
			}
			comb(0);

			System.out.println("#"+(i+1)+" "+max);
		}
	}
	public static void change(int num) {
		int a = trr[0];
		int b = trr[1];
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		comb(num+1);
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void comb(int num) {
		if(num==N) {
			int jari = ten;
			int result = 0;
			for(int i=0;i<len;i++) {
				result+=(arr[i]*jari);
				jari/=10;
			}
			if(result>max) max =result;
		}else {
			for(int i=0;i<len;i++) {
				for(int j=i+1;j<len;j++) {
					trr[0] = i;
					trr[1] = j;
					change(num);
				}
			}
		}
	}
}
