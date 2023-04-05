n = int(input())
a = list(map(int, input().split()))
d = [0]*n
max = 0
for i in range(n) :
    d[i] = 1
    for j in range(i) :
        if a[i] > a[j] and d[i] <= d[j] :
            d[i] = d[j] + 1
    if d[i] > max :
        max = d[i]
print(max)