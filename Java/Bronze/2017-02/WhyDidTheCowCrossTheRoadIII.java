/**
 *  USACO 2017 February - Bronze - Problem 3 - Why Did the Cow Cross the Road III
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoadIII {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("cowqueue.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

        int N = Integer.parseInt(in.readLine());

        int[][] cows = new int[N][2];

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(in.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        int curTime = 0;

        for (int i = 0; i < N; i++)
        {
            curTime = Math.max(curTime, cows[i][0]) + cows[i][1];
        }

        out.println(curTime);

        in.close();
        out.close();
    }
}