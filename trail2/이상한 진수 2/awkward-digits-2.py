num = input()

def change(num) :
    res = 0
    for i in str(num) :
        i = int(i)
        res *= 2
        res += i
    return res

ans = 0
def check(num, idx) :
    global ans
    temp = 0

    for i, n in enumerate(num) :
        n = int(n)
        temp *= 10
        if i == idx :
            temp += 0 if n == 1 else 1
        else :
            temp += n
    result = change(temp)
    ans = max(ans, result)


for idx in range(len(num)) :
    check(num, idx)

print(ans)