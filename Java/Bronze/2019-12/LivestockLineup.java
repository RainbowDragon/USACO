/**
 *  USACO 2019 December - Bronze - Problem 3 - Livestock Lineup
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class LivestockLineup {

    static class Constraint {
        String cowA, cowB;
        Constraint(String cowA, String cowB) {
            this.cowA = cowA;
            this.cowB = cowB;
        }
    }

    static boolean done = false;

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("lineup.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));

        int N = Integer.parseInt(in.readLine());
        
        Constraint[] constraints = new Constraint[N];
        for (int i = 0; i < N; i++)
        {
            String[] tokens = in.readLine().split(" ");
            constraints[i] = new Constraint(tokens[0], tokens[5]);
        }

        String[] cows = {
            "Beatrice", "Belinda", "Bella", "Bessie", 
            "Betsy", "Blue", "Buttercup", "Sue"
        };

        List<String> current = new ArrayList<>();
        boolean[] used = new boolean[8];

        backTrack(current, used, cows, constraints, out);

        in.close();
        out.close();
    }

    private static void backTrack(List<String> current, boolean[] used, String[] cows, Constraint[] constraints, PrintWriter out) {

        if (done) {
            return;
        }

        if (current.size() == 8) {

            HashMap<String, Integer> pos = new HashMap<>();
            for (int i = 0; i < 8; i++)
            {
                pos.put(current.get(i), i);
            }

            boolean valid = true;
            for (Constraint constraint : constraints)
            {
                if (Math.abs(pos.get(constraint.cowA) - pos.get(constraint.cowB)) != 1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                for (String cow : current)
                {
                    out.println(cow);
                }
                done = true;
            }

            return;
        }

        for (int i = 0; i < 8; i++)
        {
            if (!used[i]) {
                used[i] = true;
                current.add(cows[i]);

                backTrack(current, used, cows, constraints, out);

                current.remove(current.size()-1);
                used[i] = false;
            }  
        }
    }
}