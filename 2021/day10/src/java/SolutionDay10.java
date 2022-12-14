import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SolutionDay10 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nPart One : " + partOne());
        System.out.println("\nPart Two : " + partTwo());
    }

    private static Long partOne() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day10/src/resources/input"));

        String line;
        Stack<Character> currLineStack;
        int counter = 0;
        boolean corrupted;
        ArrayList<Long> listCount = new ArrayList<>();
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            currLineStack = new Stack<>();
            corrupted = false;
            for (Character currChar : line.toCharArray()) {
                if (currChar == '(' || currChar == '[' || currChar == '<' || currChar == '{')
                    currLineStack.push(currChar);
                else {
                    switch (currChar) {
                        case '}':
                            if (currLineStack.pop() != '{') {
                                corrupted = true;
                                break;
                            }
                            break;
                        case '>':
                            if (currLineStack.pop() != '<') {
                                corrupted = true;
                                break;
                            }
                            break;
                        case ']':
                            if (currLineStack.pop() != '[') {
                                corrupted = true;
                                break;
                            }
                            break;
                        case ')':
                            if (currLineStack.pop() != '(') {
                                corrupted = true;
                                break;
                            }
                            break;
                    }
                }
            }
            if (!corrupted) {
                long count = 0;
                while (currLineStack.size() != 0) {
                    count *= 5;
                    switch (currLineStack.pop()) {
                        case '[':
                            count += 2;
                            break;
                        case '(':
                            count++;
                            break;
                        case '{':
                            count += 3;
                            break;
                        case '<':
                            count += 4;
                            break;
                    }
                }
                listCount.add(count);
            }
        }
        Collections.sort(listCount);
        scanner.close();
        System.out.println("\n" + listCount.size() + " - middle : " + listCount.size()/2);
        System.out.println(listCount);
        return listCount.get(listCount.size()/2);
    }

    private static Integer partTwo() throws FileNotFoundException {
        return null;
    }
}