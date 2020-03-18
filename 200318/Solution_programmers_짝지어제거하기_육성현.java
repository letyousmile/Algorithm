class Solution {
    int index = 0;
    public int solution(String s) {
        if(s.length()%2==1) return 0;
        char[] stack = new char[s.length()];
        int top = -1;
        stack[++top] = s.charAt(0);
        for(int i =1;i<s.length();i++){
            char prev = stack[top];
            char next = s.charAt(i);
            if(prev==next) {
                if(top==0){
                    if(i+1<s.length()){
                        stack[top] = s.charAt(i+1);
                        i++;
                    }else{
                        top--;
                    }
                }else{
                    top--;
                }
            }else{
                stack[++top] = next;
            }
        }
        if(top==-1) return 1;
        else return 0;
    }
}