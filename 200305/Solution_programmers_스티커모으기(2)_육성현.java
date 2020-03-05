class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if(len==1) return sticker[0];
        int a1 = sticker[0];
        int b1 = sticker[0];
        int c1 = sticker[0];
        int a2 = 0;
        int b2 = sticker[1];
        int c2 = sticker[1];
        for(int i=2;i<len-1;i++){
            c1 = max(a1 + sticker[i], b1);
            a1 = b1;
            b1 = c1;
            c2 = max( a2 + sticker[i], b2);
            a2 = b2;
            b2 = c2;
        }
        c2 = max(a2 + sticker[len-1], b2);
        return max(c1,c2);
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
}