import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long low = 0;
        long high = times[0]*(long)n;
        long mid=0;
        long sum = 0;
        while(low<=high){
            sum = 0;
            mid = (low+high)/2;

            for(int i=0;i<times.length;i++){
                sum+=(mid/times[i]);
            }
            if(sum>=n){
                high = mid-1;
            }else if(sum<0) {
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        if(sum<n) mid++;
        return mid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6,new int[]{7,10}));
    }
}