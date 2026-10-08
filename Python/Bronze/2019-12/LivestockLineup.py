#
#  USACO 2019 December - Bronze - Problem 3 - Livestock Lineup
#
import sys
import itertools

sys.stdin = open('lineup.in', 'r')
sys.stdout = open('lineup.out', 'w')

Cows = sorted([
    "Bessie", "Buttercup", "Belinda", "Beatrice", 
    "Bella", "Blue", "Betsy", "Sue"
])

N = int(input())

constraints = []
for _ in range(N):
	tokens = input().split()
	cow_a = tokens[0]
	cow_b = tokens[-1]
	constraints.append((cow_a, cow_b))

for perm in itertools.permutations(Cows):
	pos = {cow: idx for idx, cow in enumerate(perm)}

	valid = True
	for a, b in constraints:
		if abs(pos[a] - pos[b]) != 1:
			valid = False
			break
	
	if valid:
		for cow in perm:
			print(cow)
		break