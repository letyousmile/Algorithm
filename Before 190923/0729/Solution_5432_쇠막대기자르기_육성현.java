import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String input = br.readLine();
			Stack<Character> s = new Stack<Character>();
			
			int num = 0;
			for(int j=0;j<input.length();j++) {
				char c = input.charAt(j);
				if(c=='(') {
					if(input.charAt(j+1)==')') {
						num+=s.size();
						j++;
					}else {
						s.push(c);
						num++;
					}
				}else if(c==')') {
					s.pop();
				}
				
			}
			System.out.println("#"+(i+1)+" "+num);
		}
	}
}
