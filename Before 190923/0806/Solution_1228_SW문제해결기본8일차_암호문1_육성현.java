import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++) {
			List<String> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			String[] srr = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				list.add(srr[j]);
			}
			N = Integer.parseInt(br.readLine());
			String[] srr2 = br.readLine().split(" ");
			int loc = 0;
			for(int j=0;j<N;j++) {
				int x = Integer.parseInt(srr2[loc+1]);
				int y = Integer.parseInt(srr2[loc+2]);
				for(int k=0;k<y;k++) {
					list.add(x+k,srr2[loc+3+k]);
				}
				loc+=(y+3);
			}
			System.out.print("#"+ (i+1)+ " ");
			for(int j=0;j<10;j++) {
				System.out.print(list.get(j)+" ");
			}
			System.out.println();
		}
	}
}
