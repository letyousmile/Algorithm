#include <vector>

using namespace std;
// 1은 아래로 y
// 2은 오른쪽으로 x
int cache[500][500][3];
int MOD = 20170805;
int M, N;
vector<vector<int>> v;
// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.

int drive(int y, int x, int d) {
    if (y == M - 1 && x == N - 1) return 1;
    else if (y == M || x == N || v[y][x] == 1) return 0;
    if (v[y][x] == 2) {
        if (cache[y][x][d] != -1) return cache[y][x][d];
        if (d == 1) return cache[y][x][d] = drive(y + 1, x, d);
        else return cache[y][x][d] = drive(y, x + 1, d);
    }
    else {
        if (cache[y][x][0] != -1) return cache[y][x][0];
        return cache[y][x][0] = (drive(y, x + 1, 2) + drive(y + 1, x, 1)) % MOD;
    }
}
int solution(int m, int n, vector<vector<int>> city_map) {
    M = m;
    N = n;
    v = city_map;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < 3; k++) {
                cache[i][j][k] = -1;
            }
        }
    }
    return drive(0, 0, 0);
}