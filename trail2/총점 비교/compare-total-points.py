n = int(input())

name = []
score1 = []
score2 = []
score3 = []

class student :
    def __init__(self, name, score1, score2, score3) :
        self.name = name
        self.score1 = score1
        self.score2 = score2
        self.score3 = score3
        self.sum = (score1 + score2 + score3)


students = []

for _ in range(n):
    student_input = input().split()
    n_i = student_input[0]
    s1_i = int(student_input[1])
    s2_i = int(student_input[2])
    s3_i = int(student_input[3])
    students.append(student(n_i, s1_i, s2_i, s3_i))

students.sort(key=lambda e:e.sum)

for e in students :
    print(e.name, e.score1, e.score2, e.score3)
    


# Please write your code here.