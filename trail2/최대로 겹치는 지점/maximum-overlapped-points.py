n = int(input())
commands = [tuple(map(int, input().split())) for _ in range(n)]

arr = [0] * 101

for s, e in commands :
    for i in range(s, e+1) :
        arr[i] += 1

ans = 0

for e in arr :
    ans = max(ans, e)

print(ans)
