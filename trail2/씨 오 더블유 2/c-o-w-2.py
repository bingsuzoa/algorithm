n = int(input())
command = input()

ans = 0
for i in range(len(command)) :
    if command[i] == 'C' :
            for j in range(i + 1, len(command)) :
                if command[j] == 'O' :
                    for k in range(j + 1, len(command)) :
                        if command[k] == 'W' :
                            ans += 1


print(ans)