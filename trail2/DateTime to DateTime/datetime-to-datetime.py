sd, sh, sm = 11, 11, 11
ed, eh, em = tuple(map(int, input().split()))


left = 0 if sd == 1 else (sd - 1) * 24 * 60
left += (sh * 60) + sm

right = 0 if ed == 1 else (ed -1) * 24 * 60
right += (eh * 60) + em

if left > right :
    print(-1)
else :
    print(right - left)