N = int(input())

# Please write your code here.
def dfs(N) :
    total_sum = 0

    if N == 0 :
        return 0

    total_sum += dfs(N // 10) + pow(N % 10, 2)
    return total_sum


print(dfs(N))
