n = int(input())
sequence = list(map(int, input().split()))

# Please write your code here.

# 원소의 갯수가 n개인 수열이 주어졌다.
# 맨 앞에 있는 원소 선택해 수열의 맨뒤를 포함한 원하는 위치에 다시넣어
# 최소 몇번 반복해야 원소들이 오름차순 정렬이 될까


# 오름차순이 되는 마지막 구간 찾기
left = sequence[0]
idx = 0
for i in range(1, len(sequence)) :
    if left > sequence[i] :
        idx = i

    left = sequence[i]

print(idx)
