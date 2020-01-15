#include<iostream>
#include<cmath>
using namespace std;
int func(int L, int R);
void makePrime();
int arr[250000] = { 3,5,7 };
int cnt = 3;
int main() {
    ios::sync_with_stdio(false), cin.tie(0);
    int T;
    cin >> T;
    makePrime();
    int L, R;
    for (int i = 0; i < T; i++) {
        cout << "#" << i + 1 << " ";
        cin >> L >> R;
        cout << func(L, R) << endl;
    }
}
void makePrime() {
    for (int i = 11; i <= 1000000; i += 2) {
        bool vec = true;
        for (int j = 0; j < cnt; j++) {

            if (i % arr[j] == 0) {
                vec = false;
                break;
            }
            else if (arr[j] > sqrt(i)) break;
        }
        if (vec) {
            arr[cnt++] = i;
        }
    }
}
int func(int L, int R) {
    int result = 0;
    if (L <= 2 && R >= 2) result++;
    for (int i = 0; i < cnt; i++) {
        if (arr[i] > R) break;
        else if (arr[i] >= L && arr[i] % 4 == 1) result++;
    }
    return result;
}