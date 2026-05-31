a,b,c = map(int, input().split())
sum = a + b + c
aver = sum // 3
dist = sum - aver
print(f"{sum}\n{aver}\n{dist}")