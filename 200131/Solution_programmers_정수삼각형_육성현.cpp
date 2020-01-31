#include <string>
#include <vector>

int cache[500][500];
using namespace std;
int len;
vector<vector<int>> v;
void init() {
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < i + 1; j++) {
            cache[i][j] = -1;
        }
    }
}
int max(int a, int b) {
    return a > b ? a : b;
}
int goDown(int y, int x) {
    if (y == len - 1) return v[y][x];
    if (cache[y][x] != -1) return cache[y][x];
    return cache[y][x] = v[y][x] + max(goDown(y + 1, x), goDown(y + 1, x + 1));
}
int solution(vector<vector<int>> triangle) {
    len = triangle.size();
    v = triangle;
    init();
    int starty = 0;
    int startx = 0;
    int answer = 0;
    return goDown(starty,startx);
}