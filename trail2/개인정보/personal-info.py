n = 5
name = []
height = []
weight = []

class student :
    def __init__(self, name, height, weight) :
        self.name = name
        self.height = height
        self.weight = weight

students = []

for _ in range(n):
    n, h, w = input().split()
    name.append(n)
    height.append(int(h))
    weight.append(float(w))
    students.append(student(n, int(h), float(w)))

students.sort(key=lambda e:e.name)
print("name")
for e in students :
    print(e.name, e.height, e.weight)

print()
print("height")
students.sort(key=lambda e: -e.height)
for e in students :
    print(e.name, e.height, e.weight)

# Please write your code here.