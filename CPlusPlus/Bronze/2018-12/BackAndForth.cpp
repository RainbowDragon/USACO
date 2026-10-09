/**
 *  USACO 2018 December - Bronze - Problem 3 - Back and Forth
 */

#include <bits/stdc++.h>

using namespace std;

unordered_set<int> possible_readings;

void simulate(int day, int milk, vector<int> b1, vector<int> b2)
{
    if (day == 5) {
        possible_readings.insert(milk);
        return;
    }

    if (day == 1 || day == 3) {
        for (int i = 0; i < b1.size(); i++)
        {
            int bucket = b1[i];
            vector<int> new_b1 = b1;
            new_b1.erase(new_b1.begin() + i);
            vector<int> new_b2 = b2;
            new_b2.push_back(bucket);
            simulate(day+1, milk-bucket, new_b1, new_b2);
        }
    }
    else {
        for (int i = 0; i < b2.size(); i++)
        {
            int bucket = b2[i];
            vector<int> new_b1 = b1;
            new_b1.push_back(bucket);
            vector<int> new_b2 = b2;
            new_b2.erase(new_b2.begin() + i);
            simulate(day+1, milk+bucket, new_b1, new_b2);
        }
    }
}

int main()
{
    freopen("backforth.in", "r", stdin);
    freopen("backforth.out", "w", stdout);

    vector<int> barn1(10);
    vector<int> barn2(10);

    for (int i = 0; i < 10; i++)
    {
        cin >> barn1[i];
    }

    for (int i = 0; i < 10; i++)
    {
        cin >> barn2[i];
    }

    simulate(1, 1000, barn1, barn2);

    cout << possible_readings.size() << endl;

    return 0;
}