#include <string>
#include <vector>
int cache[60000];
int solution(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (cache[n] != 0) return cache[n];
    return cache[n] = (solution(n - 1) + solution(n - 2)) % 1000000007;
}