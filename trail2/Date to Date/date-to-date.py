m1, d1, m2, d2 = tuple(map(int, input().split()))

days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

left = 0
right = 0
for i in range(1, m1) :
    left += days[i]

for i in range(1, m2) :
    right += days[i]

left += d1
right += d2

print(right - left + 1)
