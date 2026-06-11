n = int(input())

grid = [(i+1, tuple(map(int, input().split()))) for i in range(n)]

class student :
    def __init__(self, num, height, weight) :
        self.num = num
        self.height = height
        self.weight = weight

students = []

for e in grid :
    students.append(student(e[0], e[1][0], e[1][1]))

students.sort(key=lambda e:(e.height, -e.weight))

for e in students :
    print(e.height, e.weight, e.num)