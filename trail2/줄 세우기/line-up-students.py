n = int(input())
arr = [tuple(map(int, input().split())) + (i+1,) for i in range(n)]

# Please write your code here.
class student :
    def __init__(self, height, weight, num) :
        self.height = height
        self.weight = weight
        self.num = num

students = []

for e in arr :
    students.append(student(e[0], e[1], e[2]))

students.sort(key=lambda e:(-e.height, -e.weight, e.num))

for e in students :
    print(e.height, e.weight, e.num)