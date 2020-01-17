#include<iostream>
#include<vector>
using namespace std;


int V, E, obj1, obj2;
int p[10001] = { 0, };
vector<int> v[10001];
bool visited[10001] = { false, };
int q[10000];
int bfs(int start) {
    int result = 0;
    int f = -1;
    int r = -1;
    q[++r] = start;
    while (f != r) {
        int here = q[++f];
        result++;
        for (int i = 0; i < v[here].size(); i++) {
            q[++r] = v[here][i];
        }
    }
    return result;
}
void func() {
    int now = obj1;
    visited[now] = true;
    while (true) {
        now = p[now];
        visited[now] = true;
        if (now == 1) break;
    }

    now = obj2;
    while (true) {
        if (visited[now]) {
            cout << now << " " << bfs(now) << endl;
            return;
        }
        now = p[now];
    }
}
int main() {
    ios::sync_with_stdio(false), cin.tie(0);
    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {

        cout << "#" << i + 1 << " ";
        cin >> V >> E>>obj1>>obj2;

        for (int j = 1; j <= V; j++) {
            p[j] = 0;
            v[j].clear();
            visited[j] = false;
        }
        int parent, child;
        for (int j = 0; j < E; j++) {
            cin >> parent >> child;
            p[child] = parent;
            v[parent].push_back(child);
        }
        func();
    }
}