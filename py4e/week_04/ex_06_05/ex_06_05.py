str = 'X-DSPAM-Confidence: 0.8475 '

colon_index = str.find(" ")

number = str[colon_index + 1 : ]
result = float(number)

print(result)
