import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SolutionDay5 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nPart One : " + partOne());
        System.out.println("\nPart Two : " + partTwo());
    }

    private static Integer partOne() throws FileNotFoundException {
        ArrayList<Pair<Pair<Integer>>> matrix = parseFile();

        int[][] map = new int[10][10];
        Pair<Integer> firstP, secondP;
        for (Pair<Pair<Integer>> line : matrix) {
            firstP = line.getFirst();
            secondP = line.getSecond();
            map = drawLine(firstP, secondP, map);
        }
        printMap(map);

        return calculateDangerousArea(map);
    }

    private static Integer calculateDangerousArea(int[][] map) {
        int count = 0;
        for (int[] line : map) {
            for (int cell : line) {
                if (cell >= 2) count++;
            }
        }
        return count;
    }

    private static Integer partTwo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day4/src/resources/input"));

        scanner.close();
        return null;
    }

    private static ArrayList<Pair<Pair<Integer>>> parseFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day5/src/resources/example"));

        ArrayList<Pair<Pair<Integer>>> matrix = new ArrayList();

        Pair<Integer> firstPair, secondPair;
        String currLine;
        while (scanner.hasNext()) {
            currLine = scanner.next();
            firstPair = new Pair(Integer.valueOf(currLine.split(",")[0]), Integer.valueOf(currLine.split(",")[1]));
            scanner.next("->");
            currLine = scanner.next();
            secondPair = new Pair(Integer.valueOf(currLine.split(",")[0]), Integer.valueOf(currLine.split(",")[1]));
            matrix.add(new Pair<>(firstPair, secondPair));
        }
        scanner.close();
        return matrix;
    }

    private static int[][] drawLine(Pair<Integer> firstP, Pair<Integer> secondP, int[][] matrix) {
        Integer x1 = firstP.getFirst(), y1 = firstP.getSecond();
        Integer x2 = secondP.getFirst(), y2 = secondP.getSecond();
        if (x1 == x2) {
            int minY = (y1 < y2 ? y1 : y2), maxY = (y1 > y2 ? y1 : y2);
            for (int y = minY; y <= maxY; y++) {
                matrix[y][x1]++;
            }
        } else if (y1 == y2) {
            int minX = (x1 < x2 ? x1 : x2), maxX = (x1 > x2 ? x1 : x2);
            for (int x = minX; x <= maxX; x++) {
                matrix[y1][x]++;
            }
        }
        return matrix;
    }

    private static void printMap(int[][] map) {
        for (int[] line : map) {
            for (int number : line) {
                if (number==0) System.out.print(".");
                else System.out.print(number);
            }
            System.out.println();
        }
    }
}