a,b = input().split()

num1 = len(a)
num2 = len(b)
if num1 < num2 :
    print(b, num2)
elif num1 > num2 :
    print(a, num1)
else:
    print("same")