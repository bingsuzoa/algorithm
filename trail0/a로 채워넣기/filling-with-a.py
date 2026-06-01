string = input()

len = len(string)

string = string[:1] + 'a' + string[2:]
string = string[:len -2] + 'a' + string[len -1:]

print(string)