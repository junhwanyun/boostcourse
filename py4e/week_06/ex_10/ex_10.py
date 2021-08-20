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

words_count = [(value, key) for key, value in dictionary.items()]
sorted_words_count = sorted(words_count, reverse=True)

for value, key in sorted_words_count[ : 5]:
    print(key, value)
