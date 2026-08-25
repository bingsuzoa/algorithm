N, H, T = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
# 낮은 밭의 높이를 1 올린다. 높은 밭의 높이를 1 내린다. = 비용 1
# N개의 밭의 높이 주어짐
# 최소 T번 이상 H 높이로 나오게끔 하려고 할 때 필요한 최소 비용

# 최소 T번 이상이면 그냥 T번(비용을 구하는거니까)
# 슬라이딩 윈도우로하면 O(N)으로 끝낼 수 있음

# 1.첫번째 T개의 구간에서 필요한 비용 구하기
ans = 0
for i in range(T) :
    ans += abs(arr[i] - H)

# 2. 1번째부터 시작해서 슬라이딩 윈도우 시작, 최소비용 갱신
cur = ans
for i in range(1, len(arr) - T + 1) :
    leftCost = abs(arr[i - 1] - H)
    rightCost = abs(arr[i + T - 1] - H)
    cur -= leftCost
    cur += rightCost
    ans = min(ans, cur)

print(ans)