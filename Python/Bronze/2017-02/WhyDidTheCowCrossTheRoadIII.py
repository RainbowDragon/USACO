#
#  USACO 2017 February - Bronze - Problem 3 - Why Did the Cow Cross the Road III
#
import sys

sys.stdin = open('cowqueue.in', 'r')
sys.stdout = open('cowqueue.out', 'w')

N = int(input())
cows = []

for _ in range(N):
	arr, dur = map(int, input().split())
	cows.append((arr, dur))

cows.sort()

cur_time = 0
for arr, dur in cows:
	if cur_time < arr:
		cur_time = arr
	
	cur_time += dur

print(cur_time)