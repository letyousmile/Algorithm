import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int now = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        int index = 0;
        int answer = 0;
        while(index<jobs.length){
            if(pq.isEmpty()&&jobs[index][0]>now){
                now = jobs[index][0];
            }
            while(jobs[index][0]<=now){
                pq.add(jobs[index++]);
                if(index==jobs.length) break;
            }
            if(!pq.isEmpty()){
                int[] polled = pq.poll();
                answer+=now-polled[0]+polled[1];
                now += polled[1];
            }
        }
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            answer+=now-polled[0]+polled[1];
            now += polled[1];
        }
        return answer/index;
    }
}