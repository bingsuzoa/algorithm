n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
graph = [0] * 1001
ans = 0
for i in range(len(arr)) :
    graph[arr[i]] += 1
    res = arr[i]
    cnt = 1
    for j in range(i, len(arr)) :
        graph[arr[j]] += 1
        res += arr[j]
        cnt += 1
        if res % cnt == 0 :
            average = res // cnt
            if graph[average] > 0 :
                ans += 1

        if j == i :
            graph[arr[j]] -= 1
            res -= arr[j]
            cnt -= 1
    graph = [0] * 1001

print(ans)

