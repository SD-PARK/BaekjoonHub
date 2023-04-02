n = int(input())
x = [n]*(n+1)
x[0] = x[1] = 0
for i in range(2, n+1) :
    if i%3 == 0 :
        x[i] = x[i//3] + 1
    if i%2 == 0 and (x[i//2] + 1) < x[i] :
        x[i] = x[i//2] + 1
    if (x[i-1] + 1) < x[i] :
        x[i] = x[i-1] + 1
print(x[n])