import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        for(int i=0;i<n;i++){
            int x = pq.poll();
            pq.add(--x);
        }
        for(int i=0;i< works.length;i++){
            int x = pq.poll();
            if(x>0){
                answer+=x*x;
            }
        }
        return answer;
    }
}