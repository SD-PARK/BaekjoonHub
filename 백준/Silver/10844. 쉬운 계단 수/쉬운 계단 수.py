n = int(input())
d = [[0] * 10 for _ in range(n+1)]
mod = 1_000_000_000
for i in range(1, 10) :
    d[1][i] = 1
for i in range(2, n+1) :
    d[i][0] = d[i-1][1]
    for j in range(1, 9) :
        d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % mod
    d[i][9] = d[i-1][8]
print(sum(d[n]) % mod)