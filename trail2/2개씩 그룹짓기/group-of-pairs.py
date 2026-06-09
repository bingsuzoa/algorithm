n = int(input())
arr = list(map(int, input().split()))

len = len(arr)
arr.sort()
answer = -1

for i in range(n) :
    pair =  len - 1 - i
    answer = max(answer, arr[i] + arr[pair])

print(answer)

