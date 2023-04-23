def solution(m, n, puddles):
    d = [[0] * n for i in range(m)]
    d[0][0] = 1
    mod = 1_000_000_007
    for puddle in puddles :
        d[puddle[0]-1][puddle[1]-1] = -1
    for i in range(m) :
        for j in range(n) :
            if (d[i][j] == -1) :
                d[i][j] = 0
            else :
                if (d[i-1][j] != -1) :
                    d[i][j] += d[i-1][j]
                if (d[i][j-1] != -1) :
                    d[i][j] += d[i][j-1]
                d[i][j] %= mod
    return d[-1][-1]