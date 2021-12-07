import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/adventofcode/day1/src/resources/input"));
        int count = 0;
        int[] window = new int[3];
        window[0] = Integer.parseInt(scanner.next());
        window[1] = Integer.parseInt(scanner.next());
        window[2] = Integer.parseInt(scanner.next());
        int index = 0;
        int lastWindow = Arrays.stream(window).sum();
        int currWindow;
        while (scanner.hasNext()) {
            window[index%3] = Integer.parseInt(scanner.next());
            currWindow = Arrays.stream(window).sum();
            if (currWindow > lastWindow) count++;
            lastWindow = currWindow;
            index++;
        }
        System.out.println(count);
    }
}