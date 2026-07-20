n, t = map(int, input().split())
sx, sy, dir = input().split()
sx = int(sx)
sy = int(sy)

graph = [[0] * (n+1) for _ in range(n+1)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

dirMap = {"D" : 0, "U" : 1, "R" : 2, "L" : 3}
changeMap = {0 : 1, 1 : 0, 2 : 3, 3 : 2}

idx = dirMap[dir]
for _ in range(t) :
    nx = sx + dx[idx]
    ny = sy + dy[idx]

    if nx <= 0 or nx >= n+1 or ny <= 0 or ny >= n+1 :
        idx = changeMap[idx]
    else :
        sx = nx
        sy = ny

print(sx, sy)