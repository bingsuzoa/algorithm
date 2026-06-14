a, b = map(int, input().split())
n = input()

# Please write your code here.
sum = 0
for e in n :
    sum = sum * a + (int(e) % a)


ans = []
while sum > 0 :
    ans.append(sum % b)
    sum //= b

ans.reverse()

for e in ans :
    print(e, end="")