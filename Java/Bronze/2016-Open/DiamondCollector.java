/**
 *  USACO 2016 Open - Bronze - Problem 1 - Diamond Collector
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class DiamondCollector {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("diamond.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] diamonds = new int[N];

        for (int i = 0; i < N; i++)
        {
            diamonds[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(diamonds);

        int maxNum = 0;
        int left = 0;

        for (int right = 0; right < N; right++)
        {
            while (diamonds[right] - diamonds[left] > K)
            {
                left++;
            }
            maxNum = Math.max(maxNum, right - left + 1);
        }

        out.println(maxNum);

        in.close();
        out.close();
    }
}