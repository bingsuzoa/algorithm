
#오른쪽, 아래쪽, 왼쪽, 위쪽
dx = [0,1,0,-1]
dy = [1,0,-1,0]

idx = 3
sec = 0
x = 0
y = 0

def findIdx(dir, curDir) :
    if dir == "L" :
        curDir = 3 if curDir - 1 < 0 else curDir - 1
    else :
        curDir = 0 if curDir + 1 >= 4 else curDir + 1
    return curDir


command = input()

arrive = False
for i in range(len(command)) :
    sec += 1
    if command[i] == "F" :
        x += dx[idx]
        y += dy[idx]
        if x == 0 and y == 0 : 
            arrive = True
            break
    else :
        idx = findIdx(command[i], idx)


if arrive :
    print(sec)
else :
    print(-1)