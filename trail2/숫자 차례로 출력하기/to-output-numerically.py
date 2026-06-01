n = int(input())

def dfs1(cur, n) :
    if cur > n :
        print()
        return

    print(cur, end=" ")
    dfs1(cur + 1, n)


def dfs2(cur) :
    if cur == 0 :
        return

    print(cur, end=" ")
    dfs2(cur -1)    


dfs1(1, n)
dfs2(n)