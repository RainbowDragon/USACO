/**
 *  USACO 2023 January - Bronze - Problem 2 - Air Cownditioning II
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class AirCownditioningII {

    static class Cow {
        int s, t, c;
        Cow(int s, int t, int c) {
            this.s = s;
            this.t = t;
            this.c = c;
        }
    }

    static class AC {
        int a, b, p, m;
        AC(int a, int b, int p, int m) {
            this.a = a;
            this.b = b;
            this.p = p;
            this.m = m;
        }
    }

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(s, t, c);
        }

        AC[] acs = new AC[M];
        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            acs[i] = new AC(a, b, p, m);
        }

        int minCost = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << M); mask++)
        {
            int curCost = 0;
            int[] stallCooling = new int[101];

            for (int i = 0; i < M; i++)
            {
                if (((mask >> i) & 1) == 1) {
                    curCost += acs[i].m;
                    for (int stall = acs[i].a; stall <= acs[i].b; stall++)
                    {
                        stallCooling[stall] += acs[i].p;
                    }
                }
            }

            boolean valid = true;
            for (Cow cow : cows)
            {
                for (int stall = cow.s; stall <= cow.t; stall++)
                {
                    if (stallCooling[stall] < cow.c) {
                        valid = false;
                        break;
                    }
                }

                if (!valid) {
                    break;
                }
            }

            if (valid) {
                minCost = Math.min(minCost, curCost);
            }
        }

        System.out.println(minCost);
    }
}