### 2021-07-26

# 2주차 미션

##### Q1. 컴퓨터와 함께하는 가위바위보 게임을 만들어봅시다!
- 조건1 : 함수의 인자로는 나의 가위바위보 선택이 들어감
  - (0, 1 ,2 혹은 "가위", "바위", "보" 로 입력할 수 있습니다. - 총 6가지 방법으로 넣을 수 있음)
- 조건2 : 누가 무엇을 냈고, 누가 승리 했는지 출력이 되어야 함
- hint: 컴퓨터가 가위바위보 하게 만드는 법
```python
# 아래의 코드를 추가하면 됩니다
import random
# 0 ~ 2 숫자를 랜덤으로 뽑아내는 코드
computer = random.randint(0, 2)ㅑ
```
##### 출력 예시
```python
# rsp == rock scissors paper
my = input("가위 바위 보")
rcp(my)

# 출력
나: 가위
컴퓨터: 바위
컴퓨터 승리!
```

##### A1.
```python
import random

def string2integer(string):
    if string == "가위":
        return 0

    if string == "바위":
        return 1

    return 2

def integer2string(integer):
    if integer == 0:
        return "가위"

    if integer == 1:
        return "바위"

    return "보"

def rsp(my):
    computer = random.randint(0, 2)
    
    if my == "0" or my == "1" or my == "2":
        user = int(my)
    else:
        user = string2integer(my)

    print("나:", integer2string(user))
    print("컴퓨터:", integer2string(computer))

    if user - computer == 0:
        print("무승부!")
        return;

    if user - computer == 1 or user - computer == -2:
        print("나 승리!")
        return;

    print("컴퓨터 승리!")

my = input("가위 바위 보: ")

rsp(my)
```

---

##### Q2. 월급을 입력하면 연봉을 계산해주는 계산기를 만들어 봅시다. 세전 연봉과 세후 연봉을 함께 출력하도록 해봅니다.
##### 아래의 세율 표를 토대로 만들어주세요(단, 실제 세율과 다를 수 있습니다!)
![image](https://user-images.githubusercontent.com/59013440/126980104-d3bd4249-2411-4b65-88f9-0d493007088d.png)
##### 출력 예시
```python
# 월급 입력
monthly_payment = 300
yearly_payment(monthly_payment)

# 출력
세전 연봉: 3600만원
세후 연봉: 3060만원
```

##### A2.

```python
def yearly_payment(monthly_payment):
    salary = int(monthly_payment)

    gross = calculateGross(salary)
    net = calculateNet(gross)

    if net - int(net) == 0:
        net = int(net)

    print("세전 연봉: ", gross, "만원", sep = '')
    print("세후 연봉: ", net, "만원", sep = '')

def calculateGross(salary):
    return salary * 12

def calculateNet(gross):
    if gross <= 1200:
        return gross * 0.96

    if gross <= 4800:
        return gross * 0.85

    if gross <= 8800:
        return gross * 0.76

    if gross <= 15000:
        return gross * 0.65

    if gross <= 30000:
        return gross * 0.62

    if gross <= 50000:
        return gross * 0.6

    return gross * 0.58

monthly_payment = input("monthly_payment = ")
yearly_payment(monthly_payment)
```

---

##### Q3. 학생 이름과 점수를 입력하면 학점을 출력하는 학점 변환기를 만들어 봅시다.
##### 이름과 점수, 학점 모두 출력하도록 해봅니다.
##### 아래의 학점표를 토대로 만들어주세요
![image](https://user-images.githubusercontent.com/59013440/126980312-71d8e053-9463-4996-af04-fde0a2b4657e.png)
##### 출력 예시
```python
# 이름과 점수 입력
grader("이호창", 99)

# 출력
학생이름 : 이호창
점수 : 99점
학점 : A+
```

##### A3.

```python
def grader(name, score):
    grade = getGrade(score)

    print("학생이름:", name)
    print("점수: ", score, "점", sep = '')
    print("학점:", grade)

def getGrade(score):
    if score >= 95:
        return "A+"

    if score >= 90:
        return "A"

    if score >= 85:
        return "B+"

    if score >= 80:
        return "B"

    if score >= 75:
        return "C+"

    if score >= 70:
        return "C"

    if score >= 65:
        return "D+"

    if score >= 60:
        return "D"

    return "F"

name = input("학생이름: ")
score = input("점수: ")

grader(name, int(score))
```

---

##### Q4. 나이와 현금 또는 카드를 입력하면 버스 요금이 출력되는 버스 요금 계산기를 만들어봅시다.
##### 아래의 요금표를 토대로 만들어주세요
![image](https://user-images.githubusercontent.com/59013440/126981895-d2acfe57-b421-43e1-baca-c6eccf35866d.png)
##### 출력 예시
```python
# 버스 요금 입력
bus_fare(30, "현금")

# 출력
나이: 30세
지불유형: 현금
버스요금: 1300원
```

##### A4.

```python
def bus_fare(age, payment):
    fare = getFare(age, payment)

    print("나이: ", age, "세", sep = '')
    print("지불유형:", payment)
    print("버스요금: ", fare, "원", sep = '')

def getFare(age, payment):
    if age < 8 or age >= 75:
        return 0

    if age < 14:
        return 450

    if age < 20:
        if payment == "카드":
            return 720

        return 1000

    if payment == "카드":
        return 1200

    return 1300

age = input("나이: ")
payment = input("지불유형: ")

bus_fare(int(age), payment)
```
