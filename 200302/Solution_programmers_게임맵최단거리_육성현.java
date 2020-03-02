class Solution {
    class Point{
        int y;
        int x;
        int turn;
        public Point(int y, int x,int turn) {
            this.y = y;
            this.x = x;
            this.turn = turn;
        }
    }
    int[] dy = {0,0,1,-1};
    int[] dx = {1,-1,0,0};
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        Point[] q = new Point[n*m+1];
        boolean[][] visited = new boolean[n][m];
        Point start = new Point(0,0,1);
        int f = -1;
        int r = -1;
        q[++r] = start;
        while(f!=r){
            Point here = q[++f];
            if(here.y==n-1&&here.x==m-1){
                return here.turn;
            }
            for(int i=0;i<4;i++){
                int newy = here.y+dy[i];
                int newx = here.x+dx[i];
                if(newy<0||newx<0||newy==n||newx==m||visited[newy][newx]||maps[newy][newx]==0) continue;
                visited[newy][newx]=true;
                q[++r] = new Point(newy,newx,here.turn+1);
            }
        }
        return answer;
    }
}