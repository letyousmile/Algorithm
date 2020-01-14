#include<iostream>
using namespace std;
int N;
int mass[10];
int loc[10];
double answer[9];

double abs1(double x);
void func();
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout << fixed;
	cout.precision(10);
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> N;
		for (int j = 0; j < N; j++) {
			cin >> loc[j];
		}
		for (int j = 0; j < N; j++) {
			cin >> mass[j];
		}
		cout << "#" << i + 1 << " ";
		func();
		cout << endl;
	}
	return 0;
}
void func() {
	for (int i = 0; i < N-1; i++) {
		double left = (double)loc[i];
		double right = (double)loc[i + 1];
		double answer;

		double lp = 0;
		double rp = 0;
		int cnt = 0;
		while (true) {
			answer = (left + right) / 2;
			for (int j = 0; j < i + 1; j++) {
				lp += (mass[j] / ((answer - loc[j])*(answer - loc[j])));
			}
			for (int j = i + 1; j < N; j++) {
				rp += (mass[j] / ((answer - loc[j])*(answer - loc[j])));
			}

			//cout << left << " "<<right <<" "<< answer <<" " <<lp<<" "<<rp<<endl;
			if (abs1(lp - rp) <= 0.0000000000001||cnt++==100) {
				cout << answer << " ";
				break;
			}
			if (lp > rp) {
				left = answer;
			}
			else {
				right = answer;
			}
		}
	}
}
double abs1(double x) {
	return x >= 0 ? x : -x;
}