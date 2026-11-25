#
#  USACO 2020 December - Bronze - Problem 2 - Daisy Chains
#

N = int(input())

pedals = list(map(int, input().split()))

count = 0

for i in range(N):
	curr_sum = 0
	seen = set()
	for j in range(i, N):
		curr_sum += pedals[j]
		seen.add(pedals[j])
		
		length = j - i + 1
		if curr_sum % length == 0 and (curr_sum // length) in seen:
			count += 1

print(count)