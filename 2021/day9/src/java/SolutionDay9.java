import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SolutionDay9 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nPart One : " + partOne());
        System.out.println("\nPart Two : " + partTwo());
    }

    private final static int XDIM = 100, YDIM = 100;

    private static Long partOne() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day9/src/resources/input"));
        int[][] map = new int[XDIM][YDIM];
        int i = 0, j;
        while (scanner.hasNext()) {
            String line = scanner.next();
            j = 0;
            for (char c : line.toCharArray())
                map[i][j++] = Character.getNumericValue(c);
            i++;
        }
        scanner.close();

        Long sum = 0L;
        for (i = 0; i < XDIM; i++) {
            for (j = 0; j < YDIM; j++)
                if (isLowPoint(map, i, j)) sum += map[i][j]+1;
        }


        for (i = 0; i < XDIM; i++) {
            for (j = 0; j < YDIM; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        return sum;
    }

    private static boolean isLowPoint(int[][] map, int x, int y) {
        int currValue = map[x][y];
        boolean isLow = true;
        if (x != 0 && map[x-1][y] <= currValue) isLow = false;
        else if (y != 0 && map[x][y-1] <= currValue) isLow = false;
        else if (y != YDIM-1 && map[x][y+1] <= currValue) isLow = false;
        else if (x != XDIM-1 && map[x+1][y] <= currValue) isLow = false;
        return isLow;
    }

    private static Integer partTwo() throws FileNotFoundException {
        return null;
    }
}