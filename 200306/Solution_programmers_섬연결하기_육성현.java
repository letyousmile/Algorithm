import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    class Pair{
        int from;
        int to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    int N;
    int[][] map;
    int answer;

    public void prim(){
        int loc = 0;
        int num = 1;
        boolean[] visited = new boolean[N];
        visited[0] = true;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return map[o1.from][o1.to]-map[o2.from][o2.to];
            }
        });
        while(num<N){
            for(int i=0;i<N;i++){
                if(i==loc) continue;
                if(map[loc][i]!=0&&!visited[i]) {
                    pq.add(new Pair(loc,i));
                }
            }
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                if(!visited[p.to]){
                    visited[p.to]=true;
                    loc = p.to;
                    answer += map[p.from][p.to];
                    num++;
                    break;
                }
            }
        }
    }
    public int solution(int n, int[][] costs) {
        N = n;
        map = new int[n][n];
        for(int i = 0;i<costs.length;i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int v = costs[i][2];
            map[from][to] = v;
            map[to][from] = v;
        }
        prim();
        return answer;
    }
}