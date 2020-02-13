import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    String start;
    String end;
    String[] cases = new String[50];
    int answer;
    boolean[] visited = new boolean[50];
    Map<String,Integer> map = new HashMap<>();
    List<String>[] list = new ArrayList[51];
    class Input{
        String w;
        int n;
        public Input(String w, int n) {
            this.w = w;
            this.n = n;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
    public int solution(String begin, String target, String[] words) {
        map.put(begin,0);
        list[0] = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int diffNum2 = 0;
            for(int k=0;k<begin.length();k++){
                if(begin.charAt(k)!=words[i].charAt(k)){
                    diffNum2++;
                }
            }
            if(diffNum2==1){
                list[0].add(words[i]);
            }
            map.put(words[i],i+1);
            list[i+1] = new ArrayList<>();
            cases[i] = words[i];
            for(int j=0;j<words.length;j++){
                String str1 = words[i];
                String str2 = words[j];
                int diffNum = 0;
                for(int k=0;k<str1.length();k++){
                    if(str1.charAt(k)!=str2.charAt(k)){
                        diffNum++;
                    }
                }
                if(diffNum==1){
                    list[i+1].add(str2);
                }
            }
        }
        start = begin;
        end = target;
        bfs();
        return answer;
    }
    public void bfs(){
        Input[] q = new Input[50];
        int f = -1;
        int r = -1;
//        System.out.println(map);
        int s = map.get(start);
        visited[s] = true;
        q[++r] = new Input(start,0);
        while(f!=r){
            Input now = q[++f];
            if(now.w.equals(end)){
                answer = now.n;
            }
            int strNum = map.get(now.w);
            for(int i=0;i<list[strNum].size();i++){
                String str = list[strNum].get(i);
                if(!visited[map.get(str)]){
                    Input next = new Input(str,now.n+1);
                    visited[map.get(str)] = true;
                    q[++r] = next;
                }
            }
        }
    }
}