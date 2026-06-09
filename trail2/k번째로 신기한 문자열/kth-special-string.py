n, k, t = input().split()
n , k = int(n), int(k)
words = [input() for _ in range(n)]

words.sort()

count = 0
for e in words :
    if e.startswith(t) :
        count += 1
        if count == k :
            print(e)
            break