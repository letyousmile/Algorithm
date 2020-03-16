class Solution {
    char[] stack = new char[1000];
    public String solution(String p) {
        int len = p.length();
        if(len==0) return "";
        int left = 0;
        int right = 0;
        int top = -1;
        for(int i=0;i<len;i++){
            if(p.charAt(i)=='('){
                left++;
                stack[++top] = '(';
            }else if(p.charAt(i)==')'){
                right++;
                if(top!=-1&&stack[top]=='('){
                    top--;
                }else{
                    stack[++top]=')';
                }
            }
            if(left!=0 &&left==right) {
                if(top==-1) return p.substring(0,i+1)+solution(p.substring(i+1));
                return "("+solution(p.substring(i+1))+")"+reverse(p.substring(1,i));
            }
        }
        return "";
    }
    public String reverse(String p) {
        String result ="";
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){
                result +=')';
            }else{
                result +='(';
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        s.solution("))(()()(");
    }
}