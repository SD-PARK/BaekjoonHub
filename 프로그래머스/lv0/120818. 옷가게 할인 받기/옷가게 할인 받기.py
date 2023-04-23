import math
def solution(price):
    discount = 1
    if (price >= 500_000) :
        discount = 0.8
    elif (price >= 300_000) :
        discount = 0.9
    elif (price >= 100_000) :
        discount = 0.95
    return math.floor(price * discount)