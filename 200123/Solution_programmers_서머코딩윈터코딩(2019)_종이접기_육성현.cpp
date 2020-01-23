#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include<math.h>
void func(int* answer, int l, int h) {
    if (h <= l) return;
    int m = (l + h) / 2;
    answer[(l + m - 1) / 2] = 0;
    answer[(m + 1 + h) / 2] = 1;
    func(answer, l, m - 1);
    func(answer, m + 1, h);
}
int* solution(int n) {
    int N = pow(2, n) - 1;
    printf("%d\n", N);
    int* answer = (int*)malloc(sizeof(int) * N);
    answer[N / 2] = 0;
    func(answer, 0, N - 1);
    return answer;
}