import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<26;i++){
            char c = (char)('A'+i);
            map.put(c,-1);
        }
        for(int i=0;i<skill.length();i++){
            char c = skill.charAt(i);
            map.put(c,i);
        }
        int answer = skill_trees.length;
        for(int i=0;i<skill_trees.length;i++){
            String str = skill_trees[i];
            int now = 0;
            for(int j=0;j<str.length();j++){
                int x = map.get(str.charAt(j));
                if(x>now){
                    answer--;
                    break;
                }
                if(x!=-1){
                    now = x + 1;
                }
            }
        }
        return answer;
    }
}