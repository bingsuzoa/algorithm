N = int(input())

# Please write your code here.
arr = [0] * (N + 1)

def dfs(cur, N) :
    if N == 1 :
        return 1
    if N == 2 :
        return 1
    if cur > N :
        return arr[N]
    
    if cur <= 2 :
        arr[cur] = 1
        return dfs(cur + 1, N)
    else :
        arr[cur] = arr[cur - 1] + arr[cur - 2]
        return dfs(cur + 1, N)

print(dfs(1, N))
