n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.

#N개의 점중 3개를 골라 삼각형을 만든다
#한변은 x축에 평행, 다른한변은 y축에 평행한 삼각형 중 최대 넓이에 2를 곱한 값

# 시간복잡도 O(N^2)

# points 오름차순 정렬
points.sort()
arrx = [p[0] for p in points]
arry = [p[1] for p in points]

# x,y를 돌아가면서 체크한다.
# 먼저 x 기준으로 같은 x축의 x가 있는지 확인 + 우측부터 확인하면 됨 + y배열 돌면서 파라미터의 y랑 같으면 stop
# y도 우측부터 확인 + x배열 돌면서 x랑 같으면 stop
ans = 0
def check(x, y) :
    global ans
    px = x
    py = y

    for i in range(len(arry) - 1, -1, -1) :
        if y == arry[i] :
            if abs(x - px) < abs(x - arrx[i]) :
                px = arrx[i]
        if x == arrx[i] :
            # print("세로후보:", x, y, arrx[i], arry[i], py)
            if abs(y - py) < abs(y - arry[i]) :
                py = arry[i]
    # print(f"{x}, {y}, {px}, {py}")

    ans = max(ans, abs(x - px) * abs(y - py))

for i in range(len(arrx)) :
    check(arrx[i], arry[i]) 

print(ans)

#테케
#평행한 변이 아예 없을때 -> 0 (0,0)(1,1)(2,2)
#극값 -> (-10000,2) (10000,2)(100000, 10000) (3,4)(5,5)