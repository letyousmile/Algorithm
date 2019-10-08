import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5550_개구리소이다_육성현 {
	static String input;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
        	input = br.readLine();
        	result = -1;
        	func();
            sb.append("#"+(i+1)+" "+result+"\n");
        }
        System.out.print(sb);
    }
	public static void func() {
		int num = 0;
		int p = 0;
		int r = 0;
		int o = 0;
		int a = 0;
		int k = 0;
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
//			System.out.println(ch);
			if(ch=='c'&&p==0) {
				num++;
				r++;
			}else if(ch=='r'&&r==0) {
				return;
			}else if(ch=='o'&&o==0) {
				return;
			}else if(ch=='a'&&a==0) {
				return;
			}else if(ch=='k'&&k==0) {
				return;
			}else if(ch=='c') {
				p--;
				r++;
			}else if(ch=='r') {
				r--;
				o++;
			}else if(ch=='o') {
				o--;
				a++;
			}else if(ch=='a') {
				a--;
				k++;
			}else if(ch=='k') {
				k--;
				p++;
			}
		}
//		System.out.println("옴");
//		System.out.println(r+" "+o+" "+a+" "+k);
		if(r==0&&o==0&&a==0&&k==0) {
			result = num;
		}
	}
}
