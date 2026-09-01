n, m = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.

# 0 과 1로만 이루어진 n개의 정수가 주어짐
# 1~n 위치까지 사람이 살고있는지를 나타냄
# 1이면 살고 있고, 0이면 그렇지 않음

# 와이파이 설치하려고함. 설치한 위치로부터 거리 m이내에 있는 사람들까지 모두 사용가능
# 사람 아닌곳도 설치가능

# 모든 사람이 와이파이 사용할 수 있도록, 최소 와이파이 수 출력하는 프로그램 작성


# arr를 순서대로 돌면서 1인 곳이 시작하면 바로 와이파이 설치
# i + (m * 2 + 1)부터 다시 또 1인 곳 찾기 1시작하면 바로 와이파이 설치 지속

ans = 0
idx = 0
while idx < len(arr) :
    if arr[idx] == 1 :
        ans += 1
        idx += (m * 2 + 1)
    else :
        idx += 1

print(ans)