/**
 *  USACO 2019 January - Silver - Problem 2 - Icy Perimeter
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("perimeter.in", "r", stdin);
    freopen("perimeter.out", "w", stdout);

    int N;
    cin >> N;

    vector<string> grid(N);

    for (int i = 0; i < N; i++) 
    {
        cin >> grid[i];
    }

    vector<vector<bool>> visited(N, vector<bool>(N, false));

    int best_area = 0;
    int best_perimeter = INT_MAX;

    const int dr[4] = {-1, 1, 0, 0};
    const int dc[4] = {0, 0, -1, 1};

    for (int r = 0; r < N; r++)
        for (int c = 0; c < N; c++)
        {
            if (grid[r][c] == '#' && !visited[r][c]) {
                stack<pair<int, int>> s;
                s.push({r, c});
                visited[r][c] = true;

                int curr_area = 0;
                int curr_perimeter = 0;

                while (!s.empty())
                {
                    auto [cr, cc] = s.top();
                    s.pop();
                    curr_area++;

                    for (int i = 0; i < 4; i++)
                    {
                        int nr = cr + dr[i];
                        int nc = cc + dc[i];

                        if (nr < 0 || nr >= N or nc < 0 or nc >= N || grid[nr][nc] == '.') {
                            curr_perimeter++;
                        }
                        else if (!visited[nr][nc]) {
                            visited[nr][nc] = true;
                            s.push({nr, nc});
                        }

                    }
                }

                if (curr_area > best_area) {
                    best_area = curr_area;
                    best_perimeter = curr_perimeter;
                }
                else if (curr_area == best_area && curr_perimeter < best_perimeter) {
                    best_perimeter = curr_perimeter;
                }
            }
        }

    cout << best_area << " " << best_perimeter << endl;

    return 0;
}