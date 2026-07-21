n, m = map(int, input().split())

graph = [[0] * (m) for _ in range(n)]

#아래, 위, 우, 좌
dx = [1,-1,0,0]
dy = [0,0,1,-1]
dirMap = {2 : 0, 0 : 3, 3 : 1, 1 : 2}

x = 0
y = -1
cnt = 1
idx = 2

for _ in range(n * m) :
    nx = x + dx[idx]
    ny = y + dy[idx]

    if nx < 0 or nx >= n or ny < 0 or ny >= m or graph[nx][ny] != 0 : 
        idx = dirMap[idx]
        nx = x + dx[idx]
        ny = y + dy[idx]

    graph[nx][ny] = cnt
    cnt += 1
    x = nx
    y = ny

for x in range(n) :
    for y in range(m) :
        print(graph[x][y], end=" ")
    print()