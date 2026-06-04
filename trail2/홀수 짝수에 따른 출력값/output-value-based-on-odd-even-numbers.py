N = int(input())

# Please write your code here.


def dfs(N) :
    tot_sum = 0
    if N <= 0 :
        return 0
    
    tot_sum += dfs(N - 2) + N

    return tot_sum

print(dfs(N))
    