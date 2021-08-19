fname = input("Enter file: ")

if len(fname) < 1:
    fname = "clown.txt"

fhand = open(fname)

dictionary = dict()

for line in fhand:
    line = line.rstrip()
    
    words = line.split()
    
    for word in words:
        # Idiom: retrieve/create/update counter
        dictionary[word] = dictionary.get(word, 0) + 1

# Now we wont to find the most common word
max_word = None
max_count = 0

for key, value in dictionary.items():
    if value > max_count:
        max_word = key
        max_count = value

print(max_word, max_count)
