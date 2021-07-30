count = 0
total = 0.0

while True:
    numbers = input("Enter a number: ")

    if numbers == "done":
        break

    try:
        number = float(numbers)
    except:
        print("Invalid input")
        
        continue

    # print(number)

    count += 1
    total += number

# print("All Done")
print(total, count, total / count)
