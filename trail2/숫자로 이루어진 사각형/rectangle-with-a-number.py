n = int(input())

count = 1
for i in range(n) :
    for j in range(n) :
        print(count, end=" ")
        count += 1
        count %= 10
        if count == 0 : count = 1

    print()