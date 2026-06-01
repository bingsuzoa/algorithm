n = int(input())


def dfs(cur, n) :
    if cur == n :
        return

    print("HelloWorld")
    dfs(cur+1, n)


dfs(0, n)