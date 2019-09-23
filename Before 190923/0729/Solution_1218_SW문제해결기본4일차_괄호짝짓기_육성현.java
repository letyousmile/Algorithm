import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	static String input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++) {
			int len = Integer.parseInt(br.readLine());
			input = br.readLine();
			
			System.out.println("#"+(i+1)+" "+check());
		}
	}
	public static int check() {
		Stack<Character> s = new Stack<Character>();
		for(int j=0;j<input.length();j++) {
			char c = input.charAt(j);
			if(c==')') {
				if(s.isEmpty()) {
					return 0;
				}else if(s.peek()!='(') {
					return 0;
				}else {
					s.pop();
				}
			}else if(c==']') {
				if(s.isEmpty()) {
					return 0;
				}else if(s.peek()!='[') {
					return 0;
				}else {
					s.pop();
				}
			}else if(c=='}') {
				if(s.isEmpty()) {
					return 0;
				}else if(s.peek()!='{') {
					return 0;
				}else {
					s.pop();
				}
			}else if(c=='>') {
				if(s.isEmpty()) {
					return 0;
				}else if(s.peek()!='<') {
					return 0;
				}else {
					s.pop();
				}
			}else {
				s.push(c);
			}
		}
		if(!s.isEmpty()) {
			return 0;
		}
		return 1;
	}
}
