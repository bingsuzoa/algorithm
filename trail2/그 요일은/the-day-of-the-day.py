m1, d1, m2, d2 = map(int, input().split())
A = input()

# Please write your code here.
days = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
yoi = ["Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun"]

def get_day(m, d) :
    day = 0
    for i in range(m) :
        day += days[i]
    day += d
    return day

left = get_day(m1, d1)
right = get_day(m2,d2)


std = -1
for i in range(len(yoi)) :
    if yoi[i] == A :
        std = i
        break

moc = abs(left - right) // 7
remain = abs(left - right) % 7

if left < right :
    if remain >= std :
        print(moc + 1)
    else :
        print(moc)    

else :
    if remain >= len(yoi) - std :
        print(moc + 1)
    else :
        print(moc)