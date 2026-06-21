n, m = map(int, input().split())

commanda = [tuple(input().split()) for _ in range(n)]
commandb = [tuple(input().split()) for _ in range(m)]

res1 = [0] * 1000001
res2 = [0] * 1000001

a_t = 1
for i in range(len(commanda)) :
    d = commanda[i][0]
    t = int(commanda[i][1])

    for _ in range(t) :
        res1[a_t] = res1[a_t - 1] + (1 if d == 'R' else -1)
        a_t += 1

b_t = 1
for i in range(len(commandb)) :
    d = commandb[i][0]
    t = int(commandb[i][1])

    for _ in range(t) :
        res2[b_t] = res2[b_t - 1] + (1 if d == 'R' else -1)
        b_t += 1

ans = -1
for i in range(1, a_t) :
    if res1[i] == res2[i] :
        ans = i
        break

print(ans)