
import java.util.*;

class Tower{

	int h;

	int i;

	public Tower(int h, int i) {

		this.h=h;

		this.i=i;

	}

}

public class Main {

	public static void main(String[] args){

 

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		

		int[] answer = new int[N+1];

		Stack<Tower> stack = new Stack<Tower>();

		for(int i=1;i<=N;i++) {

			int now = sc.nextInt();

			Tower tower = new Tower(now,i);

			while(!stack.empty()) {

				if(stack.peek().h<now) {

					stack.pop();

				}else if(stack.peek().h>now) {

					answer[i] = stack.peek().i;

					break;

				}

			}

			if(stack.empty()) {

				answer[i] = 0;

			}

			stack.push(tower);

		}

		for(int i=1;i<=N;i++) {

			System.out.print(answer[i]+" ");

		}

		System.out.println();

	}

}
