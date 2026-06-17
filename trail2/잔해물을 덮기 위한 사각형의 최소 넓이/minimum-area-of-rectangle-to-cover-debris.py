x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

graph = [[0] * 2001 for _ in range(2001)]


x1 += 1000
y1 += 1000
x2 += 1000
y2 += 1000
x3 += 1000
y3 += 1000
x4 += 1000
y4 += 1000

def fill(x1, y1, x2, y2) :
    for x in range(x1, x2) :
        for y in range(y1, y2) :
            graph[x][y] += 1

fill(x1, y1, x2, y2)
fill(x3, y3, x4, y4)


minX = 2001
minY = 2001
maxX = 0
maxY = 0

allChecked = True
for i in range(x1, x2) :
    for j in range(y1, y2) :
        if graph[i][j] != 2 :
            allChecked = False


checked = False
for i in range(x1, x2) :
    for j in range(y1, y2) :
        if graph[i][j] == 1 :
            minX = min(minX, i)
            maxX = max(maxX, i)
            minY = min(minY, j)
            maxY = max(maxY, j)
        elif graph[i][j] == 2 :
            checked = True

if allChecked :
    print(0)
elif not checked :
    val = abs(x2 - x1) * abs(y2 - y1)
    print(val)
else :
    val = (maxX - minX + 1) * (maxY - minY + 1)
    print(val)