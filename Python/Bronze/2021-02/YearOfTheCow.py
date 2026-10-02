#
#  USACO 2021 February - Bronze - Problem 1 - Year of the Cow
#

N = int(input())

zodiacs = [
	"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse",
	"Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"
]
zodiac_to_idx = { name: i for i, name in enumerate(zodiacs) }

birth_year = { "Bessie": 0 }
cow_zodiac = { "Bessie": zodiac_to_idx["Ox"] }

for _ in range(N):
	tokens = input().split()

	cow_a = tokens[0]
	direction = tokens[3]
	animal_a = tokens[4]
	cow_b = tokens[7]

	idx_a = zodiac_to_idx[animal_a]
	idx_b = cow_zodiac[cow_b]
	year_b = birth_year[cow_b]

	if direction == "previous":
		delta = (idx_b - idx_a) % 12
		if delta == 0:
			delta = 12
		year_a = year_b - delta
	else:
		delta = (idx_a - idx_b) % 12
		if delta == 0:
			delta = 12
		year_a = year_b + delta
	
	birth_year[cow_a] = year_a
	cow_zodiac[cow_a] = idx_a

print(abs(birth_year["Elsie"]))