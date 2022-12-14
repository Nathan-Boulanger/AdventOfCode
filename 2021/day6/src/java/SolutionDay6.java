import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolutionDay6 {
    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("\nPart One : " + partOne());
        System.out.println("\nPart Two : " + partTwo());
    }

    private static Integer partOne() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day6/src/resources/input"));
        ArrayList<Integer> fishList = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        scanner.close();

        System.out.println("After 0 days (size:"+fishList.size()+") : " + fishList);
        for (int day = 1; day <= 80; day++) {
            for (int i = 0; i < fishList.size(); i++) {
                if (fishList.get(i) != 0) {
                    fishList.set(i, fishList.get(i)-1);
                }
                else {
                    fishList.set(i, 6);
                    fishList.add(9);
                }
            }
            if (day < 18 )
                System.out.println("After " + day + " days (size:"+fishList.size()+") : " + fishList);
        }

        return fishList.size();
    }

    private static Long partTwo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day6/src/resources/input"));
        int[] fishList = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        scanner.close();

        HashMap<Integer, Long> fishMap = new HashMap<>();
        for (int i = 0; i < 9; i++)
            fishMap.put(i, 0L);
        for (int i : fishList)
            fishMap.put(i, fishMap.get(i)+1);

        Long numStep0;
        System.out.println("start : " + fishMap);
        for (int day = 1; day <= 256; day++) {
            numStep0 = fishMap.get(0);
            fishMap.put(0, 0L);
            for (int i = 1; i <= 8; i++) {
                fishMap.put(i-1, fishMap.get(i));
                fishMap.put(i, 0L);
            }
            fishMap.put(6, fishMap.get(6)+numStep0);
            fishMap.put(8, fishMap.get(8)+numStep0);
        }

        return fishMap.values().stream().reduce(0L, Long::sum);
    }
}