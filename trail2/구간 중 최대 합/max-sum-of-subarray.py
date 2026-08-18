n, k = map(int, input().split())

arr = list(map(int, input().split()))

ans = 0

for i in range(k) :
    ans += arr[i]

res = ans
for i in range(1, len(arr) - k + 1) :
    res -= arr[i -1]
    res += arr[i + k - 1]
    ans = max(ans, res)

print(ans)
