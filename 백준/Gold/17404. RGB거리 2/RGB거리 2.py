n = int(input())
cost = []
for i in range(n) :
    cost += [list(map(int, input().split()))]
ans = 1000*1000
for i in range(3) :
    d = [[0]*3 for _ in range(n)]
    for j in range(3) :
        if j == i :
            d[0][j] = cost[0][j]
        else :
            d[0][j] = 1000*1000
    for j in range(1, n) :
        d[j][0] = min(d[j-1][1], d[j-1][2]) + cost[j][0]
        d[j][1] = min(d[j-1][0], d[j-1][2]) + cost[j][1]
        d[j][2] = min(d[j-1][0], d[j-1][1]) + cost[j][2]
    for j in range(3) :
        if j != i :
            ans = min(ans, d[n-1][j])
print(ans)