class Solution {
    public long solution(int w,int h) {
        long answer = (long)w * (long)h;
        long temp = (long)h;
        for (int i = 1; i <= w; i++){
            long mul = (long)h*(long)i;
            long y = h - mul / (long)w;
            if(mul%w!=0) {
                answer--;
            }
            answer -= (temp-y);
            temp = y;
        }
        return answer;
    }
}