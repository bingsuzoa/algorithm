N = int(input())

# Please write your code here.
arr = [0] * (N + 1)
if N > 2 :
    arr[1] = 1
    arr[2] = 1

def dfs(cur, N) :
    if cur > N :
        return

    arr[cur] = arr[cur - 1] + arr[cur - 2]
    dfs(cur + 1, N)


if N == 1 :
    print("1")
elif N == 2 :
    print("1")
else :
    dfs(3, N)
    print(arr[N])
