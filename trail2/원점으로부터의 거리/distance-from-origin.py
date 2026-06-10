

n = int(input())
points = [(int(i), tuple(map(int, input().split()))) for i in range(n)]

# Please write your code here.
class point :
    def __init__(self, x, y, num) :
        self.x = x
        self.y = y
        self.num = num + 1
        self.dist = abs(x) + abs(y)


arr = []

for e in points :
    arr.append(point(e[1][0], e[1][1], e[0]))

arr.sort(key=lambda e: (e.dist, e.num))

for e in arr :
    print(e.num)