n = int(input())
name = []
street_address = []
region = []

class person :
    def __init__(self, name, address, region) :
        self.name = name
        self.address = address
        self.region = region

people = []

for _ in range(n):
    n_i, s_i, r_i = input().split()
    name.append(n_i)
    street_address.append(s_i)
    region.append(r_i)
    people.append(person(n_i, s_i, r_i))

# Please write your code here.
people.sort(key=lambda p: p.name)

last_p = people[n-1]

print(f"name {last_p.name}\naddr {last_p.address}\ncity {last_p.region}")

