#
#  USACO 2019 January - Silver - Problem 2 - Icy Perimeter
#
import sys

sys.stdin = open('perimeter.in', 'r')
sys.stdout = open('perimeter.out', 'w')

N = int(input())
grid = []
for _ in range(N):
	grid.append(input())

visited = [[False] * N for _ in range(N)]

best_area = 0
best_perimeter = float('inf')

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

for r in range(N):
	for c in range(N):
		if grid[r][c] == '#' and not visited[r][c]:
			stack = [(r, c)]

			visited[r][c] = True

			curr_area = 0
			curr_perimeter = 0

			while stack:
				cr, cc = stack.pop()
				curr_area += 1

				for i in range(4):
					nr = cr + dr[i]
					nc = cc + dc[i]

					if nr < 0 or nr >= N or nc < 0 or nc >= N or grid[nr][nc] == '.':
						curr_perimeter += 1
					else:
						if not visited[nr][nc]:
							visited[nr][nc] = True
							stack.append((nr, nc))

			if curr_area > best_area:
				best_area = curr_area
				best_perimeter = curr_perimeter
			elif curr_area == best_area and curr_perimeter < best_perimeter:
				best_perimeter = curr_perimeter

print(best_area, best_perimeter)