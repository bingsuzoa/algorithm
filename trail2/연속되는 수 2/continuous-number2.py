n = int(input())
arr = [int(input()) for _ in range(n)]


left = 0
right = 1
cur = arr[0]
ans = 1

while right < len(arr) :
    if arr[right] == cur :
        ans = max(ans, right - left + 1)
    else :
        left = right
        cur = arr[left]
    right += 1


print(ans)
