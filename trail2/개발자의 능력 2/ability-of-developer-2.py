ability = list(map(int, input().split()))

# Please write your code here.
#개발자 6명의 알고리즘 능력을 수치화해 정수로 주어짐
#6명을 2명씩 3팀으로 배정
#팀원들의 능력 총합이 가장 큰 팀과 가장 작은팀의 차이를 최소화할 수 있게 
#균형있게 구성해줄 때의 차를 출력

#테스트케이스 능력수치 1000000

#dfs -> 시간복잡도 6 * 5 * 4 * 3 * 2 * 1 = 가능

#방문여부 : vistied 선언
visited = [False] * 6

#팀구성배열 : 6선언(ability 인덱스를 넣어줄거임)
arr = [-1] * 6

# 팀의 차이 최소 구하는 함수
def check() :
    global arr, ability

    res1 = arr[0] + arr[1]
    res2 = arr[2] + arr[3]
    res3 = arr[4] + arr[5]

    minSum = min(res1, res2)
    maxSum = max(res1, res2)
    minSum = min(minSum, res3)
    maxSum = max(maxSum, res3)

    return abs(maxSum - minSum)

#dfs 팀구성 시작
ans = float('inf')
def dfs(cur) :
    global visited, ans
    if cur == len(arr) :
        res = check()
        ans = min(ans, res)
        return
    
    for i in range(len(ability)) :
        if not visited[i] :
            visited[i] = True
            arr[cur] = ability[i]
            dfs(cur + 1)
            visited[i] = False

dfs(0)
print(ans)