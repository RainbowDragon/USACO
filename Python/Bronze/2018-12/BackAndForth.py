#
#  USACO 2018 December - Bronze - Problem 3 - Back and Forth
#
import sys

sys.stdin = open('backforth.in', 'r')
sys.stdout = open('backforth.out', 'w')

barn1 = list(map(int, input().split()))
barn2 = list(map(int, input().split()))

possible_readings = set()

def simulate(day, milk, b1, b2):
	if day == 5:
		possible_readings.add(milk)
		return
	
	if day == 1 or day == 3:
		for i in range(len(b1)):
			bucket = b1[i]
			new_b1 = b1[:i] + b1[i+1:]
			new_b2 = b2 + [bucket]
			simulate(day+1, milk-bucket, new_b1, new_b2)
	
	else:
		for i in range(len(b2)):
			bucket = b2[i]
			new_b1 = b1 + [bucket]
			new_b2 = b2[:i] + b2[i+1:]
			simulate(day+1, milk+bucket, new_b1, new_b2)		

simulate(1, 1000, barn1, barn2)

print(len(possible_readings))