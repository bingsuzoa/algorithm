arr = [list(map(int, input().split())) for _ in range(19)]

dx = [1,-1,0,0,1, -1,-1,1]
dy = [0,0,1,-1,1, -1,1,-1]

def dfs(x, y) :
    dir = -1
    for i in range(8) :
        success = True
        for j in range(1, 5) :
            nx = x + dx[i] * j
            ny = y + dy[i] * j
            if nx < 0 or nx >= len(arr) or ny < 0 or ny >= len(arr) :
                success = False
                break
            if arr[nx][ny] != arr[x][y] :
                success = False
                break
        if success :
            dir = i
            return dir
    return dir

def getMid(x, y, dir) :
    if dir == 0 :
        x += 2
    if dir == 1 :
        x -= 2
    if dir == 2 :
        y += 2 
    if dir == 3 :
        y -= 2
    if dir == 4 :
        x += 2
        y += 2
    if dir == 5 :
        x -= 2
        y -= 2
    if dir == 6 :
        x -= 2
        y += 2
    if dir == 7 :
        x += 2
        y -= 2
    return (x, y)

endPlay = False
for i in range(len(arr)) :
    if endPlay : break
    for j in range(len(arr)) :
        if endPlay : break
        if arr[i][j] != 0 :
            dir = dfs(i, j)
            if dir != -1 :
                endPlay = True
                print(arr[i][j])
                nx, ny = getMid(i, j, dir)
                print(nx + 1, ny + 1)
                break

if not endPlay :
    print(0)