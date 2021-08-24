### 2021-08-23

# 6주차 미션

##### Q1. 역사 문제를 하나 내보겠습니다. 고려시대와 조선시대 왕 이름 중에서 고려에도 있고 조선에도 있는 이름은 몇개 일까요? 한 번에 딱 안 떠오른다면 왕 이름을 드릴테니 파이썬 함수로 만들어서 출력 해봅시다.
- 조건1 - 중복되는 왕 이름 출력
- 조건2 - 중복되는 왕 이름의 수 출력
```python
# 왕이름
korea_king = "태조,혜종,정종,광종,경종,성종,목종,현종,덕종,정종,문종,순종,선종,헌종,숙종,예종,인종,의종,명종,신종,희종,강종,고종,원조,충렬왕,충선왕,충숙왕,충혜왕,충목왕,충정왕,공민왕,우왕,창왕,공양왕"
chosun_king = "태조,정종,태종,세종,문종,단종,세조,예종,성종,연산군,중종,인종,명종,선조,광해군,인조,효종,현종,숙종,경종,영조,정조,순조,헌종,철종,고종,순종"
```
- 출력 예시
```python
king(korea_king, chosun_king)
조선과 고려에 모두 있는 왕 이름 : 태조
조선과 고려에 모두 있는 왕 이름 : 정종
조선과 고려에 모두 있는 왕 이름 : 경종
조선과 고려에 모두 있는 왕 이름 : 성종
조선과 고려에 모두 있는 왕 이름 : 현종
조선과 고려에 모두 있는 왕 이름 : 문종
조선과 고려에 모두 있는 왕 이름 : 순종
조선과 고려에 모두 있는 왕 이름 : 헌종
조선과 고려에 모두 있는 왕 이름 : 숙종
조선과 고려에 모두 있는 왕 이름 : 예종
조선과 고려에 모두 있는 왕 이름 : 인종
조선과 고려에 모두 있는 왕 이름 : 명종
조선과 고려에 모두 있는 왕 이름 : 고종
조선과 고려에 모두 있는 왕 이름은 총 13개 입니다
```

##### A1.
```python
def king(korea_king: str, chosun_king: str) -> int:
    result = 0

    korea_kings = korea_king.split(",")
    chosun_kings = chosun_king.split(",")

    dictionary = dict()

    for king in korea_kings + chosun_kings:
        dictionary[king] = dictionary.get(king, 0) + 1

    for key, value in dictionary.items():
        if value > 1:
            result += 1

            print(f"조선과 고려에 모두 있는 왕 이름: {key}")

    return result

def solve_question():
    # 왕이름
    korea_king = "태조,혜종,정종,광종,경종,성종,목종,현종,덕종,정종,문종,순종,선종,헌종,숙종,예종,인종,의종,명종,신종,희종,강종,고종,원조,충렬왕,충선왕,충숙왕,충혜왕,충목왕,충정왕,공민왕,우왕,창왕,공양왕"
    chosun_king = "태조,정종,태종,세종,문종,단종,세조,예종,성종,연산군,중종,인종,명종,선조,광해군,인조,효종,현종,숙종,경종,영조,정조,순조,헌종,철종,고종,순종"
    
    print("king(korea_king, chosun_king)")

    count = king(korea_king, chosun_king)\

    print(f"조선과 고려에 모두 있는 왕 이름은 총 {count}개 입니다")

solve_question()
```

---

##### Q2.  여러분은 6명의 멤버를 거느리는 영업팀의 영업관리자 입니다. 각 멤버별로 올해 실적을 보고 잘한 멤버는 보너스를 주고 못한 멤버는 면담을 하려고 합니다. 파이썬을 이용하여 함수를 만들어 보너스 대상자와 면담 대상자를 골라주세요.
- 조건 1 - 예비 보너스 대상자는 평균 실적 1등 2등 입니다.
- 조건 2 - 예비 면담 대상자는 평균 실적 5등 6등 입니다.
- 조건 3 - 보너스 대상자의 평균 실적이 5보다 크지 않으면 보너스 대상자에서 제외 됩니다.
- 조건 4 - 면담 대상자의 평균 실적이 3보다 크면 면담 대상자에서 제외 됩니다.
```python
# 이름, 실적
member_names = ["갑돌이", "갑순이", "을돌이", "을순이", "병돌이", "병순이"]
member_records = [[4,5,3,5,6,5,3,4,1,3,4,5],[2,3,4,3,1,2,0,3,2,5,7,2], 
    [1,3,0,3,3,4,5,6,7,2,2,1],[3,2,9,2,3,5,6,6,4,6,9,9],
    [8,7,7,5,6,7,5,8,8,6,10,9],[7,8,4,9,5,10,3,3,2,2,1,3]]
```
- 출력 예시
```python
sales_management(member_names, member_records)
보너스 대상자 병돌이
보너스 대상자 을순이

면담 대상자 갑순이
```

##### A2.
```python
def sales_management(member_names: list, member_records: list):
    average_records = []

    for member_record in member_records:
        average_records.append(sum(member_record) / len(member_record))

    dictionary = dict()

    for i in range(len(member_names)):
        dictionary[member_names[i]] = average_records[i]

    rank = sorted([(value, key) for key, value in dictionary.items()], reverse = True)

    for value, key in rank[ : 2]:
        if value > 5:
            print(f"보너스 대상자 {key}")

    print()

    for value, key in rank[5 : ]:
        if value <= 3:
            print(f"면담 대상자 {key}")

def solve_question():
    # 이름, 실적
    member_names = ["갑돌이", "갑순이", "을돌이", "을순이", "병돌이", "병순이"]
    member_records = [[4,5,3,5,6,5,3,4,1,3,4,5],[2,3,4,3,1,2,0,3,2,5,7,2], 
        [1,3,0,3,3,4,5,6,7,2,2,1],[3,2,9,2,3,5,6,6,4,6,9,9],
        [8,7,7,5,6,7,5,8,8,6,10,9],[7,8,4,9,5,10,3,3,2,2,1,3]]

    print("sales_management(member_names, member_records)")

    sales_management(member_names, member_records)

solve_question()
```

---

##### Q3. 예금 금리가 너무 낮아서 주식을 시작했습니다. 아래와 같이 매수한 종목 이름, 수량, 매수 평균 금액이 있습니다. 판매가는 따로 주어집니다. 종목과 수익률만 출력하시고 종목별 수익률이 높은 순서대로 출력해주세요. (소수 둘째자리까지 출력)
- 조건1 - 숫자는 0 ~ 100까지 숫자를 3개 만듭니다(중복 불가).
- 조건2 - 5회, 10회까지 정답을 못맞추면 최솟값, 최대값에 대한 힌트를 줍니다.
- 조건3 - 정답을 맞추면, 맞춘 정답이 최솟값인지, 중간값인지, 최댓값인지 알려줍니다.
```python
stocks = "삼성전자/10/85000,카카오/15/130000,LG화학/3/820000,NAVER/5/420000"
sells = [82000, 160000, 835000, 410000]
```
```python
# 소수 둘째자리까지 출력하는 방법
a = 3.141592
print(f"{a:.3}")
3.14
```
- 출력 예시
```python
stock_profit(stocks, sells)
카카오의 수익률 23.1
LG화학의 수익률 1.83
NAVER의 수익률 -2.38
삼성전자의 수익률 -3.53
```

##### A3.
```python
def stock_profit(stocks: str, sells: list):
    name_count_buys = stocks.split(",")

    dictionary = dict()

    for i in range(len(sells)):
        details = name_count_buys[i].split("/")

        dictionary[details[0]] = (sells[i] - int(details[-1])) * 100 / int(details[-1])

    rank = sorted([(value, key) for key, value in dictionary.items()], reverse = True)

    for value, key in rank:
        print(f"{key}의 수익률 {value: .2f}")

def solve_question():
    stocks = "삼성전자/10/85000,카카오/15/130000,LG화학/3/820000,NAVER/5/420000"
    sells = [82000, 160000, 835000, 410000]

    print("stock_profit(stocks, sells)")

    stock_profit(stocks, sells)

solve_question()
```

---

##### Q4. 여러분은 어떤 상품을 판매하고 있습니다. 매월 상품을 많이 구매해준 VIP회원에게 할인 쿠폰을 제공해주려고 합니다. 아래와 같은 회원 정보가 있을 때 회원 정보를 출력하고 할인 쿠폰을 받을 회원이 누구인지 출력하는 함수를 만들어 주세요.
- 조건1 - 8회 이상 구매한 회원이 VIP대상
- 조건2 - 전화번호가 없으면 쿠폰을 받을 수 없음
- 조건3 - 전화번호가 없으면 000-0000-0000으로 출력할 것
```python
# 6명의 회원이고 "아이디,나이,전화번호,성별,지역,구매횟수" 순서로 입력되어 있음
info = "abc,21세,010-1234-5678,남자,서울,5,cdb,25세,x,남자,서울,4,bbc,30세,010-2222-3333,여자,서울,3,ccb,29세,x,여자,경기,9,dab,26세,x,남자,인천,8,aab,23세,010-3333-1111,여자,경기,10"
```
- 출력 예시
```python
good_customer(info)
{'아이디': ['abc', 'cdb', 'bbc', 'ccb', 'dab', 'aab'], '나이': ['21세', '25세', '30세', '29세', '26세', '23세'], '전화번호': ['010-1234-5678', '000-0000-0000', '010-2222-3333', '000-0000-0000', '000-0000-0000', '010-3333-1111'], '성별': ['남자', '남자', '여자', '여자', '남자', '여자'], '지역': ['서울', '서울', '서울', '경기', '인천', '경기'], '구매횟수': [5, 4, 3, 9, 8, 10]}
할인 쿠폰을 받을 회원정보 아이디:aab, 나이:23세, 전화번호:010-3333-1111, 성별:여자, 지역:경기, 구매횟수: 10
```

##### A4.
```python
def good_customer(info: str):
    informations = info.split(",")

    dictionary = dict()

    keys = ["아이디", "나이", "전화번호", "성별", "지역", "구매횟수"]

    max_count = 0

    for i in range(len(informations)):
        key = keys[i % 6]
        
        if key == "아이디":
            is_tel = True

        if key == "전화번호" and informations[i] == "x":
            informations[i] = "000-0000-0000"

            is_tel = False

        if key == "구매횟수" and is_tel and int(informations[i]) > max_count:
                max_count = int(informations[i])
        
        dictionary[key] = dictionary.get(key, []) + [informations[i]]

    print(dictionary)

    index = dictionary["구매횟수"].index(str(max_count))

    good_customer_information = ""
    
    for i in dictionary:
        good_customer_information += i + ":" + dictionary[i][index] + ", "

    print("할인 쿠폰을 받을 회원정보", good_customer_information[ : -2])

def solve_question():
    # 6명의 회원이고 "아이디,나이,전화번호,성별,지역,구매횟수" 순서로 입력되어 있음
    info = "abc,21세,010-1234-5678,남자,서울,5,cdb,25세,x,남자,서울,4,bbc,30세,010-2222-3333,여자,서울,3,ccb,29세,x,여자,경기,9,dab,26세,x,남자,인천,8,aab,23세,010-3333-1111,여자,경기,10"

    print("good_customer(info)")

    good_customer(info)

solve_question()
```
