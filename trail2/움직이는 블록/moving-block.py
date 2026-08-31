n = int(input())
blocks = [int(input()) for _ in range(n)]

# Please write your code here.
# N개의 각 위치별 블럭의 갯수가 주어짐
# 특정위치 골라 해당위치의 블럭을 다른 위치로 옮기는 작업을 반복
# 모든 위치에 놓인 블럭의 갯수가 동일해지게
# 움직여야할 최소 블럭의 수를 구하는 프로그램
# 이 과정은 항상 가능
count = 0
for i in range(n) :
    count += blocks[i]

count //= n

ans = 0
for i in range(n) :
    if blocks[i] > count :
        ans += (blocks[i] - count)

print(ans)