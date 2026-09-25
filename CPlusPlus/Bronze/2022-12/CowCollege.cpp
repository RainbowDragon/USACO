/**
 *  USACO 2022 December - Bronze - Problem 1 - Cow College
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<long long> cows(N);
    for (int i = 0; i < N; i++)
    {
        cin >> cows[i];
    }

    sort(cows.begin(), cows.end());

    long long maxRev = 0;
    long long bestTui = 0;

    for (int i = 0; i < N; i++)
    {
        long long numCows = N - i;
        long long rev = cows[i] * numCows;

        if (rev > maxRev) {
            maxRev = rev;
            bestTui = cows[i];
        }
    }

    cout << maxRev << " " << bestTui << endl;

    return 0;
}