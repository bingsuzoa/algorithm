n = int(input())
arr = list(map(int, input().split()))


sum = 0
for i in range(n) :
    if i % 2 == 0 :
        sorted_arr = arr[0 : i+1]
        sorted_arr.sort()
        print(sorted_arr[i//2], end=" ")
        

            