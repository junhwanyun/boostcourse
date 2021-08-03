### 2021-08-02

# 3주차 미션

##### Q1. 숫자를 입력 받고 그 숫자의 구구단을 출력하는 함수를 만들어 봅시다. 다만 아래의 조건을 만족해 주세요.
- 조건 1: 홀 수 번째만 출력하기
- 조건 2: 값이 50이하인 것만 출력하기
##### 출력 예시
```python
# 입력
number = int(input("몇 단? : "))
gugudan(number)

# 출력
몇 단? : 8
8 단
8 X 1 = 8
8 X 3 = 24
8 X 5 = 40
```

##### A1.
```python
def gugudan(number: int):
    print(number, "단")

    for i in [1, 3, 5, 7, 9]:
        if number * i > 50:
            break;

        print(number, "X", i, "=", number * i);

number = int(input("몇 단?: "))

gugudan(number)
```

---

##### Q2. 가위바위보 업그레이드 버젼을 함수로 만들어 봅시다. 아래와 같은 조건을 만족해 주세요.
- 조건 1: 게임을 몇 판을 진행할 것인지 입력을 받아주기
- 조건 2: 0, 1, 2, "가위", "바위", "보" 이외에 다른 입력을 받으면 재입력 받기
- 조건 3: 게임종료 후 나와 컴퓨터의 총 전적 출력하기
##### 출력 예시
```python
# 입력
games = int(input("몇 판을 진행하시겠습니까? : "))
rsp_advanced(games)

# 출력
가위 바위 보 : 0
나: 가위
컴퓨터: 보
1 번째 판 나의 승리!

가위 바위 보 : 1
나: 바위
컴퓨터: 가위
2 번째 판 나의 승리!

나의 전적: 2승 0무 0패
컴퓨터의 전적: 0승 0무 2패
```

##### A2.
```python
import random

def string_to_integer(string: str) -> int:
    if string == "가위" or string == "0":
        return 0

    if string == "바위" or string == "1":
        return 1

    if string == "보" or string == "2":
        return 2

    return -1

def integer_to_string(integer: int) -> str:
    if integer == 0:
        return "가위"

    if integer == 1:
        return "바위"

    return "보"

def rsp(game: int, user: int) -> int:
    computer = random.randint(0, 2)
    
    print("나:", integer_to_string(user))
    print("컴퓨터:", integer_to_string(computer))

    if user - computer == 0:
        print(game, "번째 판 무승부!")
        
        return 0

    if user - computer == 1 or user - computer == -2:
        print(game, "번째 판 나의 승리!")
        
        return 1

    
    print(game, "번째 판 컴퓨터 승리!")

    return -1

def rsp_advanced(games: int):
    win = 0
    lose = 0
    draw = 0

    game = 1

    while(game <= games):
        user = string_to_integer(input("가위 바위 보: "))

        if user < 0:
            print("Invalid Input")

            game -= 1
        else:
            is_user_win = rsp(game, user)

            if is_user_win > 0:
                win += 1
            elif is_user_win < 0:
                lose += 1
            else:
                draw += 1

        game += 1

    print("나의 전적:", win, "승", draw, "무", lose, "패")
    print("컴퓨터의 전적:", lose, "승", draw, "무", win, "패")

games = int(input("몇 판을 진행하시겠습니까?: "))

rsp_advanced(games)
```

---

##### Q3. 2개의 숫자를 입력하여 그 사이에 짝수만 출력하는 함수를 만들어 봅시다. 그리고 중앙값도 함께 출력 해봅시다.(단, 중앙값이 짝수가 아닐 경우에는 중앙값은 출력을 하지 않고, 짝수인 수만 출력한다)
- 중앙값: 정중앙에 있는 값
- 특정 두 숫자 사이의 수들을 리스트로 만드는 법
```python
n = 1
m = 10
numbers = [ i for i in range(n,m+1)] # [1,2,3,4,5,6,7,8,9,10]
# range(시작 숫자, 끝 숫자 + 1)
```
##### 출력 예시
```python
# 입력
n = int(input("첫 번째 수 입력 : "))
m = int(input("두 번째 수 입력 : "))
find_even_number(n, m)

# 출력
첫 번째 수 입력 : 1
두 번째 수 입력 : 11
2 짝수
4 짝수
6 짝수
6 중앙값
8 짝수
10 짝수
```

##### A3.
```python
def find_median_number(n: int, m: int) -> float:
    return (n + m) / 2

def find_even_number(n: int, m: int):
    if n > m:
        temp = n
        n = m
        m = temp

    numbers = [i for i in range(n, m + 1)]

    median = find_median_number(n, m)
    
    for number in numbers:
        if number % 2 == 0:
            print(number, "짝수")

            if(number == median):
                print(number, "중앙값")


n = int(input("첫 번째 수 입력: "))
m = int(input("두 번째 수 입력: "))

find_even_number(n, m)
```

---

##### Q4. 2개의 숫자를 입력하여 그 사이에 소수가 몇 개인지 출력하는 함수를 만들어 봅시다.
- 소수: 1과 자기 자신만을 약수로 가지는 수
##### 출력 예시
```python
# 입력
n = int(input("첫 번째 수 입력 : "))
m = int(input("두 번째 수 입력 : "))
count_prime_number(n, m)

# 출력
소수개수  4
```

##### A4.
```python
def is_prime(number: int) -> bool:
    if number < 2:
        return False

    i = 2

    while i * i <= number:
        if number % i == 0:
            return False

        i += 1

    return True

def count_prime_number(n: int, m:int):
    if n > m:
        temp = n
        n = m
        m = temp

    count = 0

    for i in range(n, m + 1):
        if is_prime(i):
            count += 1

    print("소수개수", count)

n = int(input("첫 번째 수 입력: "))
m = int(input("두 번째 수 입력: "))

count_prime_number(n, m)
```
