import java.util.*;

class Solution {
    Map map = new HashMap<String, LinkedList<String>>();
    String[] q = new String[10000];
    int num;
    boolean finished = false;
    String[] result;
    public String[] solution(String[][] tickets) {
        num = tickets.length;
        result = new String[num+1];
        for(int i=0;i<num;i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(map.containsKey(from)){
                List<String> list =(LinkedList)map.get(from);
                list.add(to);
                Collections.sort(list);
                map.put(from,list);
            }else{
                List<String> list = new LinkedList<>();
                list.add(to);
                map.put(from,list);
            }
        }
        dfs("ICN",0);
        return result;
    }
    public void dfs(String start,int loc){
        if(finished){
            return;
        }
        result[loc] = start;
        if(loc==num+1) {
            finished = true;
            return;
        }
        List<String> list = (LinkedList)map.get(start);
        if(list==null) return;
        for(int i=0;i<list.size();i++) {
            String next = list.remove(i);
            dfs(next, loc + 1);
            list.add(i, next);
        }
    }
}