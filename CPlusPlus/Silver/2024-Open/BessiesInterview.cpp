/**
 *  USACO 2024 Open - Silver - Problem 1 - Bessie's Interview
 */

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main()
{
    int N, K;
    cin >> N >> K;

    vector<ll> t(N);
    for (int i = 0; i < N; i++)
    {
        cin >> t[i];
    }

    priority_queue<ll, vector<ll>, greater<ll>> pq;

    for (int i = 0; i < K; i++)
    {
        pq.push(t[i]);
    }

    map<ll, vector<ll>> mp;

    for (int i = K; i < N; i++)
    {
        ll start_time = pq.top();
        pq.pop();

        ll end_time = start_time + t[i];
        mp[end_time].push_back(start_time);
        pq.push(end_time);
    }

    ll bessie_time = pq.top();

    set<ll> reachable;
    queue<ll> q;

    reachable.insert(bessie_time);
    q.push(bessie_time);

    while (!q.empty()) 
    {
        ll curr = q.front();
        q.pop();

        vector<ll> v = mp[curr];
        for (ll prev_time : v)
        {
            if (!reachable.count(prev_time)) {
                reachable.insert(prev_time);
                q.push(prev_time);
            }
        }
    }

    string result(K, '0');
    for (int i = 0; i < K; i++)
    {
        if (reachable.count(t[i])) {
            result[i] = '1';
        }
    }

    cout << bessie_time << endl;
    cout << result << endl;

    return 0;
}