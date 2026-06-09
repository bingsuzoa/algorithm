import math

n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
def dfs(n) :
    if n == 0 :
        return arr[0]
    
    result = dfs(n-1)
    value = math.gcd(arr[n], result)
    return (arr[n] // value) * (result // value) * value

print(dfs(n-1))