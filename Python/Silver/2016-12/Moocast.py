#
#  USACO 2016 December - Silver - Problem 3 - Moocast
#
import sys

sys.stdin = open('moocast.in', 'r')
sys.stdout = open('moocast.out', 'w')

def dfs(node, graph, visited):
	visited[node] = True
	count = 1
	for neighbor in graph[node]:
		if not visited[neighbor]:
			count += dfs(neighbor, graph, visited)
	return count

N = int(input())
cows = []
for _ in range(N):
	x, y, p = map(int, input().split())
	cows.append((x, y, p))

graph = [[] for _ in range(N)]
for i in range(N):
	x1, y1, p1 = cows[i]
	p1_sq = p1 * p1
	for j in range(N):
		if i != j:
			x2, y2, p2 = cows[j]
			if (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= p1_sq:
				graph[i].append(j)

max_reached = 0

for start in range(N):
	visited = [False] * N
	reached = dfs(start, graph, visited)
	max_reached = max(max_reached, reached)

print(max_reached)