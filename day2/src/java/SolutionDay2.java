import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionDay2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/adventofcode/day2/src/resources/input"));
        int horizontal = 0, depth = 0, aim = 0;
        String direction;
        int unit;
        while (scanner.hasNext()) {
            direction = scanner.next();
            unit = scanner.nextInt();
            switch(direction) {
                case "forward":
                    horizontal += unit;
                    depth += aim * unit;
                    break;
                case "down":
                    aim += unit;
                    break;
                case "up":
                    aim -= unit;
                    break;
            }
        }
        System.out.println(horizontal * depth);
    }
}