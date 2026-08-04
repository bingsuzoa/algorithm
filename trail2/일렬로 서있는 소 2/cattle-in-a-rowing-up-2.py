n = int(input())

graph = list(map(int, input().split()))

ans = 0
for i in range(len(graph)) :
    for j in range(i+1, len(graph)) :
        for k in range(j+1, len(graph)) :
            if graph[i] <= graph[j] and graph[j] <= graph[k] :
                ans += 1

print(ans)