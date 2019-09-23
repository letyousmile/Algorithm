import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			char [] stackOp = new char[N];// 연산자를 저장할 스택
			int top = -1;
			String sik="";
			for(int j=0;j<N;j++) {
				char c = input.charAt(j);
				switch (c) {
				case '(':	//넣을 때는 3, 무조건 넣음
					stackOp[++top] = c;
					break;
				case '*':	//넣을때도 2
					while(top>=0 &&stackOp[top]=='*') {//스택 꼭대기에 값의 우선순위가 나보다 작으면 쌓아라
						sik = sik + stackOp[top--];
					}
					stackOp[++top] = c;
					break;
				case '+':	//넣을때도 1
					while(top>=0 &&stackOp[top]!='(') {//스택 꼭대기에 값의 우선순위가 나보다 작으면 쌓아라
						sik = sik + stackOp[top--];
					}
					stackOp[++top] = c;
					break;
				case ')':	//'('가 나올때까지 모두 빼서 출력
					while(top>=0 && stackOp[top]!='(') {
						sik = sik + stackOp[top--];
					}
					if (stackOp[top]=='(') { // 여는 괄호가 남아있겠지만, 확인해줌
						top--;
					}
					break;
				default: //피연산자(숫자) : 바로 출력
					sik = sik + c;
					break;
				} // end of switch
			}
			while(top > -1) { // 스택에 남아있는 연산자가 있으면 출력
				sik = sik + stackOp[top--];
			}
			System.out.println(sik);
			top = -1;
			int[] stackNum = new int[N];
			for(int j=0;j<sik.length();j++){
				char c = sik.charAt(j);
				int num1,num2;
				switch (c) {
				case '+':
					num2 = stackNum[top--];
					num1 = stackNum[top--];
					stackNum[++top] = num1 + num2;
					break;
				case '*':
					num2 = stackNum[top--];
					num1 = stackNum[top--];
					stackNum[++top] = num1 * num2;
					break;
				default:
					stackNum[++top] = c-'0';
					break;
				}
			}
			System.out.println(stackNum[top--]);
		}
	}
}
