import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int now = routes[0][1];
        for(int i=1;i<routes.length;i++) {
            if(routes[i][0]>now){
                now = routes[i][1];
                answer++;
            }

        }
        return answer;
    }
}