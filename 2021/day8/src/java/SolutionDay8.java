import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionDay8 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nPart One : " + partOne());
        System.out.println("\nPart Two : " + partTwo());
    }

    private static Integer partOne() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day9/src/resources/input"));
        int[] input = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int min = Arrays.stream(input).min().getAsInt();
        int max = Arrays.stream(input).max().getAsInt();

        int minFuel = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int totalFuelForI = 0;
            for (Integer value : input) {
                totalFuelForI += Math.abs(value - i);
            }
            if (totalFuelForI < minFuel)
                minFuel = totalFuelForI;
        }

        return minFuel;
    }

    private static Integer partTwo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day8/src/resources/input"));
        int[] input = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        
        int min = Arrays.stream(input).min().getAsInt();
        int max = Arrays.stream(input).max().getAsInt();

        int minFuel = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int totalFuelForI = 0;
            for (Integer value : input) {
                int dist = Math.abs(value - i);
                totalFuelForI += (dist*(dist+1))/2;
            }
            if (totalFuelForI < minFuel)
                minFuel = totalFuelForI;
        }

        return minFuel;
    }
}