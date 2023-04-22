def solution(array):
    answer = 0
    cnt = [0] * 1000
    max = 0
    for i in array :
        if (cnt[max] < cnt[i] + 1) :
            answer = max = i
        elif (cnt[max] == (cnt[i] + 1)) :
            answer = -1
        cnt[i] += 1
    return answer