import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab2 {
    private static final String DATA_FILE_NAME = "data1.txt";

    public static void doTheStuff(String dataFileName) throws
            FileNotFoundException {
        Scanner scanner = new Scanner(new File(dataFileName));
        List<Integer> integerList = new ArrayList<Integer>();
        while(scanner.hasNextInt()) {
            integerList.add(scanner.nextInt());
        }
        for (int i = 0; i < integerList.size(); ++i) {
            int firstNumber = integerList.get(i);
            for (int j = i + 1; j < integerList.size(); ++j) {
                int secondNumber = integerList.get(j);
                for (int k = j + 1 ; k < integerList.size(); ++k) {
                    int thirdNumber = integerList.get(k);
                    int sum = (firstNumber % 37) + (secondNumber % 37) + (thirdNumber % 37);
                    if (sum % 37 == 0) {
                        System.out.println(firstNumber + ", " + secondNumber + ", " + thirdNumber);
                    }
                }
            }
        }
    }

    public static void doTheCookieStuff(String dataFileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(dataFileName));
        List<ArrayList<Integer>> remainderList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 37; ++i) {
            remainderList.add(new ArrayList<Integer>());
        }
        while(scanner.hasNextInt()) {
            int currentInteger = scanner.nextInt();
            int remainder = currentInteger % 37;
            int index = remainder - 1;
            remainderList.get(index).add(currentInteger);
        }
        System.out.println(Arrays.toString(remainderList.toArray()));

    }

    public static void main(String[] args) throws FileNotFoundException {
        doTheCookieStuff(DATA_FILE_NAME);
    }
}