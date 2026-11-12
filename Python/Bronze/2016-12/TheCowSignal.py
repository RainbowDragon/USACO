#
#  USACO 2016 December - Bronze - Problem 3 - The Cow-Signal
#
import sys

sys.stdin = open('cowsignal.in', 'r')
sys.stdout = open('cowsignal.out', 'w')

M, N, K = map(int, input().split())

grid = []

for _ in range(M):
	row = input()
	new_row = "".join(char * K for char in row)

	for _ in range(K):
		print(new_row)