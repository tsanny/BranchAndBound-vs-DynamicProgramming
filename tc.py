import random

def generate_set(length, name, range_max):
    text = ""
    file = open(name, "w")
    unique_numbers = set()

    while len(unique_numbers) < length:
        num = random.randint(1000, range_max)
        if num not in unique_numbers:
            unique_numbers.add(num)
            text += str(num) + "\n"

    file.write(text.strip())
    file.close()

generate_set(10, "small.txt", 5000)
generate_set(40, "medium.txt", 5000)
generate_set(80, "large.txt", 5000)
