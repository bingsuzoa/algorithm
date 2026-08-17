n, m = map(int, input().split())

arr = [list(input()) for _ in range(n)]

dx = [0,0,1,-1,-1,1,-1,1]
dy = [1,-1,0,0,-1,1,1,-1]

def overCheck(x,y) :
    if x < 0 or x >= n or y < 0 or y >= m :
        return True
    return False

def check(x, y) :
    res = 0
    for i in range(len(dx)) :
        x1 = x + dx[i]
        y1 = y + dy[i]

        x2 = x + dx[i] * 2
        y2 = y + dy[i] * 2

        if overCheck(x1, y1) or overCheck(x2, y2) :
            continue
        
        if arr[x][y] == 'L' and arr[x1][y1] == 'E' and arr[x2][y2] == 'E' :
            res += 1
    
    return res

ans = 0
for i in range(n) :
    for j in range(m) :
        ans += check(i,j)

print(ans)