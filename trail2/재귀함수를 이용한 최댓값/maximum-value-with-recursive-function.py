n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
def dfs(n) :
    if n == 0 :
        return arr[0]

    return max(arr[n], dfs(n-1))

print(dfs(n - 1))