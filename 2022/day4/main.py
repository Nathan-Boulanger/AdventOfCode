import string

# Read the input from file
with open("input.txt", "r") as f:
    lines = [line.strip() for line in f]

    sum_of_cumulative = 0

for line in lines:
    repartitions = line.split(',')
    sections = []
    for repartition in repartitions:
        sections.append([int(n) for n in repartition.split('-')])
    print(sections)
    if (sections[1][0] <= sections[0][0] <= sections[1][1]) or (sections[0][0] <= sections[1][1] <= sections[0][1]) or(
            sections[1][0] <= sections[0][1] <= sections[1][1]) or (sections[0][0] <= sections[1][0] <= sections[0][1]):
        sum_of_cumulative += 1

print(sum_of_cumulative)

print("=================")
def count_overlaps(assignments):
    count = 0
    for assignment in assignments:
        sections = [[int(n) for n in section.split('-')] for section in assignment.split(',')]
        condition_1 = sections[0][0] <= sections[1][1] or sections[0][1] >= sections[1][0]
        condition_2 = sections[1][0] <= sections[0][1] or sections[1][1] >= sections[0][0]
        if any([condition_1, condition_2]):
            count += 1
    return count

print(count_overlaps((lines)))