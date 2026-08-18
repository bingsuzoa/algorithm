n, s = map(int, input().split())

arr = list(map(int, input().split()))

maxSum = 0
for i in range(len(arr)) :
    maxSum += arr[i]

ans = 10001
for i in range(len(arr)) :
    for j in range(i+1, len(arr)) :
        cnt = maxSum
        cnt -= (arr[i] + arr[j])
        ans = min(ans, abs(s - cnt))

print(ans)
