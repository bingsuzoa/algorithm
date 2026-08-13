n = int(input())
arr = [int(input()) for _ in range(n)]


ans = -1
for i in range(n) :
    for j in range(i+1, n) :
        for k in range(j+1, n) :
            carry = False

            if arr[i] % 10 + arr[j] % 10 + arr[k] % 10 >= 10 :
                carry = True
            
            if arr[i] % 100 // 10 + arr[j] % 100 // 10 + arr[k] % 100 // 10 >= 10 :
                carry = True
            
            if arr[i] % 1000 // 100 + arr[j] % 1000 // 100 + arr[k] % 1000 // 100 >= 10 :
                carry = True
            if arr[i] % 10000 // 1000 + arr[j] % 10000 // 1000 + arr[k] % 10000 // 1000 >= 10 :
                carry = True
            if arr[i] // 10000 + arr[j] // 10000 + arr[k] // 10000 >= 10 :
                carry = True

            if not carry :
                res = arr[i] + arr[j] + arr[k]
                ans = max(ans, res)            

print(ans)