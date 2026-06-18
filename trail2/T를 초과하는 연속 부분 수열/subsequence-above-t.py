n, t = map(int, input().split())
arr = list(map(int, input().split()))

left = 0
right = 0
ans = 0

while right < len(arr) :
    if arr[right] > t :
        ans = max(ans, right - left + 1)
        right += 1
    else :
        right += 1
        left = right

print(ans)