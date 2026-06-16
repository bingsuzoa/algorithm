n = int(input())
commands = [tuple(input().split()) for _ in range(n)]
x = []
dir = []
for num, direction in commands:
    x.append(int(num))
    dir.append(direction)

# Please write your code here.

class Color :
    def __init__(self) :
        self.white = 0
        self.black = 0
        self.cur = ''

    def fill(self, color) :
        if self.cur == 'G' : return

        if color == 'W' :
            self.white += 1
            self.cur = 'W'
        elif color == 'B' :
            self.black += 1
            self.cur = 'B'
        
        if self.white >= 2 and self.black >= 2 :
                self.cur = 'G'


result = [Color() for _ in range(200001)]

cur = 1000
for i in range(n) :
    if dir[i] == 'R' :
        left = cur
        right = cur + x[i]
        cur = right - 1
        for j in range(left, right) :
            color = result[j]
            color.fill('B')
    elif dir[i] == 'L' :
        left = cur - x[i]
        right = cur
        cur = left + 1
        for j in range(right, left, -1) :
            color = result[j]
            color.fill('W')

ans = [0] * 3
for i in range(len(result)) :
    cur = result[i].cur
    if cur == 'W' :
        ans[0] += 1
    elif cur == 'B' :
        ans[1] += 1
    elif cur == 'G' :
        ans[2] += 1

for i in range(3) :
    print(ans[i], end=" ")  