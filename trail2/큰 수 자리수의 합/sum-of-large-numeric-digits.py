a, b, c = map(int, input().split())

# Please write your code here.
value = a * b * c

def dfs(n) :
    if n == 0 :
        return 0

    return dfs(n // 10) + n % 10

print(dfs(value))