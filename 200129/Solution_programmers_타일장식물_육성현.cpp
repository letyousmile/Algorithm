#include <string>
#include <vector>

using namespace std;
long long cache[81];
long long solution(int N) {
    long long answer = 4;
    cache[1] = 1;   
    for (int i = 2; i < N+1; i++) {
        cache[i] = cache[i-1] + cache[i-2];
        answer += (2 * cache[i]);
    }
    return answer;
}