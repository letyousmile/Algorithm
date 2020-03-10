import java.util.Arrays;

class Solution {
    public int solution(int[] weight) {
        Arrays.sort(weight);
        if(weight[0]>1) return 1;
        int sum = 1;
        for(int i=1;i<weight.length;i++){
            if(sum+1<weight[i]){
                return sum + 1;
            }
            sum += weight[i];
        }
        return sum+1;
    }
}