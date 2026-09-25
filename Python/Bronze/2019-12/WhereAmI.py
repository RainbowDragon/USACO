#
#  USACO 2019 December - Bronze - Problem 2 - Where Am I?
#
import sys

sys.stdin = open('whereami.in', 'r')
sys.stdout = open('whereami.out', 'w')

N = int(input())
S = input()

for K in range(1, N+1):
	substr_set = set()
	unique = True

	for i in range(N-K+1):
		substr = S[i:i+K]
		if substr in substr_set:
			unique = False
			break
		substr_set.add(substr)
	
	if unique:
		print(K)
		break