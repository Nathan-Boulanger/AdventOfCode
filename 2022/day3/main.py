import string


def main():
    file = open('input.txt', 'r')
    lines = file.readlines()
    sum = 0

    for line in lines:
        line = line.strip()
        first_sack = line[:len(line)//2]
        second_sack = line[len(line)//2:]

        for char in first_sack:
            if char in second_sack:
                sum += string.ascii_letters.index(char) + 1
                break

    print(sum)

main()
