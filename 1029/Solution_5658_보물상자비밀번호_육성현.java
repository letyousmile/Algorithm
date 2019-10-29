import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Solution_5658_보물상자비밀번호_육성현 {
	static int result;
	static int N,K;
	static String input;
	static Set<String> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			set = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o2.compareTo(o1);
				}
			});
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[0]);
			K = Integer.parseInt(srr[1]);
			input = br.readLine();
			rotate();
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}
	public static void rotate() {
		for(int i=0;i<N/4;i++) {
			String s1 = input.substring(0, N/4);
			String s2 = input.substring(N/4, N/2);
			String s3 = input.substring(N/2, N/4+N/2);
			String s4 = input.substring(N/4+N/2, N);
			input = input.charAt(N-1)+input.substring(0,N-1);
			set.add(s1);
			set.add(s2);
			set.add(s3);
			set.add(s4);
		}
		int i =1;
		for(String str : set) {
			if(i==K) {
				result = hexToDec(str);
				break;
			}
			i++;
		}
	}
	public static int hexToDec(String str) {
		int x = 1;
		int y;
		int result = 0;
		for(int i=str.length()-1;i>=0;i--) {
			if(str.charAt(i)>='A'&&str.charAt(i)<='F') {
				y =str.charAt(i)-'A'+10;
			}else {
				y = str.charAt(i)-'0';
			}
			result+=y*x;
			x*=16;
		}
		return result;
	}
}
