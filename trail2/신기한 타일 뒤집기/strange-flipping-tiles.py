n = int(input())
x = []
dir = []

for _ in range(n) :
    a, b = input().split()
    x.append(int(a))
    dir.append(b)


color = [''] * 200001

cur = 1000
for i in range(n) :
    if dir[i] == 'R' :
        left = cur
        right = cur + x[i]
        cur = right -1
        for j in range(left, right) :
            color[j] = 'B'
    elif dir[i] == 'L' :
        left = cur - x[i]
        right = cur
        cur = left + 1
        for j in range(right, left, -1) :
            color[j] = 'W'

ans = [0] * 2
for e in color :
    if e == 'W' :
        ans[0] += 1
    elif e == 'B' :
        ans[1] += 1

for e in ans :
    print(e, end=" ")