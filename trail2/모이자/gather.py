

n = int(input())

graph = list(map(int, input().split()))

ans = 100001

for i in range(len(graph)) :
    count = 0
    for j in range(len(graph)) :
        count += abs(j-i) * graph[j]
    ans = min(ans, count)

print(ans)