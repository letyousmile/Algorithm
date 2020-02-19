import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int[][] map;
    int[] d;
    boolean[] visited;
    int num;
    int L;
    public int solution(int N, int[][] road, int K) {
        L=K;
        int answer=0;
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        num = N;
        d = new int[N+1];
        for(int i=1;i<=N;i++){
            d[i]=500001;
            for(int j=1;j<=N;j++){
                map[i][j]=10001;
            }
        }
        d[1]=0;
        for(int i=0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int price = road[i][2];

            if(map[from][to]>price){
                map[from][to]=price;
                map[to][from]=price;
            }
        }
        Dijkstra();
        for(int i=1;i<=N;i++){
            if(d[i]<=K){
                answer++;
            }
        }
        return answer;
    }
    public void Dijkstra(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return d[o1.intValue()]-d[o2.intValue()];
            }
        });
        pq.add(1);
        visited[1]=true;
        while(!pq.isEmpty()){
            int start = pq.poll();
            for(int i =2;i<=num;i++){
                if(i==start) continue;
                if(map[start][i]!=10001){
                    d[i]=min(d[start]+map[start][i],d[i]);
                    if(!visited[i]&&d[i]<=L){
                        pq.add(i);
                        visited[i]=true;
                    }
                }
            }
        }
    }
    public int min(int a,int b){
        return a<b?a:b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] road = new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        s.solution(5,road,3);
    }
}