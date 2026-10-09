/**
 *  USACO 2018 December - Bronze - Problem 3 - Back and Forth
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class BackAndForth {

    static Set<Integer> possibleReadings = new HashSet<>();

    static void simulate(int day, int milk, List<Integer> b1, List<Integer> b2) {
        
        if (day == 5) {
            possibleReadings.add(milk);
            return;
        }

        if (day == 1 || day == 3) {
            for (int i = 0; i < b1.size(); i++)
            {
                int bucket = b1.get(i);

                List<Integer> newB1 = new ArrayList<>(b1);
                newB1.remove(i);

                List<Integer> newB2 = new ArrayList<>(b2);
                newB2.add(bucket);

                simulate(day+1, milk-bucket, newB1, newB2);
            }
        }
        else {
            for (int i = 0; i < b2.size(); i++)
            {
                int bucket = b2.get(i);

                List<Integer> newB1 = new ArrayList<>(b1);
                newB1.add(bucket);

                List<Integer> newB2 = new ArrayList<>(b2);
                newB2.remove(i);

                simulate(day+1, milk+bucket, newB1, newB2);
            }
        }
    }

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("backforth.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

        List<Integer> barn1 = new ArrayList<>();
        List<Integer> barn2 = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 10; i++)
        {
            barn1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 10; i++)
        {
            barn2.add(Integer.parseInt(st.nextToken()));
        }

        simulate(1, 1000, barn1, barn2);

        out.println(possibleReadings.size());

        in.close();
        out.close();
    }
}