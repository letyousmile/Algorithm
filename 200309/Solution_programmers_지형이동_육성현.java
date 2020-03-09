import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int h;
    int map[][];
    int[] dy = {0,0,1,-1};
    int[] dx = {1,-1,0,0};
    int answer;
    class Point{
        int y;
        int x;
        int value;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Point(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
    public int solution(int[][] land, int height) {
        map = land;
        h = height;
        bfs();
        return answer;
    }
    public void bfs(){
        int len = map.length;
        int obj = len*len;
        int now = 0;
        Point start = new Point(0,0,0);
        boolean[][] visited = new boolean[len][len];
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.value-o2.value;
            }
        });
        Point[] q = new Point[len*len];
        int f = -1;
        int r = -1;
        q[++r] = start;
        visited[0][0]=true;
        while(now<obj) {
            Point here;
            if(f==r){
                while(true){
                    here = pq.poll();
                    if(!visited[here.y][here.x]) break;
                }
                visited[here.y][here.x]=true;
                answer+=here.value;
            }else{
                here = q[++f];
            }
            now++;
            for(int i=0;i<4;i++){
                int newy = here.y+dy[i];
                int newx = here.x+dx[i];
                if(newy<0||newx<0||newy==len||newx==len||visited[newy][newx]) continue;
                if(Math.abs(map[newy][newx]-map[here.y][here.x])>h) {
                    pq.add(new Point(newy,newx,Math.abs(map[newy][newx]-map[here.y][here.x])));
                }else{
                    q[++r]=new Point(newy,newx,0);
                    visited[newy][newx]=true;
                }
            }
        }
    }
}