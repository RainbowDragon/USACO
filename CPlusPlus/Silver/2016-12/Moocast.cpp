/**
 *  USACO 2016 December - Silver - Problem 3 - Moocast
 */

#include <bits/stdc++.h>

using namespace std;

struct Cow 
{
    long long x, y, p;
};

bool canReach(const Cow& a, const Cow& b) 
{
    long long dx = a.x - b.x;
    long long dy = a.y - b.y;
    long long dist_sq = dx * dx + dy * dy;
    long long power_sq = a.p * a.p;
    return dist_sq <= power_sq;
}

int dfs(int node, const vector<vector<int>>& graph, vector<bool>& visited) 
{
    visited[node] = true;
    int count = 1;
    for (int neighbor : graph[node]) 
    {
        if (!visited[neighbor]) {
            count += dfs(neighbor, graph, visited);
        }
    }
    return count;
}

int main()
{
    freopen("moocast.in", "r", stdin);
    freopen("moocast.out", "w", stdout);

    int N;
    cin >> N;

    vector<Cow> cows(N);

    for (int i = 0; i < N; i++) 
    {
        cin >> cows[i].x >> cows[i].y >> cows[i].p;
    }

    vector<vector<int>> graph(N);

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) 
        {
            if (i != j && canReach(cows[i], cows[j])) {
                graph[i].push_back(j);
            }
        }

    int max_reached = 0;

    for (int start = 0; start < N; start++) 
    {
        vector<bool> visited(N, false);
        int reached = dfs(start, graph, visited);
        max_reached = max(max_reached, reached);
    }

    cout << max_reached << endl;

    return 0;
}