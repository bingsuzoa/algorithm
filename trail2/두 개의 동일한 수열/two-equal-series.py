n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort()

isSame = True
for i in range(len(A)) :
    if A[i] != B[i] :
        print("No")
        isSame = False
        break
    
if isSame :
    print("Yes")   