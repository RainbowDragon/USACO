/**
 *  USACO 2022 December - Bronze - Problem 1 - Cow College
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class CowCollege {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] cows = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
        {
            cows[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(cows);

        long maxRev = 0;
        long bestTui = 0;

        for (int i = 0; i < N; i++)
        {
            long numCows = N - i;
            long rev = cows[i] * numCows;

            if (rev > maxRev) {
                maxRev = rev;
                bestTui = cows[i];
            }
        }

        System.out.println(maxRev + " " + bestTui);
    }
}