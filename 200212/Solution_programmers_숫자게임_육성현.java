import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int loc = 0;
        for(int i=0;i<A.length;i++){
            for(int j=loc;j<B.length;j++){
                if(B[j]>A[i]){
                    loc = j+1;
                    answer++;
                }
            }
        }
        return answer;
    }
}