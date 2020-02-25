import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<operations.length;i++){
            System.out.println(list.toString());
            if(operations[i].charAt(0)=='I'){
                int input = Integer.parseInt(operations[i].split(" ")[1]);
                list.add(input);
            }else{
                if(list.isEmpty()) {
                    continue;
                }
                Collections.sort(list);
                if(operations[i].split(" ")[1].equals("1")){
                    list.remove(list.size()-1);
                }else{
                    list.remove(0);
                }
            }
        }
        Collections.sort(list);
        if(list.size()==0){
            return new int[]{0,0};
        }else{
            return new int[]{list.get(list.size()-1),list.get(0)};
        }
    }
}