/**
 *  USACO 2023 January - Bronze - Problem 2 - Air Cownditioning II
 */

#include <bits/stdc++.h>

using namespace std;

struct Cow {
    int s, t, c;
};

struct AC {
    int a, b, p, m;
};

int main()
{
    int N, M;
    cin >> N >> M;

    vector<Cow> cows(N);
    for (int i = 0; i < N; i++)
    {
        cin >> cows[i].s >> cows[i].t >> cows[i].c;
    }

    vector<AC> acs(M);
    for (int i = 0; i < M; i++)
    {
        cin >> acs[i].a >> acs[i].b >> acs[i].p >> acs[i].m;
    }

    int min_cost = INT_MAX;

    for (int mask = 0; mask < (1 << M); mask++)
    {
        int cur_cost = 0;
        vector<int> stall_cooling(101, 0);

        for (int i = 0; i < M; i++)
        {
            if ((mask >> i) & 1) {
                cur_cost += acs[i].m;
                for (int stall = acs[i].a; stall <= acs[i].b; stall++)
                {
                    stall_cooling[stall] += acs[i].p;
                }
            }
        }

        bool valid = true;
        for (const auto& cow : cows)
        {
            for (int stall = cow.s; stall <= cow.t; stall++)
            {
                if (stall_cooling[stall] < cow.c) {
                    valid = false;
                    break;
                }
            }
            
            if (!valid) {
                break;
            }
        }

        if (valid) {
            min_cost = min(min_cost, cur_cost);
        }
    }

    cout << min_cost << endl;

    return 0;
}