r, c = map(int, input().split())
graph = list(input().split() for _ in range(r))

# Please write your code here.
ans = 0
def dfs(x, y, color, cnt) :
    global ans

    if x == r-1 and y == c-1 and cnt == 3 :
        ans += 1
        return
    
    if cnt > 3 :
        return
    
    for i in range(x + 1, r) :
        for j in range(y + 1, c) :
            nx = i
            ny = j

            if nx >= r or nx < 0 or ny >= c or ny < 0 :
                continue
            if graph[nx][ny] == color : continue
            dfs(nx, ny, graph[nx][ny], cnt + 1)

dfs(0,0,graph[0][0],0)
print(ans)