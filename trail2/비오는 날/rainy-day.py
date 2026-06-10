n = int(input())
date = []
day = []
weather = []

class Info :
    def __init__(self, date, day, weather) :
        self.date = date
        self.day = day
        self.weather = weather

infos = []

for _ in range(n):
    d, dy, w = input().split()
    date.append(d)
    day.append(dy)
    weather.append(w)
    infos.append(Info(d, dy, w))

# Please write your code here.
infos.sort(key=lambda e:e.date)

for e in infos :
    if e.weather == "Rain" :
        print(f"{e.date} {e.day} {e.weather}")
        break