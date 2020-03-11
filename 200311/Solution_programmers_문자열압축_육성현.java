class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i <= s.length()/2; i++) {
            String sub = s.substring(0,i);
            int now = i;
            int temp = s.length();
            int num = 1;
            while(now<=s.length()-i){
                String str = s.substring(now,now+i);
                if(sub.equals(str)){
                    num++;
                    if(num==2){
                        temp++;
                    }else if(num==10){
                        temp++;
                    }else if(num==100){
                        temp++;
                    }else if(num==1000){
                        temp++;
                    }
                    temp -= i;
                }else{
                    sub = str;
                    num = 1;
                }
                now+=i;
            }
            if(temp<answer){
                answer=temp;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("aaaaaaaaaa"));
    }
}