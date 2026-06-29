n, t = map(int, input().split())

x, y, dir = input().split()
x = int(x)
y = int(y)

dx = [1,-1,0,0]
dy = [0,0,1,-1]


for _ in range(t) :
    if dir == 'L' :
        nx = x + dx[3]
        ny = y + dy[3]
    elif dir == 'R' :
        nx = x + dx[2]
        ny = y + dy[2]
    elif dir == 'U' :
        nx = x + dx[1]
        ny = y + dy[1]
    elif dir == 'D' :
        nx = x + dx[0]
        ny = y + dy[0]
   
    if nx <= 0 or nx > n or ny <= 0 or ny > n :
        if dir == 'L' :
            dir = 'R'
        elif dir == 'R' :
            dir = 'L'
        elif dir == 'U' :
            dir = 'D'
        elif dir == 'D' :
            dir = 'U'
    else :
        x = nx
        y = ny        

print(x, y)