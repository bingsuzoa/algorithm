str = input()

ans = 0
for i in range(len(str)) :
    if str[i] == '(' :
        for j in range(i+1, len(str)) :
            if str[j] == ')' :
                ans += 1


print(ans)
