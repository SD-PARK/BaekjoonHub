def solution(money):
    length = len(money)
    answer = 0
    for j in range(2) :
        d = [0] * length
        if (j) :
            d[0] = money[0]
            money[-1] = -1000 * 1_000_000
        else :
            d[0] = -1000 * 1_000_000
        d[1] = money[1]
        for i in range(2, length) :
            d[i] = max((d[i-1] - money[i]), d[i-2], d[i-3]) + money[i]
        answer = max(answer, d[-1])
    return answer