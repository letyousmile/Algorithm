class Solution {
    int[][] cache = new int[2000][2000];
    public int solution(int[] cookie) {
        int answer = 0;
        for(int i=0;i<cookie.length;i++){
            cache[i][i] = cookie[i];
            for(int j=i+1;j<cookie.length;j++){
                cache[i][j] = cache[i][j-1] + cookie[j];
            }
        }
        for(int i=0;i<cookie.length;i++){
            for(int j=i+1; j<cookie.length;j++){
                int low = i;
                int high = j;
                int mid;
                while(low<=high){
                    mid = (low+high)/2;
                    if(cache[i][mid]==cache[mid+1][j]){
                        if(cache[i][mid]>answer){
                            answer = cache[i][mid];
                        }
                        break;
                    }else if(cache[i][mid]>cache[mid+1][j]){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
            }
        }
        return answer;
    }
}