/**
 *  USACO 2019 January - Silver - Problem 2 - Icy Perimeter
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class IcyPerimeter {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader in = new BufferedReader(new FileReader("perimeter.in"));
        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));

        int N = Integer.parseInt(in.readLine());

        char[][] grid = new char[N][N];

        for (int i = 0; i < N; i++)
        {
            grid[i] = in.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][N];

        int bestArea = 0;
        int bestPerimeter = Integer.MAX_VALUE;        

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
            {
                if (grid[r][c] == '#' && !visited[r][c]) {
                    Stack<Integer> s = new Stack<Integer>();
                    s.push(r*N + c);
                    visited[r][c] = true;

                    int curArea = 0;
                    int curPerimeter = 0;

                    while (!s.isEmpty())
                    {
                        int current = s.pop();
                        int cr = current / N;
                        int cc = current % N;
                        curArea++;

                        for (int i = 0; i < 4; i++)
                        {
                            int nr = cr + dr[i];
                            int nc = cc + dc[i];

                            if (nr < 0 || nr >= N || nc < 0 || nc >= N || grid[nr][nc] == '.') {
                                curPerimeter++;
                            }
                            else if (!visited[nr][nc]) {
                                visited[nr][nc] = true;
                                s.push(nr*N + nc);
                            }
                        }
                    }

                    if (curArea > bestArea) {
                        bestArea = curArea;
                        bestPerimeter = curPerimeter;
                    }
                    else if (curArea == bestArea && curPerimeter < bestPerimeter) {
                        bestPerimeter = curPerimeter;
                    }
                }
            }

        out.println(bestArea + " " + bestPerimeter);

        in.close();
        out.close();
    }
}