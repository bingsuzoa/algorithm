n, k = map(int, input().split())

dict = {}
for _ in range(n) :
    num, char = input().split()
    dict[int(num)] = char
# Please write your code here.

data = {'G' : 1, 'H' : 2}
ans = 0
for x in range(1, k+2) :
    if x in dict :
        ans += data[dict[x]]

cur = ans
for x in range(1, 10000 - k + 1) :
    if x in dict :
        left = dict[x]
        cur -= data[left]
    if x + k + 1  in dict :
        right = dict[x + k + 1]
        cur += data[right]
    ans = max(ans, cur)
print(ans)
