import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_마이쮸_육성현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] queue = new int[100];
		int[] num = new int[100];
		for(int i=0;i<20;i++) {
			num[i]=1;
		}
		int sum = 0;
		int pnum = 1;
		num[0]=1;
		int f = -1;
		int r = -1;
		queue[++r] = 0;
		int people = 0;
		int numOfPeople = 1;
		while(sum<20) {
			br.readLine();
			System.out.println("큐에 "+ numOfPeople + "명이 서 있습니다. ");
			people = queue[++f];
			sum += num[people];
			br.readLine();
			System.out.println((people+1)+"번째 사람이 "+num[people]+ "개 가져갔습니다 ");
			numOfPeople--;
			num[people]++;
			queue[++r] = people;
			System.out.println((people+1)+"번째 사람이 줄을 다시 섭니다.");
			numOfPeople++;
			System.out.println((pnum+1)+"번째 사람이 줄을 새로 섭니다.");
			queue[++r] = pnum++;
			numOfPeople++;
			br.readLine();
			System.out.println("현재까지 "+ sum + "개 나눠주었습니다");
		}
		System.out.println((people+1)+"번째 사람이 20번째 마이쮸를 먹었습니다.");
	}
}
