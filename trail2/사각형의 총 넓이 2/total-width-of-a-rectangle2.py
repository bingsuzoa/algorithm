n = int(input())
commands = [tuple(map(int, input().split())) for _ in range(n)]


checked = [[0] * 201 for _ in range(201)]

for e in commands :
    x1 = e[0] + 100
    y1 = e[1] + 100
    x2 = e[2] + 100
    y2 = e[3] + 100
    for x in range(x1, x2) :
        for y in range(y1, y2) :
            checked[x][y] = 1

rect = 0
for i in range(len(checked)) :
    for j in range(len(checked[0])) :
        if checked[i][j] == 1 :
            rect += 1


print(rect)