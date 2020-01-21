#include<iostream>
using namespace std;

long long N, H;
long long a[100001];
int main() {
	ios::sync_with_stdio(false); cin.tie(0);
	int T;
	cin >> T;
	for (int i = 1; i <= T; i++) {
		cin >> N >> H;
		long long cur = 1;
		long long result = 0;
		for (int j = 0; j < N; j++) {
			cin >> a[j];
		}
		for (int j = 0, temp; j < N; j++) {
			cin >> temp;
			if (temp) cur = 1;
			else {
				if (j == 0 || j == N - 1) {
					cur = H + 1;
				}
				else cur += a[j];
			}
			if (cur > H) cur = 1, result++;
		}
		cout << "#" << i;
		cout << " " << result << endl;
	}
}