def main():
    file = open('input.txt', 'r')
    lines = file.readlines()
    sum = 0

    rock = 1
    paper = 2
    scissors = 3

    win = 6
    draw = 3
    lose = 0

    for line in lines:
        if line[0] == 'A': # Rock
            if line[2] == 'X': # Lose
                sum += lose + scissors
            if line[2] == 'Y': # Draw
                sum += draw + rock
            if line[2] == 'Z': # Win
                sum += win + paper
        elif line[0] == 'B': # Paper
            if line[2] == 'X': # Lose
                sum += lose + rock
            if line[2] == 'Y': # Draw
                sum += draw + paper
            if line[2] == 'Z': # Win
                sum += win + scissors
        elif line[0] == 'C': # Scissors
            if line[2] == 'X': # Lose
                sum += lose + paper
            if line[2] == 'Y': # Draw
                 sum += draw + scissors
            if line[2] == 'Z': # Win
                sum += win + rock

    print(sum)

main()
