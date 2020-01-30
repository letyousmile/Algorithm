#include <string>
#include <vector>
#include<algorithm>
using namespace std;

int solution(vector<int> budgets, int M) {
    sort(budgets.begin(),budgets.end());

    int high = budgets.at(budgets.size()-1);
    int low = 0;
    int answer = 0;
    while (low <= high) {
        int mid = (low + high) / 2;
        int sum = 0;
        for (int i = 0; i < budgets.size(); i++) {
            if (mid > budgets.at(i)) {
                sum += budgets.at(i);
            }
            else {
                sum += mid;
            }
        }
        if (sum > M) {
            high = mid - 1;
        }
        else {
            answer = mid;
            low = mid + 1;
        }
    }
    return answer;
}