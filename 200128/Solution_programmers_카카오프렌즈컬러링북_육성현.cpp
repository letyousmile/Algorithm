#include <vector>

using namespace std;

bool visited[100][100];
int M, N;

int bfs(int y, int x, int m, vector<vector<int>> picture) {
    int dx[4] = { 1,-1,0,0 };
    int dy[4] = { 0, 0,1,-1 };

    pair<int, int> q[10001];
    int f = -1;
    int r = -1;
    int area = 0;
    int color = picture[y][x];

    q[++r] = make_pair(y, x);
    visited[y][x] = true;
    area++;
    while (f != r) {
        pair<int, int> here = q[++f];
        for (int i = 0; i < 4; i++) {
            int therey = here.first + dy[i];
            int therex = here.second + dx[i];
            if (therey < 0 || therex < 0 || therey == M || therex == N || visited[therey][therex] || color != picture[therey][therex]) continue;
            q[++r] = make_pair(therey, therex);
            visited[therey][therex] = true;
            area++;
        }
    }
    return area > m ? area : m;
}
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    M = m;
    N = n;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
            visited[i][j] = false;
        }
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (!visited[i][j]) {
                if (picture[i][j] != 0) {
                    number_of_area++;
                    max_size_of_one_area = bfs(i, j, max_size_of_one_area, picture);
                }
            }
        }
    }


    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}