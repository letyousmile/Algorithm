#include<iostream>
using namespace std;
int loc1[100000];
int loc2[100000];
int abs(int x) {
	return x > 0 ? x : -x;
}
long long func(string a, string b) {
	int numOfOne = 0;
	int numOfTwo = 0;
	long result = 0;
	for (int i = 0; i < a.length(); i++) {
		if (a[i]=='a') {
			loc1[numOfOne++] = i;
		}
		if (b[i] == 'a') {
			loc2[numOfTwo++] = i;
		}
	}
	for (int i = 0; i < numOfOne; i++) {
		result += abs(loc1[i] - loc2[i]);
	}
	return result;
}
int main() {
	ios::sync_with_stdio(false); cin.tie(0);
	int T;
	cin >> T;
	string a, b;
	for (int i = 1; i <= T; i++) {
		cin >> a;
		cin >> b;
		long long result = 0;
		cout << "#" << i;
		cout << " " << func(a,b) << endl;
	}
}