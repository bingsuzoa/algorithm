n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]

def overCheck(x, y) :
    if x < 0 or x >= n or y < 0 or y >= n :
        return True
    return False


def maxCheck(x, y) :
    maxCount = 0
    #같은 행
    for ny in range(y+1, n) :
        if n - ny >= 3 :
            x1 = x
            y1 = ny

            x2 = x
            y2 = ny + 1

            x3 = x
            y3 = ny + 2

            cnt = arr[x1][y1] + arr[x2][y2] + arr[x3][y3]
            maxCount = max(maxCount, cnt)

    #다른행
    for nx in range(x+1, n) :
        for ny in range(n) :
            if n - ny >= 3 :
                x1 = nx
                y1 = ny

                x2 = nx
                y2 = ny + 1

                x3 = nx
                y3 = ny + 2
                cnt = arr[x1][y1] + arr[x2][y2] + arr[x3][y3]
                maxCount = max(maxCount, cnt)
    return maxCount


ans = 0
for x in range(len(arr)) :
    for y in range(len(arr)) :
        x2 = x
        y2 = y + 1

        x3 = x 
        y3 = y + 2
        if overCheck(x2, y2) or overCheck(x3, y3) :
            continue
        
        cnt = arr[x][y] + arr[x2][y2] + arr[x3][y3]
        res = maxCheck(x3,y3)
        cnt += maxCheck(x3, y3)
        ans = max(ans, cnt)


print(ans)
