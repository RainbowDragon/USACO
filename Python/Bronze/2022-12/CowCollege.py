#
#  USACO 2022 December - Bronze - Problem 1 - Cow College
#

N = int(input())

cows = sorted(map(int, input().split()))

max_rev = 0
best_tui = 0

for i in range(N):
	num_cows = N - i
	rev = cows[i] * num_cows

	if rev > max_rev:
		max_rev = rev
		best_tui = cows[i]

print(max_rev, best_tui)