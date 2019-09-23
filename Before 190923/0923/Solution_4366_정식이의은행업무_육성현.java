import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무_육성현 {
	static String binary;
	static String triple;
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < T; i++) {
			binary= br.readLine();
			triple= br.readLine();
			func();
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}

	public static void func() {
		StringBuilder sb = new StringBuilder(binary);
		long bin;
		StringBuilder sb2 = new StringBuilder(triple);
		long tri;
		for(int i=0;i<binary.length();i++) {
			if(sb.charAt(i)=='0') {
				sb.setCharAt(i, '1');
				bin = Long.parseLong(sb.toString(), 2);
				for(int j=0;j<triple.length();j++) {
					char s = sb2.charAt(j);
					for(int k=0;k<3;k++) {
						if(s-'0'==k) continue;
						sb2.setCharAt(j, (char) ('0'+k));
						tri = Long.parseLong(sb2.toString(),3);
						if(bin==tri) {
							result = bin;
							return;
						}
						sb2.setCharAt(j,s);
					}
					
				}
				sb.setCharAt(i, '0');
			}else {
				sb.setCharAt(i, '0');
				bin = Long.parseLong(sb.toString(), 2);
				for(int j=0;j<triple.length();j++) {
					char s = sb2.charAt(j);
					for(int k=0;k<3;k++) {
						if(s-'0'==k) continue;
						sb2.setCharAt(j, (char) ('0'+k));
						tri = Long.parseLong(sb2.toString(),3);
						if(bin==tri) {
							result = bin;
							return;
						}
						sb2.setCharAt(j,s);
					}
				}
				sb.setCharAt(i, '1');
			}
		}
	}
}
