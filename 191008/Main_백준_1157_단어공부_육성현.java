import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1157_단어공부_육성현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] preq = new int[26];
        for(int i=0;i<input.length();i++) {
        	char c = input.charAt(i);
        	if(c>='a') {
        		preq[c-'a']++;
        	}else {
        		preq[c-'A']++;
        	}
        }
        int max = 0 ;
        int maxIndex = -1;
        for(int i=0;i<26;i++) {
        	if(preq[i]>max) {
        		max = preq[i];
        		maxIndex = i;
        	}
        }
        for(int i=0;i<26;i++) {
        	if(i!=maxIndex&&preq[i]==max) {
        		System.out.println("?");
        		return;
        	}
        }
        System.out.println((char)('A'+maxIndex));
    }
}
