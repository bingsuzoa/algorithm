n = int(input())

# Please write your code here.
def dfs(n) :
    if n == 1 :
        return 0
    if n % 2 == 0 :
        return dfs(n // 2) + 1 
    return dfs(n * 3 + 1) + 1

print(dfs(n))