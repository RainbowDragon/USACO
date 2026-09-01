#
#  USACO 2016 Open - Bronze - Problem 1 - Diamond Collector
#
import sys

sys.stdin = open('diamond.in', 'r')
sys.stdout = open('diamond.out', 'w')

N, K = map(int, input().split())

diamonds = sorted(int(input()) for _ in range(N))

max_num = 0

left = 0
for right in range(N):
	while diamonds[right] - diamonds[left] > K:
		left += 1
	
	max_num = max(max_num, right - left + 1)

print(max_num)