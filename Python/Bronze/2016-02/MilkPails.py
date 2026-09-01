#
#  USACO 2016 February - Bronze - Problem 1 - Milk Pails
#
import sys

sys.stdin = open('pails.in', 'r')
sys.stdout = open('pails.out', 'w')

X, Y, M = map(int, input().split())

max_milk = 0

for i in range((M // X) + 1):
	for j in range((M // Y) + 1):
		total = (i * X) + (j * Y)
		if total <= M:
			if total > max_milk:
				max_milk = total

print(max_milk)