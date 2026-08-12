n = int(input())

graph = input().split()

ans = 0
for i in range(len(graph)) :
    for j in range(i + 1, len(graph)) :
        if abs(j - i) == 1 : continue
        ans = max(ans, int(graph[i]) + int( graph[j]))

print(ans)