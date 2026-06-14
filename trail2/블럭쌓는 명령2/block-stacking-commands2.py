n, k = map(int, input().split())
commands = [tuple(map(int, input().split())) for _ in range(k)]

arr = [0] * n

for s, e in commands :
    for i in range(s-1, e) :
        arr[i] += 1


ans = 0
for e in arr :
    ans = max(ans, e)

print(ans)