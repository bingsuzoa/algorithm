N = int(input())

graph = [[''] * (N) for _ in range(N)]

for i in range(N) :
    mir = input()
    for j, ch in enumerate(mir) :
        graph[i][j] = ch

k = int(input())

if 1 <= k <= N :
    x = 0
    y = k - 1
    start = 0
elif N < k <= 2 * N :
    x = k - N - 1
    y = N - 1
    start = 3
elif 2 * N < k <= 3 * N :
    x = N - 1
    y = 3 * N - k
    start = 1
else :
    x = 4 * N - k
    y = 0
    start = 2


#아래, 위, 우, 좌
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]



def changeDir(dir) :
    if dir == 0 :
        return 1
    if dir == 1 :
        return 0
    if dir == 2 :
        return 3
    if dir == 3 :
        return 2

def change(dir, x, y) :
    dir = changeDir(dir)
    if graph[x][y] == "\\" :
        if dir == 1 :
            return 2
        if dir == 0 :
            return 3
        if dir == 2 :
            return 1
        if dir == 3 :
            return 0
    if graph[x][y] == "/" :
        if dir == 1 :
            return 3
        if dir == 0 :
            return 2
        if dir == 2 :
            return 0
        if dir == 3 :
            return 1

cnt = 0
while True :
    if x < 0 or x >= N or y < 0 or y >= N :
        break

    start = change(start, x, y)
    nx = x + dx[start]
    ny = y + dy[start]

    cnt += 1
    x = nx
    y = ny


print(cnt)
# Please write your code here.