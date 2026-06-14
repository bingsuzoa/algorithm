n = int(input())
commands = [tuple(map(int, input().split())) for _ in range(n)]

commands.sort()

arr = [0] * 201

for s, e in commands :
    s = s + 100
    e = e + 100
    for i in range(s, e) :
        arr[i] += 1

ans = 0
for e in arr :
    ans = max(ans, e)

print(ans)