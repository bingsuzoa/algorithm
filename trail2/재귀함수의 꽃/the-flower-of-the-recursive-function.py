N = int(input())

def dfs(N) :
    if N == 0 :
        return
    print(N, end=" ")
    dfs(N-1)
    print(N, end=" ")

dfs(N)