code, color, second = input().split()
second = int(second)

class Info :
    def __init__(self, code, color, second) :
        self.code = code
        self.color = color
        self.second = second


info = Info(code, color, second)

print(f"code : {info.code}\ncolor : {info.color}\nsecond : {info.second}")