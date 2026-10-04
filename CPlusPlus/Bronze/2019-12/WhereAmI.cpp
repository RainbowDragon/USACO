/**
 *  USACO 2019 December - Bronze - Problem 2 - Where Am I?
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("whereami.in", "r", stdin);
    freopen("whereami.out", "w", stdout);

    int N;
    cin >> N;

    string str;
    cin >> str;

    for (int K = 1; K <= N; K++)
    {
        unordered_set<string> substr_set;
        bool unique = true;

        for (int i = 0; i <= N-K; i++)
        {
            string substr = str.substr(i, K);
            if (substr_set.count(substr)) {
                unique = false;
                break;
            }
            substr_set.insert(substr);
        }

        if (unique) {
            cout << K << endl;
            break;
        }
    }

    return 0;
}