import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_7701_염라대왕의이름정렬_육성현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			Set<String> set = new HashSet<>();
			for(int j=0;j<N;j++) {
				set.add(br.readLine());
			}
			List<String> list = new ArrayList<String>(set);
			list.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					if(o1.length()==o2.length()) return o1.compareTo(o2);
					else return Integer.valueOf(o1.length()).compareTo(o2.length());
				}
			});
			sb.append("#"+(i+1)+"\n");
			for(int j=0;j<list.size();j++) {
				sb.append(list.get(j)+"\n");
			}
		}
		System.out.println(sb);
	}
}
