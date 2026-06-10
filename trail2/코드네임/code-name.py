MAX_IN = 5

codename = []
score = []
users = []

class User :
    def __init__(self, codename, score) :
        self.codename = codename
        self.score = score

max = 101
for _ in range(MAX_IN) :
    name, s = input().split()
    s = int(s)
    users.append(User(name, s))

    if max > s :
        max = s


for e in users :
    if e.score == max :
        print(f"{e.codename} {e.score}")
        break


