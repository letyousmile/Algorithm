#include <string>
#include <vector>

using namespace std;
vector<vector<int>> v;
bool visited[200];
int q[200];
int N;
void bfs(int start) {
    int f = -1;
    int r = -1;
    visited[start] = true;
    q[++r] = start;
    while (f != r) {
        int here = q[++f];
        for (int i = start + 1; i < N; i++) {
            if (i != here && v[here][i] == 1 && !visited[i]) {
                q[++r] = i;
                visited[i] = true;
            }
        }
    }
}
int solution(int n, vector<vector<int>> computers) {
    v = computers;
    N = n;
    int answer = 0;
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            answer++;
            bfs(i);
        }
    }
    return answer;
}