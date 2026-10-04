/**
 *  USACO 2016 February - Bronze - Problem 1 - Milk Pails
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class MilkPails {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("pails.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int maxMilk = 0;

        for (int i = 0; i * X <= M; i++)
            for (int j = 0; i * X + j * Y <= M; j++)
            {
                maxMilk = Math.max(maxMilk, i * X + j * Y);
            }

        out.println(maxMilk);

        in.close();
        out.close();
    }
}