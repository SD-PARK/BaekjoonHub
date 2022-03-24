N = int(input())
P = [[0 for i in range(3)] for j in range(N+1)]
for i in range(1, N+1):
    P[i] = list(map(int, input().split()))
D = [[0 for i in range(3)] for j in range(N+1)]
D[1] = P[1]
for i in range(2, N+1):
    D[i][0] = min(D[i-1][1], D[i-1][2]) + P[i][0]
    D[i][1] = min(D[i-1][0], D[i-1][2]) + P[i][1]
    D[i][2] = min(D[i-1][0], D[i-1][1]) + P[i][2]
print(min(D[N][0], D[N][1], D[N][2]))