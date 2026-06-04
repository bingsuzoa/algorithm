N = int(input())

# Please write your code here.
def dfs(num, N) :
    total_sum = 0
    if num > N :
        return 0

    total_sum += dfs(num + 1, N) + num
    return total_sum


print(dfs(1, N))
