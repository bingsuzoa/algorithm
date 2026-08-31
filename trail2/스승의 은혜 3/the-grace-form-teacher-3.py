N, B = map(int, input().split())
gifts = [tuple(map(int, input().split())) for _ in range(N)]
P = [gift[0] for gift in gifts]
S = [gift[1] for gift in gifts]

# Please write your code here.
# 선생님 N명의 학생에게 B만큼의 예산으로 선물을 주려고 한다.
# 학생 i가 원하는 선물 가격 P(i)와 배송비 S(i)가 있다.
# 선생님은 선물 하나를 정해서 반값으로 할인받을 수 있는 쿠폰
# 선생님이 선물 가능한 학생의 최대 명수
# 선물가격은 항상 짝수

# 총합이 작은 순서로 오름차순 정렬
temp = sorted((P[i] + S[i], i)for i in range(N))
# [(2, 1), (6, 0), (9, 2), (9, 3), (17, 4)]

# 0번째 학생부터 쿠폰 쓴 학생 제외하고 차례대로 가격에 반영 -> 예산까지
def check(idx, cur) :
    res = 1
    for i in range(N) :
        if i == idx : continue
        if cur + temp[i][0] <= B :
            cur += temp[i][0]
            res += 1
    # print(f"{idx}, {cur}, {res}")
    return res

# N명 학생마다 for문 돌리면서 쿠폰을 쓸거임 -> 이때 가격에 반영
# [(2, 1), (6, 0), (9, 2), (9, 3), (17, 4)]
ans = 0
for i in range(N) :
    idx = temp[i][1]
    price = P[idx]
    deliver = S[idx]
    cur = price // 2 + deliver
    if cur > B : continue
    ans = max(ans, check(i, cur))

print(ans)