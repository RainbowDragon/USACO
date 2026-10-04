/**
 *  USACO 2023 December - Bronze - Problem 1 - Candy Cane Feast
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;

    vector<long long> cows(N);
    for (int i = 0; i < N; i++)
    {
        cin >> cows[i];
    }

    for (int j = 0; j < M; j++)
    {
        long long cane;
        cin >> cane;

        long long h_low = 0;
        for (int i = 0; i < N; i++)
        {
            long long cow = cows[i];
            if (h_low < cow) {
                long long h_next = min(cow, cane);
                cows[i] += h_next - h_low;
                h_low = h_next;

                if (h_low >= cane) {
                    break;
                }
            }
        }
    }

    for (int i = 0; i < N; i++)
    {
        cout << cows[i] << endl;
    }

    return 0;
}