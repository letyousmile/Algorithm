#include <string>
#include <vector>
#include<iostream>
using namespace std;
typedef struct {
    int loc;
    int lev;
}G;
vector<int> v[20001];
bool visited[20001];
G q[20000];

int bfs() {
    int f = -1;
    int r = -1;
    G start;
    int lev = 0;
    int num = 0;
    start.loc = 1;
    start.lev = 0;
    visited[start.loc] = true;
    q[++r] = start;
    while (f != r) {
        G here = q[++f];
        int loc = here.loc;
        if (here.lev == lev) {
            num++;
        }
        else {
            num = 1;
            lev = here.lev;
        }
        for (int i = 0; i < v[loc].size(); i++) {
            int nextLoc = v[loc][i];
            if (!visited[nextLoc]) {
                visited[nextLoc] = true;
                G there;
                there.lev = here.lev + 1;
                there.loc = nextLoc;
                q[++r] = there;
            }
        }
    }
    return num;
}
int solution(int n, vector<vector<int>> edge) {
    for (int i = 0; i < edge.size(); i++) {
        int first = edge[i][0];
        int second = edge[i][1];
        v[first].push_back(second);
        v[second].push_back(first);
    }
    return bfs();
}