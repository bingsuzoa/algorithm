n = int(input())
word = [input() for _ in range(n)]

# Please write your code here.
word.sort()

for e in word :
    print(e, end="\n")