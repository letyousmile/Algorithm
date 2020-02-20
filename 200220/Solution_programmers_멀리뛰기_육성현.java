class Solution {
    public long solution(int n) {
        long a = 1;
        long b = 2;
        for(int i=3;i<=n;i++){
            long temp = b;
            b= (a+b)%1234567;
            a = temp;
        }
        if(n==1) return a;
        else
            return b;
    }
}