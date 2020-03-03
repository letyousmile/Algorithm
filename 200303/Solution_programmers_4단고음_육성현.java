class Solution {
    int answer;
    int obj;
    public int solution(int n) {
        func(n,0);
        return answer;
    }
    public void func(int now, int num){
        if(now<3 || now < Math.pow(3,num/2)) return;
        if(now==3&&num==2){
            answer++;
        }else if(now>3){
            if(now%3==0&&num>=2){
                func(now/3,num-2);
            }
            func(now-1,num+1);
        }
    }
}