n = int(input())
name = []
korean = []
english = []
math = []

class student :
    def __init__(self, name, kor, eng, math) :
        self.name = name
        self.kor = kor
        self.eng = eng
        self.math = math

students = []

for _ in range(n):
    student_info = input().split()
    name.append(student_info[0])
    korean.append(int(student_info[1]))
    english.append(int(student_info[2]))
    math.append(int(student_info[3]))
    students.append(student(student_info[0], int(student_info[1]), int(student_info[2]), int(student_info[3])))

students.sort(key=lambda e : (-e.kor, -e.eng, -e.math))

for e in students :
    print(e.name, e.kor, e.eng, e.math)


# Please write your code here.