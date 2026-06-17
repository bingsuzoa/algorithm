x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())
x5, y5, x6, y6 = map(int, input().split())

graph = [[0] * 2001 for _ in range(2001)]

def fill(x1, y1, x2, y2, n) :
    x1 += 1000
    y1 += 1000
    x2 += 1000
    y2 += 1000
    for x in range(x1, x2) :
        for y in range(y1, y2) :
            graph[x][y] = n

fill(x1, y1, x2, y2, 1)
fill(x3, y3, x4, y4, 2)
fill(x5, y5, x6, y6, 3)

count = 0
for x in range(len(graph)) :
    for y in range(len(graph[0])) :
        if graph[x][y] == 1 or graph[x][y] == 2 :
            count += 1

print(count)