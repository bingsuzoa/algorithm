command = input()


ans = 0
for i in range(len(command) - 1) :
    if command[i] == '(' and command[i+1] == '(' :

        if i+2 >= len(command) or len(command) - (i+2) < 1: break

        for j in range(i+2, len(command) - 1) :
            if command[j] == ')' and command[j+1] == ')' :
                ans += 1

print(ans)