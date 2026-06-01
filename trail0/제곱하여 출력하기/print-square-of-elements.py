N = int(input())
arr = list(map(int, input().split()))

double = []
for i in range(0, len(arr)) :
    double.append(arr[i]** 2)

print(*double)