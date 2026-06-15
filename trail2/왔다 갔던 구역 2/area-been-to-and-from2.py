n = int(input())
arr = []
dir = []
for _ in range(n) :
    a, b = input().split()
    arr.append(int(a))
    dir.append(b)

res = [0] * 2001

pointer = 1000
for i in range(n) :
    if dir[i] == 'R' :
        left = pointer
        right = pointer + arr[i]
        pointer = right
    if dir[i] == 'L' :
        left = pointer - arr[i]
        right = pointer
        pointer = left
    for j in range(left, right) :
        res[j] += 1
    

ans = 0
for e in res :
    if e >= 2 :
       ans += 1 


print(ans)