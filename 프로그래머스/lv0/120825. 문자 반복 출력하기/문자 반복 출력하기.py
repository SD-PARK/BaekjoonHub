def solution(my_string, n):
    st = list(my_string)
    answer = ''
    for i in st :
        answer += i * n
    return answer