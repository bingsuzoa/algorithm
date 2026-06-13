N, B = map(int, input().split())

result = ""

while N > 0 :
    result = result + str(N % B)
    N //= B


print(result[::-1])
