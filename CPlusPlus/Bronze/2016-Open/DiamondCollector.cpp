/**
 *  USACO 2016 Open - Bronze - Problem 1 - Diamond Collector
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("diamond.in", "r", stdin);
    freopen("diamond.out", "w", stdout);

    int N, K;
    cin >> N >> K;

    vector<int> diamonds(N);
    for (int i = 0; i < N; i++)
    {
        cin >> diamonds[i];
    }

    sort(diamonds.begin(), diamonds.end());

    int max_num = 0;
    int left = 0;

    for (int right = 0; right < N; right++)
    {
        while (diamonds[right] - diamonds[left] > K) 
        {
            left++;
        }
        max_num = max(max_num, right - left + 1);
    }

    cout << max_num << endl;

    return 0;
}