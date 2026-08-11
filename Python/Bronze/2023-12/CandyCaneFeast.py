#
#  USACO 2023 December - Bronze - Problem 1 - Candy Cane Feast
#

N, M = map(int, input().split())

cows = list(map(int, input().split()))
haybales = map(int, input().split())
 
for h in haybales:
	if h <= cows[0]:
		cows[0] += h
	else:
		h_low = 0
		for i in range(N):
			if h_low < cows[i]:
				h_next = min(cows[i], h)
				cows[i] += h_next - h_low
				h_low = h_next

				if h_low == h:
					break


for c in cows:
	print(c)