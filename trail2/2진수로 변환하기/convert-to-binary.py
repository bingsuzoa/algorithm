n = int(input())

# Please write your code here.
num = []

if n == 0 :
    print(0)
else :
    while(n > 0) :
        num.append(n%2)
        n //= 2

    num.reverse()

    for e in num :
        print(e, end="") 