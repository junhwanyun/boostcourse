def calculatePay(hours, rate):
    # print("In colculating", hours, rate)
    
    if hoursf > 40:
        regularPay = hours * rate;
        overtimePay = (hours - 40) * (rate * 0.5)
        
        pay = regularPay + overtimePay
    else:
        pay = hours * rate

    # print("Returning", pay)

    return pay;

hours = input("Enter hours: ")
rate = input("Enter rate: ")

hoursf = float(hours)
ratef = float(rate)

pay = calculatePay(hoursf, ratef)

print("Pay:", pay)
