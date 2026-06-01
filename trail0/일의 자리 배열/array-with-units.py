A,B = map(int, input().split())

arr = [0] * 10
arr[0] = A
arr[1] = B

for i in range(2, len(arr)):
    arr[i] = (arr[i-1] + arr[i-2]) % 10

print(*arr)