/**
 *  USACO 2017 February - Bronze - Problem 3 - Why Did the Cow Cross the Road III
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoadIII {

    static class Cow implements Comparable<Cow> {
        int arrTime, duration;

        Cow(int arrTime, int duration) {
            this.arrTime = arrTime;
            this.duration = duration;
        }

        @Override
        public int compareTo(Cow other) {
            return Integer.compare(this.arrTime, other.arrTime);
        }        
    }

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("cowqueue.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

        int N = Integer.parseInt(in.readLine());

        Cow[] cows = new Cow[N];

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int arrTime = Integer.parseInt(st.nextToken());
            int duration = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(arrTime, duration);
        }

        Arrays.sort(cows);

        int curTime = 0;

        for (Cow cow : cows)
        {
            curTime = Math.max(curTime, cow.arrTime) + cow.duration;
        }

        out.println(curTime);

        in.close();
        out.close();
    }
}