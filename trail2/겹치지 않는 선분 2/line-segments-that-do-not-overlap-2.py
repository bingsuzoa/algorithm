n = int(input())
lines = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.

#x축에 오름차순 정렬
lines.sort()
#나 자신 제외하고 하나씩 확인 O(N^2)

#서로 만나지 않을 조건
# y = 1인 x보다 큰경우 -> 이거에 해당하지 않으면 만나므로 종료

ans = 0
for i in range(len(lines)) :
    lx1 = lines[i][0]
    rx1 = lines[i][1]
    meet = True

    for j in range(len(lines)) :
        if i == j : continue
        lx2 = lines[j][0]
        rx2 = lines[j][1]

        if lx1 > lx2 and rx1 <= rx2 :
            meet = False
            break

        if lx1 < lx2 and rx1 >= rx2 :
            meet = False
            break
    if meet :
        # print(f":{lx1}, {rx1}")
        ans += 1


print(ans)

#테케 극점
# 3 (1000000, -100000) (0, 1) (4, -1)

#태케 모두 평행