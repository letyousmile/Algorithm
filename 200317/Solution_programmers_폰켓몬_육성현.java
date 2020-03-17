class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] have = new boolean[200001];
        for(int i = 0;i<nums.length;i++){
            if(!have[nums[i]]){
                have[nums[i]]=true;
                answer++;
            }
        }
        if(answer>nums.length/2) return nums.length/2;
        return answer;
    }
}