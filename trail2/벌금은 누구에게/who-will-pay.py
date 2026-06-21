N, M, K = map(int, input().split())
student = [int(input()) for _ in range(M)]

# Please write your code here.
students = [0] * (N + 1)

checked = False
for stu in student :
    students[stu] += 1
    if students[stu] >= K :
        checked = True
        print(stu)
        break

if not checked :
    print(-1)