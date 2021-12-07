import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolutionDay3 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(partTwo());
    }

    private static Integer partTwo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/adventofcode/day3/src/resources/input"));
        ArrayList<String> fullTable = new ArrayList<>();
        while (scanner.hasNext())
            fullTable.add(scanner.next());

        String oxygenRating = "", co2 = "";
        int oxygenListSum, co2ListSum;
        char mostCommonAtI, leastCommonAtI;
        List<String> oxygenList = new ArrayList<>(fullTable), co2List = new ArrayList<>(fullTable);
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            oxygenListSum = oxygenList.stream().mapToInt(line -> {
                if (line.charAt(finalI) == '0')
                    return -1;
                return 1;
            }).sum();

            co2ListSum = co2List.stream().mapToInt(line -> {
                if (line.charAt(finalI) == '0')
                    return -1;
                return 1;
            }).sum();

            mostCommonAtI = (oxygenListSum >= 0 ? '1' : '0');
            leastCommonAtI = (co2ListSum >= 0 ? '0' : '1');
            char finalMostCommonAtI = mostCommonAtI; char finalLeastCommonAtI = leastCommonAtI;

            oxygenList = oxygenList.stream().filter(number -> number.charAt(finalI) == finalMostCommonAtI).collect(Collectors.toList());
            co2List = co2List.stream().filter(number -> number.charAt(finalI) == finalLeastCommonAtI).collect(Collectors.toList());
            if (oxygenList.size() == 1) oxygenRating = oxygenList.get(0);
            if (co2List.size() == 1) co2 = co2List.get(0);
        }
        return Integer.parseInt(oxygenRating, 2) * Integer.parseInt(co2, 2);
    }

    private static Integer partOne() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/adventofcode/day3/src/resources/input"));
        int[] table = new int[12];
        String currentLine;
        char currChar;
        while (scanner.hasNext()) {
            currentLine = scanner.next();
            for (int i = 0; i < 12; i++) {
                currChar = currentLine.charAt(i);
                if (currChar == '1')
                    table[i]++;
                else
                    table[i]--;
            }
        }
        String epsilonRate = "", gammaRate = "";
        for (int i = 0; i < 12; i++) {
            if (table[i] > 0) {
                epsilonRate = "1" + epsilonRate;
                gammaRate = "0" + gammaRate;
            } else {
                epsilonRate = "0" + epsilonRate;
                gammaRate = "1" + gammaRate;
            }
        }
        return Integer.parseInt(epsilonRate, 2) * Integer.parseInt(gammaRate, 2);
    }
}