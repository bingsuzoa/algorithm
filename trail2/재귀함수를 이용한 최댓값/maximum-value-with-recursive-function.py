n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
def dfs(cur, arr) :
    if cur == len(arr) :
        return 0
    
    result = dfs(cur + 1, arr)
    return arr[cur] if arr[cur] > result else result

print(dfs(0, arr))