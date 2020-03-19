class Solution {
    int len;
    int answer;
    int[] list = new int[3];
    int[] input;
    public int solution(int[] nums) {
        input = nums;
        len = nums.length;
        combination(0,0);

        return answer;
    }
    public void combination(int loc, int num){
        if(num==3){
            int sum = 0;
            for(int i=0;i<3;i++){
                sum += input[list[i]];
            }
            if(sum%2==0){

            }else if(isPrime(sum)){
                answer++;
            }
        }
        else{
            for(int i=loc;i<len;i++){
                list[num]=i;
                combination(i+1,num+1);
            }
        }
    }
    public boolean isPrime(int num){
        for(int i=3;i<=Math.sqrt(num);i+=2){
            if(num%i==0) return false;
        }
        return true;
    }
}