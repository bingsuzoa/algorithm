n = int(input())
nums = list(map(int, input().split()))

# Please write your code here.
nums.sort()
for i in range (0, len(nums)) :
    print(nums[i], end=" ")


print()
nums.sort(reverse=True)

print(*nums)