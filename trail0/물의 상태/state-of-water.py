water = int(input())

if water < 0:
    print("ice")
elif water >= 100:
    print("vapor")
else:
    print("water")