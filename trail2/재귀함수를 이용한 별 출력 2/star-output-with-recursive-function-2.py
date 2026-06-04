n = int(input())

# Please write your code here.
def dfs(n) :
    if n == 0 :
        return
    for i in range(n) :
        print("*", end=" ")
    print()

    dfs(n-1)
    for i in range(n) :
        print("*", end=" ")
    print()

dfs(n)