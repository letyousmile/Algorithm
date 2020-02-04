#include <string>
#include <vector>
int cache[101][101];
using namespace std;
int M, N;
int map[101][101];
vector<vector<int>> v;
void init(int m, int n, vector<vector<int>> puddles) {
	M = m;
	N = n;
	for (int i = 0; i < puddles.size(); i++) {
		map[puddles[i][0]][puddles[i][1]] = 1;
	}
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			cache[i][j] = -1;
		}
	}
}
int goSchool(int y, int x) {
	if (y > M || x > N) return 0;
	if (y == M && x == N) return 1;
	if (map[y][x] == 1) return 0;
	if (cache[y][x] != -1) return cache[y][x];
	return cache[y][x] = (goSchool(y + 1, x) + goSchool(y, x + 1)) % 1000000007;
}
int solution(int m, int n, vector<vector<int>> puddles) {
	init(m, n, puddles);

	return goSchool(1, 1);
}