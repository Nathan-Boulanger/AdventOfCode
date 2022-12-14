def main():
    file = open('day1/input.txt', 'r')
    lines = file.readlines()
    stacked_calories = []
    current_calories = 0

    for line in lines:
        if line.strip():
            current_calories += int(line)
        else:
            stacked_calories.append(current_calories)
            current_calories = 0

    stacked_calories = sorted(stacked_calories, reverse=True)
    print(sum(stacked_calories[0:3]))


main()
