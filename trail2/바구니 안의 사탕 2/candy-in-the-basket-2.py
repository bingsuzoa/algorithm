N, K = map(int, input().split())

arr = [0] * 101

for _ in range(N) :
    n, p = map(int, input().split())
    arr[p] += n

ans = 0
for i in range(2 * K + 1) :
    if i >= len(arr) : break
    ans += arr[i]

cur = ans
for i in range(1, 100 - (2 * K) + 1) :
    if i +  (2 * K) >= len(arr) : break
    cur -= arr[i - 1]
    cur += arr[i +  (2 * K)]
    # print(f"{i}, {i + 1 +  (2 * K)}, {cur}")
    ans = max(cur, ans)
# Please write your code here.
print(ans)