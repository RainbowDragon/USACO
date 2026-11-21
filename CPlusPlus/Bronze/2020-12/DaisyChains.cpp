/**
 *  USACO 2020 December - Bronze - Problem 2 - Daisy Chains
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<int> pedals(N);
    for (int i = 0; i < N; i++)
    {
        cin >> pedals[i];
    }

    int count = 0;

    for (int i = 0; i < N; i++)
    {
        int curr_sum = 0;
        unordered_set<int> seen;
        for (int j = i; j < N; j++)
        {
            curr_sum += pedals[j];
            seen.insert(pedals[j]);

            int length = j - i + 1;
            if (curr_sum % length == 0 && seen.count(curr_sum / length)) {
                count++;
            }
        }
    }

    cout << count << endl;

    return 0;
}