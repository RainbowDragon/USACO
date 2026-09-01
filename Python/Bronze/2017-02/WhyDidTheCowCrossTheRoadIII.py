#
#  USACO 2017 February - Bronze - Problem 3 - Why Did the Cow Cross the Road III
#
import sys

sys.stdin = open('cowqueue.in', 'r')
sys.stdout = open('cowqueue.out', 'w')

N = int(input())

cows = sorted(tuple(map(int, input().split())) for _ in range(N))

cur_time = 0
for arr, dur in cows:
	cur_time = max(cur_time, arr) + dur

print(cur_time)