/**
 *  USACO 2020 December - Bronze - Problem 2 - Daisy Chains
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class DaisyChains {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] petals = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
        {
            petals[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 0; i < N; i++)
        {
            int curSum = 0;
            HashSet<Integer> seen = new HashSet<>();

            for (int j = i; j < N; j++)
            {
                curSum += petals[j];
                seen.add(petals[j]);

                int length = j - i + 1;
                if (curSum % length == 0 && seen.contains(curSum / length)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}