n = int(input())
p = [0] + list(map(int, input().split()))
d = [10001] * (n+1)
d[0] = 0
for i in range(1, n+1) :
    for j in range(1, i+1) :
        d[i] = min(d[i], d[i-j]+p[j])
print(d[n])