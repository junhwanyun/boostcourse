fh = open("text.txt")

print(fh)

for line in fh:
    line = line.rstrip()
    
    print(line)
