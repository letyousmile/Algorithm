import java.util.Arrays;

/**
 * Knapsack 배낭문제
 * 물건 쪼갤 수 있는 문제 :그리디로 풀 수 있음(가치/무게당으로 정렬하여 가치가 큰 것부터 담는다)
 * 물건이 1개씩 존재, 물건이 여러개 존재하는 경우
 * 물건 쪼갤 수 없는 문제(0-1
 * @author student
 *
 */
public class Z47_Knapsack {
	public static void main(String[] args) {
		System.out.println(f(10));
	} //end of main
	public static int f(int n) {
		int[][] item = {{10,5},{40,4},{30,6},{50,3}}; // {가격(만원), 무게(kg)}
		int[][] K = new int[item.length+1][n+1]; // 행:고려할 물건의 개수, 열:배낭의임시무게
		
		//첫행(물건을 아무것도 고려하지 않은 경우의 가치), 첫열(배낭의 임시무게 0kg일 경우의 가치)를 0으로 초기화
		
		//물건의 무게보다 배낭의 무게가 적은 경우는 이전 행의 데이터를 그대로 복사
		for(int i=0;i<item.length;i++) {
			for (int w = 0; w < item[i][1]; w++) {
				K[i+1][w] = K[i][w];
			}
			for(int w= item[i][1];w<=n;w++) {
				int pre = K[i][w]; //1번 물건을 고려하지 않은 경우(이전행의 값)
				int now = K[i][w-item[i][1]]+item[i][0];//1번 물건을 고려한 경우
				K[i+1][w] = now>=pre? now: pre;
			}
		}
		for(int i=0;i<K.length;i++) {
			System.out.println(Arrays.toString(K[i]));
		}
		return K[item.length][n];
	}
}//end of class
