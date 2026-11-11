/**
 *  USACO 2016 December - Silver - Problem 3 - Moocast
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class Moocast {

    static class Cow {
        long x, y, p;

        Cow (long x, long y, long p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }

    static boolean canReach (Cow a, Cow b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        long distSq = dx * dx + dy * dy;
        long powerSq = a.p * a.p;
        return distSq <= powerSq;
    }

    static int dfs (int node, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : graph[node]) 
        {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }
        return count;
    }

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("moocast.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

        int N = Integer.parseInt(in.readLine());

        Cow[] cows = new Cow[N];

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            cows[i] = new Cow(x, y, p);
        }

        ArrayList<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) 
            {
                if (i != j && canReach(cows[i], cows[j])) {
                    graph[i].add(j);
                }
            }

        int maxReached = 0;

        for (int start = 0; start < N; start++)
        {
            boolean[] visited = new boolean[N];
            int reached = dfs(start, graph, visited);
            maxReached = Math.max(maxReached, reached);
        }

        out.println(maxReached);

        in.close();
        out.close();
    }
}