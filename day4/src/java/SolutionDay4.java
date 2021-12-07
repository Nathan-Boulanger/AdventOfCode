import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SolutionDay4 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\n\nSolution : " + partTwo());
    }

    private static Integer partOne() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day4/src/resources/input"));

        int[] drawList = Arrays.stream(scanner.useDelimiter("\\n").next().split(",")).mapToInt(Integer::parseInt).toArray();
        String currLine;
        ArrayList<int[][]> boardList = new ArrayList<>();
        int[][] currBoard = new int[5][5];
        int rowNumber = 0;
        scanner.next();
        while (scanner.hasNext()) {
            currLine = scanner.next();

            if (currLine.equals("")) {
                boardList.add(currBoard);
                currBoard = new int[5][5];
                rowNumber = 0;
            } else {
                currBoard[rowNumber] = Arrays.stream(currLine.split(" ", 0)).filter(item -> !item.equals("")).mapToInt(Integer::parseInt).toArray();
                System.out.println(currLine);
                rowNumber = rowNumber + 1;
            }
        }

        int[][] winningBoard;
        for (int drawn : drawList) {
            drawNumber(drawn, boardList);
            winningBoard = searchWinner(boardList);
            if (winningBoard != null) {
                scanner.close();
                int sumBoard = 0;
                for (int[] row : winningBoard) {
                    for (int number: row) {
                        if (number != -1) sumBoard += number;
                    }
                }
                scanner.close();
                return sumBoard * drawn;
            }
        }
        scanner.close();
        return null;
    }

    private static Integer partTwo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/nathan/AdventOfCode/day4/src/resources/input"));

        /* Setup variables */
        int[] drawList = Arrays.stream(scanner.useDelimiter("\\n").next().split(",")).mapToInt(Integer::parseInt).toArray();
        String currLine;
        ArrayList<int[][]> boardList = new ArrayList<>();
        int[][] currBoard = new int[5][5];
        int rowNumber = 0;
        scanner.next();
        while (scanner.hasNext()) {
            currLine = scanner.next();

            if (currLine.equals("")) {
                boardList.add(currBoard);
                currBoard = new int[5][5];
                rowNumber = 0;
            } else {
                currBoard[rowNumber] = Arrays.stream(currLine.split(" ", 0)).filter(item -> !item.equals("")).mapToInt(Integer::parseInt).toArray();
                System.out.println(currLine);
                rowNumber = rowNumber + 1;
            }
        }

        System.out.println(boardList.size());
        scanner.close();

        int drawnNumber = 0;
        int[][] lastWinner = new int[5][5];
        for (int i = 0; i < drawList.length; i++) {
            drawnNumber = drawList[i];
            drawNumber(drawnNumber, boardList);
            if (boardList.size() > 1)
                boardList.removeAll(searchWinners(boardList));
            else if (boardList.size() == 1 && searchWinner(boardList) != null) {
                lastWinner = boardList.get(0);
                break;
            }
        }

        int sumBoard = 0;
        for (int[] row : lastWinner) {
            for (int number: row) {
                if (number != -1) sumBoard += number;
            }
        }
        return sumBoard*drawnNumber;
    }

    private static List<int[][]> searchWinners(ArrayList<int[][]> boards) {
        ArrayList<int[][]> winners = new ArrayList<>();
        for (int[][] board: boards) {
            boolean[] columnsWon = {true, true, true, true, true};
            for (int[] row : board) {
                boolean rowWon = true;
                for (int i = 0; i < 5; i++) {
                    if (row[i] != -1) {
                        rowWon = false;
                        columnsWon[i] = false;
                    }
                }
                if (rowWon && !winners.contains(board)) winners.add(board);
            }
            for (boolean columnWon : columnsWon)
                if (columnWon && !winners.contains(board)) winners.add(board);
        }
        return winners;
    }

    private static int[][] searchWinner(ArrayList<int[][]> boards) {
        for (int[][] board: boards) {
            boolean[] columnsWon = {true, true, true, true, true};
            for (int[] row : board) {
                boolean rowWon = true;
                for (int i = 0; i < 5; i++) {
                    if (row[i] != -1) {
                        rowWon = false;
                        columnsWon[i] = false;
                    }
                }
                if (rowWon) return board;
            }
            for (boolean columnWon : columnsWon)
                if (columnWon) return board;
        }
        return null;
    }

    private static void drawNumber(int drawnNumber, ArrayList<int[][]> boards) {
        for (int[][] board : boards) {
            for (int[] row : board) {
                for (int i = 0; i < 5; i++) {
                    if (row[i] == drawnNumber)
                        row[i] = -1;
                }
            }
        }
    }
}