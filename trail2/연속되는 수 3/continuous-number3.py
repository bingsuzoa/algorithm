n = int(input())
arr = [int(input()) for _ in range(n)]


def check(num) :
    if num > 0 :
        return True
    return False

left = 0
right = 1
cur = check(arr[0])
ans = 1

while right < len(arr) :
    next = check(arr[right])
    if cur == next :
        ans = max(ans, right - left + 1)
    else :
        left = right
        cur = next
    right += 1

print(ans)
