### 2021-07-19

# 1주차 미션

##### Q1. 파이썬으로 컴퓨터에게 우리가 원하는 일을 시킬 수 있다고 하였습니다.
##### 파이썬으로 할 수 있는 일은 어떤 것들이 있고, 나는 그중에서 무엇을 하고 싶은지 적어봅시다.

```
웹 프로그래밍, 수치 연산, 데이터 분석 등
프로젝트 데이터 분석 폴리글랏 프로그래밍 적용
```

##### Q2. 파이썬 코딩을 하기에 앞서 하드웨어를 이해하는 것이 중요하다고 했습니다.
##### 하드웨어 아키텍쳐에서 CPU와 Main Memory 그리고 Secondary Memory의 역할을 간단하게 정리하여 봅시다.

```
CPU: 연산 수행
Main Memory: 프로세서가 현재 작업 중 데이터와 명령 일시적으로 저장
Secondary Memory: 메인 메모리에 전달할 내용물 저장
```

##### Q3. 파이썬은 우리의 명령을 이해하지 못했을 때, 친절하게 Error Message를 통해 어떤 명령을 이해하지 못했는지 알려줍니다. 그것을 보고 코드의 버그를 수정해가는 과정을 Debugging이라고 합니다. 이것은 코딩에 있어서 매우 중요합니다.
##### 따라서, Error Message에 대해서 이해하는 시간을 가져봅시다.
##### 강의에서는 SyntaxError, ValueError, TypeError 3가지가 등장했습니다.
##### ①각각의 Error를 발생시키는 코드를 2가지씩 만들어보고
##### ②Debugging한 코드도 만들어 봅시다.
##### ③그리고 그 밖에 다른 Error도 3가지를 찾아 그 Error를 발생시키는 코드와
##### ④Debugging한 코드를 1가지씩 만들어 봅시다.

```
①
SyntaxError: ., /
ValueError: int("a"), float(".")
TypeError: "a" + 1, a = 1; a[0]
②
SyntaxError:  ,
ValueError: int("1"), float("1")
TypeError: "a" + "1", a = 1; a
③
IndexError: q = [1]; q[1]
ZeroDivisionError: 1 / 0
NameError: a
④
IndexError: q = [1]; q[0]
ZeroDivisionError: 1 / 1
NameError: a = 1; a
```

##### Q4. 강의에서 미국과 유럽의 엘리베이터 층수를 변환하는 프로그램이 나왔습니다.
##### 그와 비슷하게 우리는 한국 나이를 미국 나이로 변환하는 프로그램을 코딩 해봅시다.
- hint: 미국 나이는 생일이 지났는지 안지났는지가 중요하죠!
  - birth = int(input("생일이 지났습니까? 맞으면 0 아니면 -1 : "))

```
birth = input("Input 0 if birth has passed, -1 if not: ")
korean = input("Input korean age: ")
print("American age:", int(korean) + int(birth))
```
