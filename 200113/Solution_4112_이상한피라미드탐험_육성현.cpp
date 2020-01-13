#include<iostream>
using namespace std;
int func(int a, int b);
int floor(int x);
int main() {
	int T;
	cin >> T;

	int a, b;
	string result = "";
	for (int i = 0; i < T; i++) {
		cin >> a >> b;
		cout << "#" << i + 1 << " " << func(a, b) << endl;
	}
}
int floor(int x) {
	int start, end;
	if (x <= 1275) {
		start = 1;
		end = 50;
	}
	else if (x <= 5050) {
		start = 51;
		end = 100;
	}
	else {
		start = 101;
		end = 141;
	}
	int low, high;

	for (int i = start; i <= end; i++) {
		low = (i * i - i + 2) / 2;
		high = (i * i + i) / 2;
		if (low <= x&&x <= high) {
			return i;
		}
	}
}
int func(int a, int b) {
	int big = a > b ? a : b;
	int small = a < b ? a : b;
	int lowFloor = floor(small);
	int highFloor = floor(big);
	int d = highFloor - lowFloor;
	for (int i = lowFloor; i < highFloor; i++) {
		small += i;
	}
	if (small > big) return d + small - big;
	else if (big - small <= d) return d;
	else return big - small;
}