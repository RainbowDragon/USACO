#
#  USACO 2023 January - Bronze - Problem 2 - Air Cownditioning II
#

N, M = map(int, input().split())

cows = []
for _ in range(N):
	s, t, c = map(int, input().split())
	cows.append((s, t, c))

acs = []
for _ in range(M):
	a, b, p, m = map(int, input().split())
	acs.append((a, b, p, m))

min_cost = float('inf')

for mask in range(1 << M):
	cur_cost = 0
	stall_cooling = [0] * 101

	for i in range(M):
		if (mask >> i) & 1:
			a, b, p, m = acs[i]
			cur_cost += m
			for stall in range(a, b+1):
				stall_cooling[stall] += p
	
	valid = True
	for s, t, c in cows:
		for stall in range(s, t+1):
			if stall_cooling[stall] < c:
				valid = False
				break
		if not valid:
			break
	
	if valid:
		min_cost =  min(min_cost, cur_cost)

print(min_cost)