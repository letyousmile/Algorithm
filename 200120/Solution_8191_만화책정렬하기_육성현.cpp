#include<iostream>
using namespace std;

int N;
int S[200000];
bool visited[200001];
int func() {
	visited[N] = false;
	int result = 0;
	for (int i = 0; i < N; i++) {
		visited[S[i]] = true;
		if (!visited[S[i] - 1]) result++;
	}
	return result;
}
int main() {
	int T;
	cin >> T;
	for (int i = 1; i <= T; i++) {
		cin >> N;
		for (int j = 0; j < N; j++) {
			cin >> S[j];
			visited[j] = false;
		}
		cout << "#" << i;
		cout << " " << func() << endl;
	}
}