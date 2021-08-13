fh = open("test.txt")

for line in fh:
    line = line.rstrip()
    
    words = line.split()
    
    # Guardian in a compound statement
    if len(words) < 3 or words[0] != "From":
        continue

    print(words[2])
