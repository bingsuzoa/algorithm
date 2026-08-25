N = int(input())
a, b, c = map(int, input().split())

# Please write your code here.

#세 자리로 이루어진 번호를 입력해 여는 자물쇠
#각 자리에는 1이상 N이하 정수, 서로 다른 자리에 같은 수 넣을 수 있음
#기준번호가 있음. 한자리라도 두 수의 차이의 [절댓값]이 2이하면 열림

#자물쇠를 열 수 있는 서로 다른 번호의 개수


# 1. N ^ 3의 값을 ans 초기값으로 둠
ans = N * N * N
# 2. 함수를 만든다. for문으로 1~N까지 돌면서 절댓값 > 2이면 + 1
def check(num) :
    count = 0
    for pair in range(1, N +1 ) :
        if abs(num - pair) > 2 :
            count += 1
    return count

# 3. 기준번호들을 함수에 넣어 결과 확인
res1 = check(a)
res2 = check(b)
res3 = check(c)

# 4. ans -= 결과 뺀다.
ans -= (res1 * res2 * res3)

print(ans)