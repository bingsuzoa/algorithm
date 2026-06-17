n = int(input())

commands = [tuple(map(int, input().split())) for _ in range(n)]

graph = [[0] * 201 for _ in range(201)]

for e in commands :
    x1 = e[0] + 100
    y1 = e[1] + 100
    x2 = x1 + 8
    y2 = y1 + 8

    for x in range(x1, x2) :
        for y in range(y1, y2) :
            graph[x][y] += 1


count = 0
for x in range(len(graph)) :
    for y in range(len(graph[0])) :
        if graph[x][y] >= 1 :
            count += 1

print(count)