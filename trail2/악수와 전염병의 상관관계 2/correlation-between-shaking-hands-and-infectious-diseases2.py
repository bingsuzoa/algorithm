#N: 개발자수
#T: T번에 걸쳐
#K: K번의 악수동안만 전염병을 옮긴다
#P : 전염병 걸려있는 개발자 번호


#시간순서로 정렬
N, K, P, T = map(int ,input().split())
command = [tuple(map(int, input().split())) for _ in range(T)]

command.sort(key=lambda x:x[0])


#개발자에 대한 정보(전염병에 옮았는지 여부)
#초기 전염병 걸려있는 개발자 체크
person = [0] * (N+1) 
person[P] = 1

#악수 몇번
contact = [0] * (N+1)

#왼쪽 체크
#감염이 되어있는지
#감염이 되었으면 악수 몇번째인지 > K 이면 전염안됨

for e in command :
    t = e[0]
    p1 = e[1]
    p2 = e[2]

    if not person[p1] == 1 and not person[p2] == 1 :
        continue
    
    infected_p1 = True if person[p1] == 1 else False
    infected_p2 = True if person[p2] == 1 else False

    if infected_p1 :
        if contact[p1] < K :
            contact[p1] += 1
            person[p2] = 1
        

    if infected_p2 :
        if contact[p2] < K :
            contact[p2] += 1
            person[p1] = 1
        

for i in range(1, len(person)) :
    print(person[i], end="")