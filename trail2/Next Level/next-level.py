user_id, level = input().split()
user_level = int(level)

class User :
    def __init__(self, user_id, user_level) :
        self.user_id = user_id
        self.user_level = user_level

user1 = User("codetree", 10)
user2 = User(user_id, user_level)

print(f"user {user1.user_id} lv {user1.user_level}")
print(f"user {user2.user_id} lv {user2.user_level}")