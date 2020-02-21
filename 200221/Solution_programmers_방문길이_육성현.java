class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[11][11];
        boolean[][][] visited = new boolean[11][11][2];
        int locx = 5;
        int locy = 5;

        for(int i=0;i<dirs.length();i++){
            char c = dirs.charAt(i);
            int d;
            if(c=='U'){
                locy++;
                if(locy==11){
                    locy=10;
                    continue;
                }
                if(!visited[locx][locy-1][0]){
                    answer++;
                    visited[locx][locy-1][0]=true;
                }
            }else if(c=='D'){
                locy--;
                if(locy<0){
                    locy=0;
                    continue;
                }
                if(!visited[locx][locy][0]){
                    answer++;
                    visited[locx][locy][0]=true;
                }
            }else if(c=='R'){
                locx++;
                if(locx==11){
                    locx=10;
                    continue;
                }
                if(!visited[locx-1][locy][1]){
                    answer++;
                    visited[locx-1][locy][1]=true;
                }
            }else if(c=='L'){
                locx--;
                if(locx<0){
                    locx=0;
                    continue;
                }
                if(!visited[locx][locy][1]){
                    answer++;
                    visited[locx][locy][1]=true;
                }
            }
        }
        return answer;
    }
}