import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_1213_SW문제해결기본3일차_String{
	static String input;
	static String p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<10;i++) {
			int T = Integer.parseInt(br.readLine());
			p = br.readLine();
			input = br.readLine();
			System.out.println("#"+(T)+" "+find());
		}
	}
	public static int find() {
		int num = 0;
		for(int i=0;i<input.length()-p.length()+1;i++) {
			if(p.equals(input.substring(i, i+p.length()))) num++;
		}
		return num;
	}
}