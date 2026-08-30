#
#  USACO 2023 December - Bronze - Problem 1 - Candy Cane Feast
#

N, M = map(int, input().split())

cows = list(map(int, input().split()))
canes = map(int, input().split())
 
for cane in canes:
	h_low = 0
	for i in range(N):
		cow = cows[i]
		if h_low < cow:
			h_next = min(cow, cane)
			cows[i] += h_next - h_low
			h_low = h_next

			if h_low == cane:
				break

for cow in cows:
	print(cow)