/**
 *  USACO 2016 February - Bronze - Problem 1 - Milk Pails
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("pails.in", "r", stdin);
    freopen("pails.out", "w", stdout);

    int X, Y, M;
    cin >> X >> Y >> M;

    int max_milk = 0;

    for (int i = 0; i * X <= M; i++)
        for (int j = 0; i * X + j * Y <= M; j++)
        {
            max_milk = max(max_milk, i * X + j * Y);
        }

    cout << max_milk << endl;

    return 0;
}