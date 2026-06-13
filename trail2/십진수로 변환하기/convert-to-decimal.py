binary = input()


binary = binary[::-1]

num = 0
result = 0
for e in binary :
    result += int(e) * pow(2, num)
    num += 1

print(result)