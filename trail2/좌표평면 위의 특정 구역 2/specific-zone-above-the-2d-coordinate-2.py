n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.

#N개의 점 중 하나를 제외
#남은 점들을 모두 포함하는 + 좌표축에 평행한 + 직사각형의 넓이를 최소로
#남은 점들이 모두 x값이 같거나, y값이 같은 경우 = 직사각형의 넓이 0이될 수 있음

# 하나씩 돌아가면서 점을 제외했을 때에도 시간복잡도 O(N)
# x축 기준 가장 왼쪽에 있는 점, 가장 오른쪽에 있는 점 / y축 기준 가장 아래쪽, 위쪽에 있는 점 구하기
def getJum(idx) :
    lx = 40001
    rx = -1
    by = 40001
    uy = -1

    for i in range(len(x)) :
        if i == idx : continue
        cx = x[i]
        cy = y[i]
        lx = min(lx, cx)
        rx = max(rx, cx)
        by = min(by, cy)
        uy = max(uy, cy)

    # print(f"{lx}, {rx}, {by}, {uy}")
    return getSize(lx, rx, by, uy)
    

# 넓이 구하기
def getSize(lx, rx, by, uy) :
    return (rx - lx) * (uy - by)


ans = float('inf')
for i in range(len(x)) :
    ans = min(ans, getJum(i))

print(ans)
#테스트 케이스
#(1,1)(1,1)(1,1)(1,1)(2,3)
#(39999 1)(1 399999)(40000 40000)
