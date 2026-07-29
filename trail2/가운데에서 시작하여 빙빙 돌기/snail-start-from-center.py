n = int(input())

x = n//2
y = n//2
dir = 0
cnt = 1
move_num = 1

dx = [0,-1,0,1]
dy = [1,0,-1,0]

graph = [[0] * n for _ in range(n)]

while True :
    
    for _ in range(move_num) :
        graph[x][y] = cnt
        x += dx[dir]
        y += dy[dir]
        cnt += 1
        if x < 0 or x >= n or y < 0 or y >= n : break

    dir = (dir + 1) % 4
    if dir == 0 or dir == 2 :
        move_num += 1
    if x < 0 or x >= n or y < 0 or y >= n : break


for i in range(n) :
    for j in range(n) :
        print(graph[i][j], end= " ")
    print()