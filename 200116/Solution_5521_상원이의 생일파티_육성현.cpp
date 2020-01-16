#include<iostream>

int num[501];
int relation[501][500];
bool check[501];
using namespace std;
int N, M;
void func() {
    for (int i = 1; i <= N; i++) {
        check[i] = false;
    }
    int result = num[1];
    int f;

    for (int i = 0; i < num[1]; i++) {
        check[relation[1][i]] = true;
    }
    for (int i = 0; i < num[1]; i++) {
        f = relation[1][i];
        for (int j = 0; j < num[f]; j++) {
            int f_of_f = relation[f][j];
            if (!check[f_of_f]&&f_of_f!=1) {
                result++;
                check[f_of_f] = true;
            }
        }
    }
    cout << result << endl;
}
int main() {
    ios::sync_with_stdio(false), cin.tie(0);
    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {

        cout << "#" << i + 1 << " ";
        cin >> N >> M;
        for (int j = 1; j <= N; j++) {
            num[j] = 0;
        }
        int a, b;
        for (int j = 0; j < M; j++) {
            cin >> a >> b;
            relation[a][num[a]++] = b;
            relation[b][num[b]++] = a;
        }
        func();
    }
}