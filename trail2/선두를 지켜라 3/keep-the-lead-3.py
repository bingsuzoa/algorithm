n, m = map(int, input().split())

a_info = [tuple(map(int, input().split())) for _ in range(n)]
b_info = [tuple(map(int, input().split())) for _ in range(m)]

a_dist = [0] * 1000001
b_dist = [0] * 1000001

a_pos = 1
for e in a_info :
    v = e[0]
    t = e[1]
    for _ in range(t) :
        a_dist[a_pos] = a_dist[a_pos - 1] + v
        a_pos += 1

b_pos = 1
time = 0
for e in b_info :
    v = e[0]
    t = e[1]
    time += t
    for _ in range(t) :
        b_dist[b_pos] = b_dist[b_pos - 1] + v
        b_pos += 1

checked = ''
count = 0
for t in range(1, time + 1) :
    a_d = a_dist[t]
    b_d = b_dist[t]
    if a_d > b_d :
        if checked != 'A' :
            count += 1
        checked = 'A'
    elif a_d < b_d :
        if checked != 'B' :
            count += 1
        checked = 'B'
    elif a_d == b_d:
        if checked != 'C' :
            count += 1
        checked = 'C' 

print(count)