arr = list(map(int, input().split()))

# Please write your code here.

#개발자 5명의 알고리즘 능력 수치화하여 정수로
# 2명, 2명 1명씩 팀을 이룬다.
# 최대 능력의 팀과 최소 능력의 팀 간의 능력차이가 [최소]
# 모든 팀의 능력치가 서로 다르게 팀을 묶어야만 함!

#방문 배열 선언 arr size만큼
visited = [False] * len(arr)

#dfs 결과 넣을 배열 선언 arr size
graph = [-1] * len(arr)

#check
def isAllDifferent() :
    global graph

    res1 = graph[0] + graph[1]
    res2 = graph[2] + graph[3]
    res3 = graph[4]

    if res1 != res2 and res2 != res3 and res3 != res1 :
        return True
    return False

def check() :
    global graph

    res1 = graph[0] + graph[1]
    res2 = graph[2] + graph[3]
    res3 = graph[4]

    return max(res1, res2, res3) - min(res1, res2, res3)

#dfs
ans = float('inf')
def dfs(cur) :
    global graph, visited, ans
    if cur == len(graph) and isAllDifferent() :
        res = check()
        ans = min(ans, res)
        return

    for i in range(len(arr)) :
        if not visited[i] :
            visited[i] = True
            graph[cur] = arr[i]
            dfs(cur + 1)
            visited[i] = False

dfs(0)
if ans == float('inf') :
    print(-1)
else :
    print(ans)

#테스트 케이스
#1.모든팀의 능력치가 서로 다르지 않을 때 -1 출력하는지