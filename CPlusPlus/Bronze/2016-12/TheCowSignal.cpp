/**
 *  USACO 2016 December - Bronze - Problem 3 - The Cow-Signal
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("cowsignal.in", "r", stdin);
    freopen("cowsignal.out", "w", stdout);

    int M, N, K;
    cin >> M >> N >> K;

    for (int i = 0; i < M; i++)
    {
        string row;
        cin >> row;

        string new_row = "";
        for (char c : row) 
        {
            new_row.append(K, c);
        }

        for (int j = 0; j < K; j++)
        {
            cout << new_row << endl;
        }
    }

    return 0;
}