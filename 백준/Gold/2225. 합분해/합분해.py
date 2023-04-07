n, k = map(int, input().split())
mod = 1_000_000_000
d = [[0]*(n+1) for _ in range(k+1)]
d[0][0] = 1
for fk in range(1, k+1) :
    for fn in range(n+1) :
        for i in range(fn+1) :
            d[fk][fn] = (d[fk][fn] + d[fk-1][fn-i]) % mod
print(d[k][n])