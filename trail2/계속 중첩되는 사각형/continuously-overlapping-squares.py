n = int(input())
commands = [tuple(map(int, input().split())) for _ in range(n)]


graph = [[0] * 201 for _ in range(201)]

def fill(x1, y1, x2, y2, n) :
    if n % 2 == 0 :
        for x in range(x1, x2) :
            for y in range(y1, y2) :
                graph[x][y] = 1
    else : 
        for x in range(x1, x2) :
            for y in range(y1, y2) :
                graph[x][y] = 2


for i in range(len(commands)) :
    x1 = commands[i][0] + 100
    y1 = commands[i][1] + 100
    x2 = commands[i][2] + 100
    y2 = commands[i][3] + 100
    fill(x1, y1, x2, y2, i)

count = 0
for x in range(len(graph)) :
    for y in range(len(graph[0])) :
        if graph[x][y] == 2 :
            count+= 1

print(count)
    
 