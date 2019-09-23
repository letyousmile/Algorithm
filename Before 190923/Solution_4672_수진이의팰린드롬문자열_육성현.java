import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4672_수진이의팰린드롬문자열_육성현 {
	static String str;
	static int result;
	static int[] alpha = new int[26];
	static int[] list = {0,1,3,6,10,15,21,28,36,45,55};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < T; i++) {
			str = br.readLine();
			result = 0;
			func();
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}

	public static void func() {
		for(int i=0;i<26;i++) {
			alpha[i]=0;
		}
		for(int i=0;i<str.length();i++) {
			alpha[str.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			result+=list[alpha[i]];
		}
	}
}
