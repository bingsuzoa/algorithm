n = int(input())
info = [tuple(input().split()) for _ in range(n)]

x = 0
y = 0

dx = [1,-1,0,0]
dy = [0,0,1,-1]

for e in info :
    dir = e[0]
    con = int(e[1])

    if dir == 'E' :
        x += dx[0] * con
        y += dy[0] * con
    elif dir == 'W' :
        x += dx[1] * con
        y += dy[1] * con
    elif dir == 'N' :
        x += dx[2] * con
        y += dy[2] * con
    else :
        x += dx[3] * con
        y += dy[3] * con

print(x, y)    