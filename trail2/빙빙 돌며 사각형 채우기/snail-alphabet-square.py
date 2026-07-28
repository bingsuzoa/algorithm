n, m = map(int, input().split())

graph = [[''] * m for _ in range(n)]

alpa = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']

x = 0
y = -1
dir = 2
cnt = 0

dx = [1,-1,0,0]
dy = [0,0,1,-1]

dirMap = {2 : 0 , 0 : 3, 3 : 1, 1:2}

for _ in range(n * m) :
    nx = x + dx[dir]
    ny = y + dy[dir]

    while nx < 0 or nx >= n or ny < 0 or ny >= m or graph[nx][ny] != '' :
        dir = dirMap[dir]
        nx = x + dx[dir]
        ny = y + dy[dir]
    
    graph[nx][ny] = alpa[cnt]
    cnt += 1
    cnt = cnt % 26
    x = nx
    y = ny


for i in range(n) :
    for j in range(m) :
        print(graph[i][j], end=" ")
    print()