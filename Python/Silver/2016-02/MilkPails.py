#
#  USACO 2016 February - Silver - Problem 1 - Milk Pails
#
import sys
from collections import deque

sys.stdin = open('pails.in', 'r')
sys.stdout = open('pails.out', 'w')

X, Y, K, M = map(int, input().split())

queue = deque([(0, 0, 0)])
visited = set([(0, 0, 0)])

min_diff = M

while queue:
	a, b, step = queue.popleft()

	min_diff = min(min_diff, abs((a + b) - M))

	if step == K:
		continue

	next_states = [
		(X, b),
		(a, Y),
		(0, b),
		(a, 0),
		(a - min(a, Y - b), b + min(a, Y - b)),
		(a + min(b, X - a), b - min(b, X - a))
	]

	for na, nb in next_states:
		next_state = (na, nb, step + 1)
		if next_state not in visited:
			visited.add(next_state)
			queue.append(next_state)

print(min_diff)