n = int(input())
d = [[0]*3 for _ in range(n)]
d[0][0] = d[0][1] = d[0][2] = 1
mod = 9901
for i in range(1, n) :
    d[i][0] = (d[i-1][0] + d[i-1][1] + d[i-1][2]) % mod
    d[i][1] = (d[i-1][0] + d[i-1][2]) % mod
    d[i][2] = (d[i-1][0] + d[i-1][1]) % mod
print(sum(d[n-1]) % mod)