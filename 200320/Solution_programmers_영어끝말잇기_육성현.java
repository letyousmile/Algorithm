import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Set<String> set = new HashSet<>();
        String prev= words[0];
        set.add(prev);
        for(int i=1;i<words.length;i++) {
            String word = words[i];
            System.out.println(prev+" "+word);
            if (set.contains(word)||word.charAt(0)!=prev.charAt(prev.length()-1)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }else{
                set.add(word);
            }
            prev = word;
        }
        return answer;
    }
}