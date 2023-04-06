n = int(input())
a = list(map(int, input().split()))
d = [-1001]*n
max = d[0] = a[0]
for i in range(1, n) :
    if d[i-1] + a[i] > a[i] :
        d[i] = d[i-1] + a[i]
    else :
        d[i] = a[i]
    if d[i] > max :
        max = d[i]
print(max)