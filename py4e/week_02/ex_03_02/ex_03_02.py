hours = input("Enter hours: ")
rate = input("Enter rate: ")

try:
    hoursf = float(hours)
    ratef = float(rate)
except:
    print("Error, please enter numeric input")
    quit()

# print(hoursf, ratef)

if hoursf > 40:
    # print("Overtime")

    regularPay = hoursf * ratef;
    overtimePay = (hoursf - 40) * (ratef * 0.5)

    # print (regularPay, overtimePay)

    pay = regularPay + overtimePay
else:
    # print("Regular")
    pay = hoursf * ratef

print("Pay:", pay)
