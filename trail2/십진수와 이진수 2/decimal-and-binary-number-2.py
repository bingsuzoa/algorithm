N = input()

# Please write your code here.
sum = 0
for e in N :
    sum = sum * 2 + (int(e) % 2)

sum *= 17

ans = []
while sum > 0 :
    ans.append(sum % 2)
    sum //= 2

ans.reverse()

for e in ans :
    print(e, end="")