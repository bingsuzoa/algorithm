m1, d1, m2, d2 = map(int, input().split())

# Please write your code here.
days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
yoi = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"]

left = 0
right = 0
for i in range(m1) :
    left += days[i]

for i in range(m2) :
    right += days[i]

left += d1
right += d2

dist = abs(left - right)
dist %= 7

if left < right :
    print(yoi[(1 + dist) % 7])
else :
    val = 1 - dist
    print(yoi[val])

