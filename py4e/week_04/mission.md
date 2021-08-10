### 2021-08-09

# 4주차 미션

##### Q1. 우리는 큰 수를 나타낼 때 3자리마다 , 를 찍어서 구분해 줍니다. 파이썬에서는 아래와 같이 쉽게 나타낼 수 있습니다.
```python
# f"{숫자:,}"
print(f"{1000:,}")
```
##### 하지만 이번 미션에서는 숫자를 입력 받고 3자리마다 ,를 찍어주는
##### 함수를 만들어 봅시다.
##### 출력 예시
```python
make_comma(1000000)
1,000,000
```

##### A1.
```python
def make_comma(number: str) -> str:
    result = ""

    count = len(number) // 3
    header = len(number) % 3

    for i in range(0, header):
        result += number[i]

    for i in range(0, count):
        result += ","

        for j in range(0, 3):
            result += number[header + 3 * i + j]

    return result

def solve_question(number: str):
    print("make_comma({})".format(number))
    
    result = make_comma(number)
    
    print(result)

number = input("Input number: ")

solve_question(number)
```

---

##### Q2. 어느날 여러분이 어떤 글을 읽고 있는데, 갑자기 특정 글자가 전체 글에서 몇개 들어있는지 궁금해졌습니다. 그럼 한 번 파이썬 함수로 만들어 봅시다.
- 글은 어떤 글이 좋습니다. 인터넷에서 검색해서 복사 붙여넣기로 변수에 넣어 줍니다.
- 변수에 담긴 글을 함수에 넣어주면 txt 파일로 저장도 함께 되도록 해줍니다.
##### 출력 예시
```python
a ="""안녕하세요. 
반갑습니다. 파이썬 공부는 정말 재밌습니다.
"""

count_word(a, "습니다")
2
```

##### A2.
```python
def count_word(string: str, target: str) -> int:
    return string.count(target)

def save_file(string: str):
    fh = open("Q2.txt", "w")

    fh.write(string)

    fh.close()

def solve_question(string: str, target: str):
    result = count_word(string, target)

    print('a="""{}"""'.format(string))
    print()
    print('count_word(a, "{}")'.format(target))
    print(result)

    save_file(string)

a = """안녕하세요.
반갑습니다. 파이썬 공부는 정말 재밌습니다.
"""

solve_question(a, "습니다")
```

---

##### Q3. 요즘 식당에 들어가면 방명록을 적게 되어있습니다.
##### 어느 식당의 사장님이 여러분에게 방명록을 주면서 전화번호를 제대로 적었는지 검사해달라는 부탁을 했습니다.
##### 아래와 같은 방명록이 있을 때 방명록을 잘 못쓴 사람의 이름과 잘 못된 번호를 출력하는 함수를 만들어 봅시다.
```
김갑,123456789
이을,010-1234-5678
박병,010-5678-111
최정,111-1111-1111
정무,010-3333-3333
```
##### 출력 예시
```python
guest_book = """김갑,123456789
이을,010-1234-5678
박병,010-5678-111
최정,111-1111-1111
정무,010-3333-3333"""
wrong_guest_book(guest_book)

잘못 쓴 사람: 김갑
잘못 쓴 번호: 123456789

잘못 쓴 사람: 박병
잘못 쓴 번호: 010-5678-111

잘못 쓴 사람: 최정
잘못 쓴 번호: 111-1111-1111
```

##### A3.
```python
def write_file(string: str):
    fh = open("Q3.txt", "w")

    fh.write(string)
    
    fh.close()

def is_valid_tel(tel: str) -> bool:
    return tel.startswith("010") and tel[3] == "-" and tel[8] == "-" and len(tel) == 13

def wrong_guest_book(guest_book: str):
    write_file(guest_book)

    fh = open("Q3.txt")

    print('guest_book = """{}"""'.format(guest_book))
    print("wrong_guest_book(guest_book)")

    for line in fh:
        begin = line.find(",")

        tel = line[begin + 1 : ]

        if not is_valid_tel(tel):
            print("잘못 쓴 사람:", line[ : begin])
            print("잘못 쓴 번호:", tel)

guest_book = """김갑,123456789
이을,010-1234-5678
박병,010-5678-111
최정,111-1111-1111
정무,010-3333-3333"""

wrong_guest_book(guest_book)
```

---

##### Q4.  주민등록번호의 앞 6자리는 생년월일이고 뒷자리의 시작번호는 성별을 나타냅니다. 주민등록번호를 입력하면 몇년 몇월 생인지 그리고 남자인지 여자인지 출력하는 함수를 만들어 봅시다.
- 주민등록번호는 6자리 이후에 -로 구분되어야 하고 길이는 -포함 14임
- 뒷자리는 1,3 은 남자 2,4는 여자
- 00 ~ 21로 시작할 경우 2000년 이후 출생자인지 물어 볼 것 (맞으면 o 틀리면 x)
- 뒷자리 3, 4를 가질 수 있는 사람은 00년생 이후 출생자 밖에 없음
##### 주민등록번호 조건을 만족하지 않는 수가 입력되면 "잘 못된 번호입니다"를 출력해주세요.
##### 출력 예시
```python
a = "500629-2222222"
check_id(a)
50년06월 여자

a = "000629-2222222"
check_id(a)
2000년 이후 출생자 입니까? 맞으면 o 아니면 x : o
잘못된 번호입니다.
올바른 번호를 넣어주세요

a = "000629-2222222"
check_id(a)
2000년 이후 출생자 입니까? 맞으면 o 아니면 x : x
00년06월 여자
```

##### A4.
```python
def is_valid_length(rrn: str) -> bool:
    return len(rrn) == 14

def is_valid_character(rrn: str) -> bool:
    if rrn[6] != "-":
        return False

    for i in range (len(rrn)):
        if i == 6:
            continue

        if rrn[i] < "0" or rrn[i] > "9":
            return False

    return True

def is_valid_month(month: int) -> bool:
    return 1 <= month <= 12

def get_full_year(year:int) -> int:
    if year <= 21:
        is_after_two_thousand = ""

        while is_after_two_thousand not in ["o", "x"]:
            is_after_two_thousand = input("2000년 이후 출생자 입니까? 맞으면 o 아니면 x: ")

        if is_after_two_thousand == "o":
            return 2000 + year

    return 1900 + year

def is_leap_year(full_year: int) -> bool:
    if full_year % 4 != 0:
        return False

    if full_year % 100 == 0:
        return False

    if full_year % 400 != 0:
        return False

    return True

def is_valid_date(full_year:int, month:int, date: int) -> bool:
    if date < 1 or date > 31:
        return False

    if month == 2:
        if is_leap_year(full_year):
            return date <= 29

        return date <= 28

    if month in [1, 3, 5, 7, 8, 10, 12]:
        return date <= 31

    return date <= 30

def is_valid_sex(full_year:int, sex: int) -> bool:
    if full_year < 2000:
        return sex in [1, 2]

    return sex in [3, 4]

def is_valid(rrn: str) -> bool:
    if not is_valid_length(rrn) or not is_valid_character(rrn):
        return False

    year = int(rrn[0 : 2])
    full_year = get_full_year(year)
    month = int(rrn[2 : 4])
    date = int(rrn[4 : 6])
    sex = int(rrn[7])

    return is_valid_month(month) and is_valid_date(full_year, month, date) and is_valid_sex(full_year, sex)

def get_sex(sex: int) -> str:
    if sex in [1, 3]:
        return "남자"

    return "여자"

def check_id(rrn: str) -> str:
    result = """잘못된 번호입니다.
올바른 번호를 넣어주세요"""

    if is_valid(rrn):
        year = rrn[0 : 2]
        month = rrn[2 : 4]
        sex_number = int(rrn[7])
        sex = get_sex(sex_number)

        result = year + "년 " + month + "월 " + sex
    
    return result

def solve_question(rrn: str):
    print('a = "{}"'.format(rrn))
    print("check_id(a)")

    result = check_id(rrn)

    print(result)

rrn = input("Input resident registration number: ")

solve_question(rrn)
```
