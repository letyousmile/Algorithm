import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    long f[] = new long[21];
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        make_f();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        int x = 0;
        for(int i=0;i<n;i++){
            x = (int)((k-1)/f[n-1-i]);
            answer[i] = list.remove(x);
            k = k-(x*f[n-1-i]);
        }
        return answer;
    }
    public void make_f(){
        f[0] = 1;
        for(int i=1;i<=20;i++){
            f[i] = f[i-1]*(long)i;
        }
    }
}