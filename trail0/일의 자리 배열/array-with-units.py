A,B = map(int, input().split())

arr = []
arr.append(A)
arr.append(B)

for i in range(2, 10) :
    value = arr[i-1] + arr[i-2]
    value %= 10
    arr.append(value)

print(*arr)