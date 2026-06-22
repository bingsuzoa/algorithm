n, m = map(int, input().split())

coma = [tuple(map(int, input().split())) for _ in range(n)]
comb = [tuple(map(int, input().split())) for _ in range(m)]

graph_a = [0] * 1000001
graph_b = [0] * 1000001

ad = 1
for e in coma :
    v = e[0]
    s = e[1]
    for i in range(s) :
        graph_a[ad] = graph_a[ad - 1] + v
        ad += 1

bd = 1
for e in comb :
    v = e[0]
    s = e[1]
    for i in range(s) :
        graph_b[bd] = graph_b[bd - 1] + v
        bd += 1


leader = 0
ans = 0
for t in range(len(graph_a)) :
    a_d = graph_a[t]
    b_d = graph_b[t]

    if a_d > b_d :
        if leader == 2 :
            ans += 1
        leader = 1
    elif a_d < b_d :
        if leader == 1 :
            ans += 1
        leader = 2

print(ans)


    

        