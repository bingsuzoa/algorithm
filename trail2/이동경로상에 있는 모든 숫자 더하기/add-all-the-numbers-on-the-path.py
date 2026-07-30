N, T = map(int, input().split())
command = input()

graph = []

for _ in range(N) :
    graph.append(list(map(int, input().split())))


x = N // 2
y = N // 2
dir = 0

dx = [-1,0,1,0]
dy = [0,-1,0,1]
ans = graph[x][y]
for c in command :
    if c == 'L' :
        dir = (dir + 1) % 4
    elif c == 'R' :
        dir = (dir -1 ) % 4
    else :
        nx = x + dx[dir]
        ny= y + dy[dir]
        if nx < 0 or nx >= N or ny < 0 or ny >= N : continue
        x = nx
        y = ny
        ans += graph[x][y]

print(ans)


