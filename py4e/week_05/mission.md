### 2021-08-16

# 5주차 미션

##### Q1. 여러분 혹시 베스킨라빈스31 게임을 아시나요? 1부터 31까지 숫자를 플레이어들끼리 번갈아 외치다가 31을 외치는 사람이 패배하는 게임인데요.
##### 이번엔 이 게임을 파이썬 함수로 만들어 봅시다. 지성이 없이 숫자를 랜덤하게 외치는 컴퓨터와 대결을 해보겠습니다.
- 조건1 - 나의 턴에서는 숫자를 직접 입력하며 한 번 입력 후에 space 한 번으로 구분
  - Ex)
```python
my = input("My turn - 숫자를 입력하세요: ")
1 2 3
```
- 조건2 - 나와 컴퓨터 모두 한 턴에 1회 ~ 3회까지만 숫자를 외칠 수 있음
- 외쳐진 숫자보다 1큰 수만 외칠수 있음 (ex: 5 다음엔 무조건 6)
- hint
```python
# 컴퓨터가 1~3회 중에서 몇 번을 시도할 것인지 랜덤하게 고르는 방법
import random 
computer_turn_num = random.randint(1,3)

# 첫번째를 나타내는 인덱스 0, 마지막을 나타내는 인덱스 -1
example = [1,2,3]
print(example[0]) # 1
print(example[-1] # 3 
```
- 출력 예시
```python
bs31()

베스킨라빈스 써리원 게임
------------------
My turn - 숫자를 입력하세요: 1 2 3
현재 숫자 : 3
컴퓨터 : 4
현재 숫자 : 4

My turn - 숫자를 입력하세요: 5
현재 숫자 : 5
컴퓨터 : 6
컴퓨터 : 7
현재 숫자 : 7

...
```

##### A1.
```python
import random

def is_valid(current_num:int, user_turn_num: list) -> bool:
    length = len(user_turn_num)

    if length < 1 or length > 3:
        return False

    for i in range(length):
        if not user_turn_num[i].isnumeric():
            return False

        if i == 0:
            if int(user_turn_num[0]) - current_num != 1:
                return False
        else:
            if int(user_turn_num[i]) - int(user_turn_num[i - 1]) != 1:
                return False

    return True

def bs31() -> bool:
    winner = None

    current_num = 0

    while winner is None:
        user_turn_num = input("My turn - 숫자를 입력하세요: ").split()

        if not is_valid(current_num, user_turn_num):
            print("Invalid input. Please retry.")

            continue

        current_num = int(user_turn_num[-1])

        print(f"현재 숫자: {current_num}")

        if current_num == 30:
            return True

        computer_turn_num = random.randint(1, 3)

        for i in range(computer_turn_num):
            current_num += 1

            print(f"컴퓨터: {current_num}")

        print(f"현재 숫자: {current_num}")

        if current_num == 30:
            return False

        print()

def solve_question():
    print("bs31()")
    print()
    print("베스킨라빈스 써리원 게임")
    print("------------------")

    is_win = bs31()

    print()
    if is_win:
        print("Win!!!")
        
        return

    print("Lose!!!!")

solve_question()
```

---

##### Q2. 다음과 같이 학생들의 시험 답지가 있습니다. 그리고 답안지도 있습니다.
##### 함수를 하나 만들어 채점을 하고 학생들의 점수를 출력하고 등수도 함께 출력해주세요.
```python
# 학생 답
s = ["김갑,3242524215",
"이을,3242524223",
"박병,2242554131",
"최정,4245242315",
"정무,3242524315"]

# 정답지
a = [3,2,4,2,5,2,4,3,1,2]
```
- hint
```python
# 문자열도 숫자 정렬 가능
a = ["5","2","3"]
a.sort()
["2", "3", "5"]
# 내림차순 정렬 가능
a.sort(reverse=True)
["5", "3", "2"]
```
- 출력 예시
```python
grader(s, a)
학생: 정무 점수: 90점 1등
학생: 김갑 점수: 80점 2등
학생: 이을 점수: 70점 3등
학생: 박병 점수: 50점 4등
학생: 최정 점수: 40점 5등
```

##### A2.
```python
def get_score(solution: str, answers: list) -> int:
    score = 0

    for i in range(len(solution)):
        if int(solution[i]) == answers[i]:
            score += 10

    return score

def grader(solvings: list, answers: list):
    names = []
    scores = []
    ranks = []

    for solving in solvings:
        temp = solving.split(",")

        names.append(temp[0])

        score = get_score(temp[1], answers)

        scores.append(score)
        ranks.append(score)
    
    ranks.sort(reverse = True)

    for i in range(len(ranks)):
        index = scores.index(ranks[i])

        print(f"학생: {names[index]} 점수: {scores[index]}점 {i + 1}등")

def solve_question():
    # 학생 답
    s = ["김갑,3242524215",
            "이을,3242524223",
            "박병,2242554131",
            "최정,4245242315",
            "정무,3242524315"]

    # 정답지
    a = [3,2,4,2,5,2,4,3,1,2]

    print("grader(s, a)")

    grader(s, a)

solve_question()
```

---

##### Q3. 숫자 맞추기 게임을 만들어 볼게요. 컴퓨터가 임의의 숫자를 3개 만들고 우리가 그것을 맞춰보겠습니다.
- 조건1 - 숫자는 0 ~ 100까지 숫자를 3개 만듭니다(중복 불가).
- 조건2 - 5회, 10회까지 정답을 못맞추면 최솟값, 최대값에 대한 힌트를 줍니다.
- 조건3 - 정답을 맞추면, 맞춘 정답이 최솟값인지, 중간값인지, 최댓값인지 알려줍니다.
```python
import random
number = random.randint(0, 100)
```
- 출력 예시
```python
guess_numbers()

1차 시도
숫자를 예측해보세요 : 39
숫자를 맞추셨습니다! 39는 최솟값입니다.
2차 시도
숫자를 예측해보세요 : 48
숫자를 맞추셨습니다! 48는 최댓값입니다.
3차 시도
숫자를 예측해보세요 : 100
숫자를 맞추셨습니다! 100는 최댓값입니다.
게임종료
3번 시도만에 예측 성공

...
5차 시도
숫자를 예측해보세요 : 9
9는 없습니다
최솟값은 9보다 작습니다
6차 시도
숫자를 예측해보세요 : 9
이미 예측에 사용한 숫자입니다
6차 시도
```

##### A3.
```python
import random

def get_false_list(length: int) -> list:
    false_list = []

    for i in range(length):
        false_list.append(False)

    return false_list

def get_target_numbers() -> list:
    target_numbers = []

    while len(target_numbers) < 3:
        number = random.randint(0, 100)

        is_duplicate = False

        for target_number in target_numbers:
            if number == target_numbers:
                is_duplicate = True

                break;

        if is_duplicate:
            continue

        target_numbers.append(number)

    target_numbers.sort()

    return target_numbers

def get_value(index: int) -> str:
    values = ["최솟값", "중간값", "최댓값"]

    return values[index]

def compare_target_number(target_number: int, guess_number: int) -> str:
    if target_number > guess_number:
        return "큽"

    return "작습"

def guess_numbers() -> int:
    count = 1

    is_guessed = get_false_list(101)
    is_checked = get_false_list(3)

    target_numbers = get_target_numbers()

    while True:
        print(f"{count}차 시도")
        
        guess_number = int(input("숫자를 예측해보세요: "))
        
        if is_guessed[guess_number]:
            print("이미 예측에 사용한 숫자입니다")
            
            continue

        is_correct = False

        for i in range(len(target_numbers)):
            if guess_number == target_numbers[i]:
                is_checked[i] = True

                value = get_value(i)

                print(f"숫자를 맞추셨습니다! {guess_number}는(은) {value}입니다.")

                is_correct = True

                break;

        if is_correct:
            if all(is_checked):
                return count

            continue

        print(f"{guess_number}는 없습니다")
            
        if not is_checked[0] and count > 5:
            compare = compare_target_number(target_numbers[0], guess_number)

            print(f"최솟값은 {guess_number}보다 {compare}니다")

        if not is_checked[-1] and count > 10:
            compare = compare_target_number(target_numbers[-1], guess_number)

            print(f"최댓값은 {guess_number}보다 {compare}니다")

        count += 1

        is_guessed[guess_number] = True

def solve_question():
    print("guess_numbers()")
    print()

    count = guess_numbers()
    
    print("게임종료")
    print(f"{count}차 시도만에 예측 성공")

solve_question()
```

---

##### Q4. 오늘 애인이 생겼다고 해봅시다. 100일을 기념하고 싶은데요.
- 조건1 - "오늘부터 1일"이기 때문에 날짜를 계산할 때 오늘을 포함합니다
- 조건2 - 몇년도인지 구분하지 않고 윤년도 고려하지 않고 2월은 무조건 28일로 합니다.
- hint
```python
# 특정 원소의 위치를 찾는 방법
a = [1,2,3,4]
a.index(1)
0
```
- 출력 예시
```python
after_100(6,21,"월")
6월 21일 월요일부터 100일 뒤는 9월 28일 화요일
```

##### A4.
```python
def after_100(month: int, date: int, day: str):
    dates = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    days = ["일", "월", "화", "수", "목", "금", "토"]

    target_month = month
    target_date = date + 99

    while target_date > dates[target_month]:
        target_month += 1
        target_date -= dates[target_month] 

    target_day = days[days.index(day) + 99 % 7]

    print(f"{month}월 {date}일 {day}요일부터 100일 뒤는 {target_month}월 {target_date}일 {target_day}요일")

def solve_question():
    print('after_100(6, 21, "월")')

    after_100(6, 21, "월")

solve_question()
```
