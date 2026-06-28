command = input()

x = 0
y = 0
dir = 2

dx = [1,-1,0,0]
dy = [0,0,1,-1]

# 우, 좌, 위, 아래
# 0 -> 2, 1 -> 3, 2 -> 1, 3 -> 0
# 0 -> 3, 1 -> 2, 2 -> 0, 3 -> 1
left = [2, 3, 1, 0]
right = [3, 2, 0, 1]
for e in command :
    if e == 'F' :
        x += dx[dir]
        y += dy[dir]
    elif e == 'L' :
        dir = left[dir]
    elif e == 'R' :
        dir = right[dir]


print(x, y)

