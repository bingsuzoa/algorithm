n = int(input())

initGraph = [int(input()) for _ in range(n)]

graph = [0] * (n * 2)
for i in range(len(initGraph)) :
    graph[i] = initGraph[i]
    graph[i + n] = initGraph[i]

def calculate(left, right) :
    sum = 0
    cnt = 1
    for i in range(left, right) :
        sum += (graph[i] * cnt)
        cnt += 1
    return sum


ans = float('inf')
for i in range(n) :
    ans = min(ans, calculate(i+1, i+n))

print(ans)
