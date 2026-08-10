n = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]

def calculate(idx) :
    sum = 0
    for i in range(len(graph) - 1) :
        left = i
        right = i+1

        if right == idx :
            right = i + 2
        elif left == idx :
            continue
        
        lx = graph[left][0]
        ly = graph[left][1]
        rx = graph[right][0]
        ry = graph[right][1]
        sum += abs(lx - rx) + abs(ly - ry)
    return sum

ans = 400001
for idx in range(len(graph)) :
    if idx == 0 or idx == len(graph) - 1 : continue
    res = calculate(idx)
    ans = min(ans, res)

print(ans)