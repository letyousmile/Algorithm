#include <string>
#include <vector>
using namespace std;

vector<vector<int>> ans;
void hanoi(int from, int mid, int to, int num) {
    if (num == 1) {
        vector<int> v;
        v.push_back(from);
        v.push_back(to);
        ans.push_back(v);
    }
    else {
        hanoi(from, to, mid, num - 1);
        hanoi(from, mid, to, 1);
        hanoi(mid, from, to, num - 1);
    }
}
vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    hanoi(1, 2, 3, n);
    answer = ans;
    return answer;
}