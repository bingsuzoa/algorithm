n = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]

ans = 0
for x in range(len(graph)) :
    for y in range(len(graph)) :
        cnt = 0
        y2 = y + 1
        y3 = y + 2

        if y2 >= n or y3 >= n : continue
        cnt += graph[x][y]
        cnt += graph[x][y2]
        cnt += graph[x][y3]
        ans = max(ans, cnt)

print(ans)
