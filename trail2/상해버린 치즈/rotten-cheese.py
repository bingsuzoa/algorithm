N, M, D, S = map(int, input().split())

p, m, t = [], [], []
for _ in range(D):
    person, milk, time = map(int, input().split())
    p.append(person)
    m.append(milk)
    t.append(time)

sick_p, sick_t = [], []
for _ in range(S):
    person, time = map(int, input().split())
    sick_p.append(person)
    sick_t.append(time)

# Please write your code here.
#N명의 사람이 M개의 치즈를 먹었는데, 정확히 하나의 치즈가 상했다.
#특정사람이 어떤 치즈를 언제 먹었는지에 대한 기록이 총 D번주어짐
#특정사람이 언제 확실히 아팠는지에 대한 기록이 S번 주어짐

#아프다고 기록되어있는 사람 외 다른사람도 아플수 있음

#상한 치즈 먹은 사람에게 약을 복용시켜야함. 약이 최대 몇개나 필요할까?

#단 상한치즈 먹으면 1초가 지나야 아프기 시작

#D (몇번째 사람, 몇번째 치즈, 언제 먹었는지)
#S (몇번째 사람, 언제 확실히 아팠는지)
graph = [[] for _ in range(101)]
for i in range(D) :
    ep= p[i]
    ec = m[i]
    et = t[i]
    graph[et].append((ep, ec))

sick_set = set()
for i in range(S) :
    ep = sick_p[i]
    et = sick_t[i]
    sick_set.add(ep)

chize_list = [[] for _ in range(51)]
for i in range(D) :
    ep= p[i]
    ec = m[i]
    if ep not in chize_list[ec] :
        chize_list[ec].append(ep)

def check(chize) :
    chize_chize = chize_list[ec]

    for sp in sick_set :
        if not sp in chize_chize :
            return False
    return True


def getSum(chize) : 
    return len(chize_list[chize])

ans = 0
for i in range(S) :
    sp = sick_p[i]
    st = sick_t[i]
    # print(f"!!{sp}가 {st}에 아프기 시작")
    for j in range(1, st) :
        for ep, ec in graph[j] : 
            if sp == ep :
                # print(f"{j}초에 {ep}번이 {ec}먹고 아픔")
                if check(ec) :
                    ans = max(ans, getSum(ec))


print(ans)