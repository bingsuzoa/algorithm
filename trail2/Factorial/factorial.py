N = int(input())

# Please write your code here.
def dfs(N) :
    total_gop = 1
    if N == 0:
        return 1
    total_gop *= dfs(N -1) * N
    return total_gop


print(dfs(N))
    