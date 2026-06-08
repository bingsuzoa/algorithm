N = int(input())

# Please write your code here.
def dfs(count) :
    if count == 1 :
        return 2
    if count == 2 :
        return 4
    
    return (dfs(count - 1) * dfs(count -2)) % 100

print(dfs(N))
