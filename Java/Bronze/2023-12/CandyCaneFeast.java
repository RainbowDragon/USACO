/**
 *  USACO 2023 December - Bronze - Problem 1 - Candy Cane Feast
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class CandyCaneFeast {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] cows = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
        {
            cows[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++)
        {
            long cane = Long.parseLong(st.nextToken());
            long hLow = 0;

            for (int i = 0; i < N; i++)
            {
                long cow = cows[i];
                if (hLow < cow) {
                    long hNext = Math.min(cow, cane);
                    cows[i] += hNext - hLow;
                    hLow = hNext;

                    if (hLow >= cane) {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++)
        {
            System.out.println(cows[i]);
        }
    }
}