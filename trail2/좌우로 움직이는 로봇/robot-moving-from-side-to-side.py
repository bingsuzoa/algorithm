n, m = map(int, input().split())

coma = [tuple(input().split()) for _ in range(n)]
comb = [tuple(input().split()) for _ in range(m)]

pos_a = [0] * 2000001
pos_b = [0] * 2000001

a_t = 1
for e in coma :
    t = int(e[0])
    dir = e[1]

    for _ in range(t) :
        pos_a[a_t] = pos_a[a_t - 1] + (1 if dir == 'R' else -1)
        a_t += 1

b_t = 1
for e in comb :
    t = int(e[0])
    dir = e[1]

    for _ in range(t) :
        pos_b[b_t] = pos_b[b_t - 1] + (1 if dir == 'R' else -1)
        b_t += 1


if a_t < b_t :
    for t in range(a_t, b_t) :
        pos_a[t] = pos_a[t-1]
elif a_t > b_t :
    for t in range(b_t, a_t) :
        pos_b[t] = pos_b[t-1]

cnt = 0
max_t = max(a_t, b_t)

for t in range(1, max_t) :
    if pos_a[t] == pos_b[t] and pos_a[t-1] != pos_b[t-1] :
        cnt += 1

print(cnt)