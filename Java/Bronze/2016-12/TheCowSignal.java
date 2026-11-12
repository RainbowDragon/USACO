/**
 *  USACO 2016 December - Bronze - Problem 3 - The Cow-Signal
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class TheCowSignal {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("cowsignal.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++)
        {
            String row = in.readLine();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++)
            {
                char c = row.charAt(j);
                for (int k = 0; k < K; k++)
                {
                    sb.append(c);
                }
            }

            String newRow = sb.toString();

            for (int k = 0; k < K; k++)
            {
                out.println(newRow);
            }
        }

        in.close();
        out.close();
    }
}