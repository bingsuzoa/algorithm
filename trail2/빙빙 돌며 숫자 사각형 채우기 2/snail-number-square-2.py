n, m = map(int, input().split())

dx = [1,-1,0,0]
dy = [0,0,1,-1]

dirMap = {0 : 2, 2 : 1, 1 : 3, 3 : 0}

graph = [[0] * m for _ in range(n)]

cnt = 1
x = -1
y = 0
dir = 0
for _ in range(n * m) :
    nx = x + dx[dir]
    ny = y + dy[dir]

    if nx < 0 or nx >= n or ny < 0 or ny >= m or graph[nx][ny] != 0 :
        dir = dirMap[dir]
        nx = x + dx[dir]
        ny = y + dy[dir]
    

    graph[nx][ny] = cnt
    x = nx
    y = ny
    cnt += 1


for i in range(n) :
    for j in range(m) :
        print(graph[i][j], end=" ")
    print()