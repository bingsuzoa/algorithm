n = int(input())


def dfs(cur, n) :
    if cur > n :
        return
    
    for i in range(1, cur + 1) :
        print("*", end="")
    print()
    dfs(cur + 1, n)

dfs(1, n)