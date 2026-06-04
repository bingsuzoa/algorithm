N = int(input())

# Please write your code here.
def dfs(N) :
    tot_count = 0
    if N == 1 :
        return 0

    if N % 2 == 0 :
        tot_count += dfs(N // 2) + 1
    else :
        tot_count += dfs(N // 3) + 1
    
    return tot_count

print(dfs(N))