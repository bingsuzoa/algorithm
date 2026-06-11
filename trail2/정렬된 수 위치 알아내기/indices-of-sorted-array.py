n = int(input())
arr = list(map(int, input().split()))

class number :
    def __init__(self, old_order, num) :
        self.old_order = old_order
        self.num = num
        self.new_order = -1

    def set_order(self, new_order) :
        self.new_order = new_order

nums = []

for i in range(len(arr)) :
    nums.append(number(i+1, arr[i]))


nums.sort(key=lambda e:e.num)


for i in range(len(arr)) :
    nums[i].set_order(i+1)


nums.sort(key=lambda e:e.old_order)


ans=[]

for e in nums :
    ans.append(e.new_order)

for e in ans :
    print(abs(e), end=" ")