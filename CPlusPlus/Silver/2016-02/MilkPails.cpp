/**
 *  USACO 2016 February - Silver - Problem 3 - Milk Pails
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("pails.in", "r", stdin);
    freopen("pails.out", "w", stdout);

    int X, Y, K, M;
    cin >> X >> Y >> K >> M;

    vector<vector<int>> state(X + 1, vector<int>(Y + 1, -1));
    queue<pair<int, int>> q;

    state[0][0] = 0;
    q.push({0, 0});

    while (!q.empty())
    {
        auto [a, b] = q.front();
        q.pop();

        int d = state[a][b];
        if (d == K) {
            continue;
        }

        pair<int, int> next_states[] = 
        {
            {X, b},
            {a, Y},
            {0, b},
            {a, 0},
            {a - min(a, Y - b), b + min(a, Y - b)},
            {a + min(b, X - a), b - min(b, X - a)}
        };

        for (const auto& [na, nb] : next_states)
        {
            if (state[na][nb] == -1) {
                state[na][nb] = d + 1;
                q.push({na, nb});
            }
        }
    }

    int min_diff = M;

    for (int a = 0; a <= X; a++)
        for (int b = 0; b <= Y; b++)
        {
            if (state[a][b] != -1 && state[a][b] <= K) {
                min_diff = min(min_diff, abs((a + b) - M));
            }
        }

    cout << min_diff << endl;

    return 0;
}