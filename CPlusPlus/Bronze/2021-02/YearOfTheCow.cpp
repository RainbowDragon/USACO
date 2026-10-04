/**
 *  USACO 2021 February - Bronze - Problem 1 - Year of the Cow
 */

#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    cin >> N;

    string zodiacs[] = {
        "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse",
        "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"
    };    

    unordered_map<string, int> zodiac_to_idx;
    for (int i = 0; i < 12; i++)
    {
        zodiac_to_idx[zodiacs[i]] = i;
    }

    unordered_map<string, int> birth_year;
    birth_year["Bessie"] = 0;
    unordered_map<string, int> cow_zodiac;
    cow_zodiac["Bessie"] = zodiac_to_idx["Ox"];

    for (int i = 0; i < N; i++)
    {
        string cow_a, born, in, direction, animal_a, year, of, cow_b;
        cin >> cow_a >> born >> in >> direction >> animal_a >> year >> of >> cow_b;

        int idx_a = zodiac_to_idx[animal_a];
        int idx_b = cow_zodiac[cow_b];
        int year_b = birth_year[cow_b];

        int year_a;
        if (direction == "previous") {
            int delta = (idx_b - idx_a) % 12;
            if (delta <= 0) {
                delta += 12;
            }
            year_a = year_b - delta;
        } 
        else { 
            int delta = (idx_a - idx_b) % 12;
            if (delta <= 0) {
                delta += 12;
            }
            year_a = year_b + delta;
        }

        birth_year[cow_a] = year_a;
        cow_zodiac[cow_a] = idx_a;
    }

    cout << abs(birth_year["Elsie"]) << endl;

    return 0;
}