n = int(input())
arr = [int(input()) for _ in range(n)]

# Please write your code here.

left = 0
right = 1
cur = arr[0]
ans = 1

while right < len(arr) :
    if arr[right] > arr[right -1] :
        ans = max(ans, right - left + 1)
    else :
        left = right
        cur = arr[right]
    right += 1

print(ans)