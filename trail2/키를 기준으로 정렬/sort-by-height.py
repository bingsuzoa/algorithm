n = int(input())

class User :
    def __init__(self, name, height, weight) :
        self.name = name
        self.height = height
        self.weight = weight

users = []

for _ in range(n) :
    n_i, h_i, w_i = input().split()
    h_i = int(h_i)
    w_i = int(w_i)
    users.append(User(n_i, h_i, w_i))

users.sort(key=lambda e :e.height)

for e in users :
    print(e.name, e.height, e.weight)

