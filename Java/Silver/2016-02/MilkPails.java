/**
 *  USACO 2016 February - Silver - Problem 3 - Milk Pails
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
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] state = new int[X + 1][Y + 1];
        for (int[] row : state) 
        {
            Arrays.fill(row, -1);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        state[0][0] = 0;
        queue.add(0);

        while (!queue.isEmpty()) 
        {
            int current = queue.poll();
            int a = current / 101;
            int b = current % 101;
            int d = state[a][b];

            if (d == K) {
                continue;
            }

            int from1to2 = Math.min(a, Y - b);
            int from2to1 = Math.min(b, X - a);

            int[][] nextStates = 
            {
                {X, b},
                {a, Y},
                {0, b},
                {a, 0},
                {a - from1to2, b + from1to2},
                {a + from2to1, b - from2to1}
            };

            for (int[] next : nextStates) 
            {
                int na = next[0];
                int nb = next[1];
                if (state[na][nb] == -1) {
                    state[na][nb] = d + 1;
                    queue.add(na*101 + nb);
                }
            }
        }

        int minDiff = M;

        for (int a = 0; a <= X; a++)
            for (int b = 0; b <= Y; b++) 
            {
                if (state[a][b] != -1 && state[a][b] <= K) {
                    minDiff = Math.min(minDiff, Math.abs((a + b) - M));
                }
            }

        out.println(minDiff);

        in.close();
        out.close();
    }
}