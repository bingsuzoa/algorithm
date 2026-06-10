secret, place, t = input().split()
time = int(t)

class Code :
    def __init__(self, secret, place, time) :
        self.secret = secret
        self.place = place
        self.time = time


s = Code(secret, place, time)

print(f"secret code : {s.secret}")
print(f"meeting point : {s.place}")
print(f"time : {s.time}")