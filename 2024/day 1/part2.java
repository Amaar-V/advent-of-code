import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input1.txt");
        Scanner scanner = new Scanner(input);
        HashMap<Integer, Integer> numberSet = new HashMap<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            numberSet.put(Integer.parseInt(parts[0]), 0);
            list1.add(Integer.parseInt(parts[0]));
            list2.add(Integer.parseInt(parts[1]));
        }
        scanner.close();

        for (int number : list2) {
            if (numberSet.containsKey(number)) {
                numberSet.put(number, numberSet.get(number) + 1);
            }
        }

        int similarityScore = 0;
        for (int number : list1) {
            similarityScore += numberSet.get(number) * number;
        }

        System.out.println(similarityScore);
    }
}
