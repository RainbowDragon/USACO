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

    long long max_rev = 0;
    long long best_tui = 0;

    for (int i = 0; i < N; i++)
    {
        long long num_cows = N - i;
        long long rev = cows[i] * num_cows;

        if (rev > max_rev) {
            max_rev = rev;
            best_tui = cows[i];
        }
    }

    cout << max_rev << " " << best_tui << endl;

    return 0;
}