/**
 *  USACO 2021 February - Bronze - Problem 1 - Year of the Cow
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class YearOfTheCow {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] zodiacs = {
            "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse",
            "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"
        };

        Map<String, Integer> zodiacToIdx = new HashMap<>();
        for (int i = 0; i < zodiacs.length; i++)
        {
            zodiacToIdx.put(zodiacs[i], i);
        }

        Map<String, Integer> birthYear = new HashMap<>();
        birthYear.put("Bessie", 0);
        Map<String, Integer> cowZodiac = new HashMap<>();
        cowZodiac.put("Bessie", zodiacToIdx.get("Ox"));

        for (int i = 0; i < N; i++)
        {
            String[] tokens = br.readLine().split(" ");

            String cowA = tokens[0];
            String direction = tokens[3];
            String animalA = tokens[4];
            String cowB = tokens[7];

            int idxA = zodiacToIdx.get(animalA);
            int idxB = cowZodiac.get(cowB);
            int yearB = birthYear.get(cowB);

            int yearA;
            if (direction.equals("previous")) {
                int delta = (idxB - idxA) % 12;
                if (delta <= 0) {
                    delta += 12;
                }
                yearA = yearB - delta;
            } 
            else { 
                int delta = (idxA - idxB) % 12;
                if (delta <= 0) {
                    delta += 12;
                }
                yearA = yearB + delta;
            }

            birthYear.put(cowA, yearA);
            cowZodiac.put(cowA, idxA);
        }

        System.out.println(Math.abs(birthYear.get("Elsie")));
    }
}