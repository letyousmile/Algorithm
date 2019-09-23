import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 사용자의 입력을 받는 방법
 *  1. BufferedReader
 *  2. Scanner
 *  3. JOptionPane swing 에서 사용
 * @author student
 *
 */
public class Solution_1210_SW문제해결기본2일차_Ladder1_육성현 {
	public static int[][] ladder;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
//		String name = JOptionPane.showInputDialog("이름을 입력하세요"); //문자열로만 리턴
		
		//자바 초기버전 부터 사용
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		//키보드로부터 입력 받을 객체를 준비
//		
//		String age = br.readLine(); //Scanner next Line이랑 똑같음 엔터를 입력할 때까지의 한줄을 받아감, 엔터를 소비
//		//문자열 String = > 기본형 타입으로 변환 parsing
//		int age3 = Integer.parseInt(age); // String -> int 알고리즘에선 얘를 사용함(빠름)
////		int age2 = Integer.valueOf(age); //String을 int형으로 바꿔줌 Integer :: Wrapper class 현업에 자바사용, 메서드의 이름을 통일해놓음
//		
//		double dd = Double.parseDouble("3.14");
//		double dd2 = Double.valueOf("3.14");
//		
//		//기본형 타입 = > 문자열 String
//		int age4 = 27;
//		String ss = age4 + ""; //이게 제일 자주 쓰임
////		
//		//String 클래스의 메서드
//		
//		String sss = " 1  3 ";
//		sss= sss.trim(); // 앞, 뒤 화이트스페이스 제거
//		System.out.println("["+sss+"]");
//		
//		sss = "호랑이 사자 기린 코끼리";
//		String[] arr = sss.split(" "); //구분자를 기준으로 문자열을 쪼개
//		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<10;i++) {
			ladder = new int[100][100];
//			int testNumber = sc.nextInt();
			int testNumber = Integer.parseInt(br.readLine());
			int now = input();
			for(int j=99;j>=0;j--) {
				if(now+1<100&&ladder[j][now+1]==1) {
					while(now+1<100&&ladder[j][now+1]==1) {
						now++;
					}
				}
				else if(now-1>=0&&ladder[j][now-1]==1) {
					while(now-1>=0&&ladder[j][now-1]==1) {
						now--;
					}
				}
				//System.out.println(now);
			}
			System.out.println("#"+(testNumber)+" "+now);
		}
	}//end of main
	public static int input() throws IOException {
		
		int start=0;
		for(int i=0;i<100;i++) {
//			String s =br.readLine();
//			String[] srr = s.split(" ");
			
//			StringTokenizer st = new StringTokenizer(br.readLine()," "); //구분자를 지정하는 것이 빠르다. 그러나 정규표현식이 안됨
			
			String s = br.readLine();
			for(int j=0;j<100;j++) {
				ladder[i][j]=s.charAt(j*2)-'0';
				if(ladder[i][j]==2)
					start=j;
			}
		}
		return start;
	}
}//end of class
