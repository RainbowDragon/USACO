/**
 *  USACO 2019 December - Bronze - Problem 2 - Where Am I?
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class WhereAmI {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("whereami.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));

        int N = Integer.parseInt(in.readLine());

        String str = in.readLine();

        for (int K = 1; K <= N; K++)
        {
            HashSet<String> substrSet = new HashSet<>();
            boolean unique = true;

            for (int i = 0; i <= N-K; i++)
            {
                String substr = str.substring(i, i+K);
                if (substrSet.contains(substr)) {
                    unique = false;
                    break;
                }
                substrSet.add(substr);
            }

            if (unique) {
                out.println(K);
                break;
            }
        }

        in.close();
        out.close();
    }
}