import java.util.HashMap;
import java.util.Map;

class Solution {
    static String[] solution(String[] record) {
		Map<String,String> map = new HashMap<>();
		boolean[] vec = new boolean[record.length];
		boolean[] ch = new boolean[record.length];
		String[] keys = new String[record.length];
		int len = record.length;
		for(int i=0;i<record.length;i++) {
			String[] input = record[i].split(" ");
			keys[i] = input[1];
			if(input[0].equals("Enter")) {
				map.put(input[1], input[2]);
				vec[i] = true;
			}else if(input[0].equals("Leave")){
				vec[i] = false;
			}else {
				map.put(input[1], input[2]);
				len--;
				ch[i] = true;
			}
		}
		String[] answer = new String[len];
		int num = 0;
		for(int i=0;i<vec.length;i++) {
			if(ch[i]) continue;
			String user = map.get(keys[i]);
			String message = "";
			if(vec[i]) {
				message = user+"님이 들어왔습니다.";
			}else {
				message = user+"님이 나갔습니다.";
			}
			answer[num++] = message;
		}
		return answer;
	}
}