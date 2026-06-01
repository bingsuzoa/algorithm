import math

n, m = map(int, input().split())

gcd = math.gcd(n,m)

n //= gcd
m //= gcd

print(gcd * n * m)