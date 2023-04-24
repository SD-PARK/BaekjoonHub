def solution(emergency):
    answer = []
    sort_emer = sorted(emergency, reverse=True)
    for i in emergency :
        answer.append(sort_emer.index(i)+1)
    return answer