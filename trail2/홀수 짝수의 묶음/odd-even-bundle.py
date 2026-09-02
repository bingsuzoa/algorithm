N = int(input())
numbers = list(map(int, input().split()))

# Please write your code here.
# N개의 정수가 주어짐
# 주어진 수 전부 사용하여 비어있지 않은 하나 이상의 묶음으로 나눈 뒤 각 묶음의 합을 구해?
# 첫번째 묶음부터  그 합이 짝홀짝홀(짝수시작)

#묶음 한개 가능, 각 수는 정학히 하나의 묶음에 속해야함, 묶음이 비면안됨

even = 0
odd = 0

for e in numbers :
    if e % 2 == 0 :
        even += 1
    else :
        odd += 1


group_num = 0
while True :
    if group_num % 2 == 0 :
        if even :
            even -= 1
            group_num += 1
        elif odd >= 2 :
            odd -= 2
            group_num += 1
        else :
            if even >0 or odd > 0 :
                group_num -= 1
            break
    else :
        if odd :
            odd -= 1
            group_num += 1
        else :
            break

print(group_num)