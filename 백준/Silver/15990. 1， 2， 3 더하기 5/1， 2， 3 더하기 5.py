d = [[0]*4 for _ in range(100001)]
d[1][1] = d[0][2] = d[0][3] = 1
mod = 1_000_000_009
for i in range(2, 100001) :
    for j in range(1, 4) :
        if j == 1 :
            d[i][1] = (d[i-1][2] + d[i-1][3]) % mod
        elif j == 2 and i >= 2 :
            d[i][2] = (d[i-2][1] + d[i-2][3]) % mod
        elif j == 3 and i >= 3:
            d[i][3] = (d[i-3][1] + d[i-3][2]) % mod

t = int(input())
for _ in range(t) :
    n = int(input())
    print(sum(d[n]) % mod)