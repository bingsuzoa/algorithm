N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

# Please write your code here.
ansArr = [0] * 101
for i in range(len(B)) :
    ansArr[B[i]] += 1

tmpArr = [0] * 101

def check(arr1, arr2) :
    for i in range(len(arr1)) :
        if arr1[i] != arr2[i] :
            return False
    return True

ans = 0
# for i in range(len(A) - M + 1) :
#     tmpArr = [0] * 101
#     for j in range(i, i + M) :
#         tmpArr[A[j]] += 1
#     if check(ansArr, tmpArr) :
#         ans += 1

left = 0
right = 0
cnt = 0
tmpArr = [0] * 101
while left <= len(A) - M :
    if right < len(A) and cnt < M :
        tmpArr[A[right]] += 1
        cnt += 1
        right += 1
        if cnt == M :
            # print(f"{left}, {right}")
            if check(ansArr, tmpArr) :
                ans += 1
            tmpArr[A[left]] -= 1
            cnt -= 1
            left += 1



print(ans)
