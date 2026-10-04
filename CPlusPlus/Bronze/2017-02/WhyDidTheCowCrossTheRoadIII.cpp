/**
 *  USACO 2017 February - Bronze - Problem 3 - Why Did the Cow Cross the Road III
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("cowqueue.in", "r", stdin);
    freopen("cowqueue.out", "w", stdout);

    int N;
    cin >> N;

    vector<pair<int, int>> cows(N);
    for (int i = 0; i < N; i++)
    {
        cin >> cows[i].first >> cows[i].second;
    }

    sort(cows.begin(), cows.end());

    int cur_time = 0;

    for (int i = 0; i < N; i++)
    {
        cur_time = max(cur_time, cows[i].first) + cows[i].second;
    }

    cout << cur_time << endl;

    return 0;
}