n = int(input())

x = 0
y = 0

dx = [1,-1,0,0]
dy = [0,0,1,-1]

dirMap = {"N" : 1, "S" : 0, "E" : 2, "W" : 3}

t = 0
stop = False
for _ in range(n) :
    dir, cnt = input().split()
    cnt = int(cnt)

    idx = dirMap[dir]
    for _ in range(cnt) :
        x += dx[idx]
        y += dy[idx]

        t += 1
        if x == 0 and y == 0 :
            stop = True
            break
    
    if stop : break

if stop : 
    print(t)
else :
    print(-1)
