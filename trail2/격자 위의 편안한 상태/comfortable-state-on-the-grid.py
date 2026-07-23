#시간복잡도
#10000칸
#최대 10000칸에 대해 위,아래,좌,우를 다 살펴야함 10000 * 4 -> 구현 가능
n, m = map(int, input().split())
dx = [1,-1,0,0]
dy = [0,0,1,-1]

graph = [[0] * n for _ in range(n)]

def check(x, y) :
    count = 0
    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= n or ny < 0 or ny >= n : continue
        if graph[nx][ny] >= 1 : count += 1

    if count == 3 : print(1)
    else : print(0)

for _ in range(m) :
    x, y = map(int, input().split())
    x -=1
    y -=1

    graph[x][y] += 1
    check(x, y)
