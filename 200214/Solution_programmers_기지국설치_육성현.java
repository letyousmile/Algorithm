class Solution {
    int p;
    int answer;
    public int solution(int n, int[] stations, int w) {

        p = (w*2)+1;
        int start = 0;
        int end = n;
        for(int i=0;i<stations.length;i++){
            search(start,stations[i]-w);
            start = stations[i]+w;
        }
        search(start,end+1);
        return answer;
    }
    public void search(int low, int high){
        int remain = high-low-1;
        if(remain<0) return;
        int q = remain/p;
        answer +=q;
        if(remain%p!=0) answer++;
    }
}