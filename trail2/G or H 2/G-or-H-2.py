n = int(input())
people = [tuple(input().split()) for _ in range(n)]
pos = [int(p[0]) for p in people]
alpha = [p[1] for p in people]

# Please write your code here.
arr = [''] * 101
maxSize = 0
minSize = float('inf')

for i in range(len(pos)) :
    idx = pos[i]
    arr[idx] = alpha[i]
    maxSize = max(maxSize, idx)
    minSize = min(minSize, idx)

# print(arr)
g_cnt = 0
h_cnt = 0
ans = 0

def addCnt(str) :
    global g_cnt, h_cnt
    if str == 'G' :
        g_cnt += 1
    if str == 'H' :
        h_cnt += 1


def check() :
    if g_cnt == 0 and h_cnt > 0 :
        return True
    if g_cnt > 0 and h_cnt == 0 :
        return True
    if g_cnt == h_cnt :
        return True
    return False

for i in range(minSize, maxSize + 1) :
    g_cnt = 0
    h_cnt = 0
    if arr[i] != '' :
        for j in range(i, maxSize + 1) :
            if arr[j] == '' : continue
            addCnt(arr[j])
            if check() :
                # if j - i == 13 :
                #     print(f"{i}, {j}, {g_cnt}, {h_cnt}")
                ans = max(ans, j - i)

print(ans)
