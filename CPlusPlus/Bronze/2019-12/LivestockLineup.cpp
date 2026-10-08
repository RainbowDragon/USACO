/**
 *  USACO 2019 December - Bronze - Problem 3 - Livestock Lineup
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("lineup.in", "r", stdin);
    freopen("lineup.out", "w", stdout);

    int N;
    cin >> N;

    vector<pair<string, string>> constraints(N);
    for (int i = 0; i < N; i++)
    {
        string cow_a, must, be, milked, beside, cow_b;
        cin >> cow_a >> must >> be >> milked >> beside >> cow_b;
        constraints[i] = {cow_a, cow_b};
    }

    vector<string> cows = {
        "Beatrice", "Belinda", "Bella", "Bessie", 
        "Betsy", "Blue", "Buttercup", "Sue"
    };

    do {
        unordered_map<string, int> pos;
        for (int i = 0; i < 8; i++)
        {
            pos[cows[i]] = i;
        }

        bool valid = true;
        for (const auto& constraint : constraints)
        {
            if (abs(pos[constraint.first] - pos[constraint.second]) != 1) {
                valid = false;
                break;
            }
        }

        if (valid) {
            for (int i = 0; i < 8; i++)
            {
                cout << cows[i] << endl;
            }
            break;
        }
    } while (next_permutation(cows.begin(), cows.end()));

    return 0;
}