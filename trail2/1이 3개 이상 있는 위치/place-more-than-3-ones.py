n = int(input())
command = [tuple(map(int, input().split())) for _ in range(n)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]


ans = 0
for x in range(len(command)) :
    for y in range(len(command[0])) :
        count = 0
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= len(command) or ny < 0 or ny >= len(command[0]) : continue
            if command[nx][ny] == 1 :
                count += 1
        if count >= 3 :
            ans += 1

print(ans)