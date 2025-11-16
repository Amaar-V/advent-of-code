import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input1.txt");
        Scanner scanner = new Scanner(input);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            list1.add(Integer.parseInt(parts[0]));
            list2.add(Integer.parseInt(parts[1]));
        }
        scanner.close();

        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);

        int totalDistance = 0;
        for (int i = 0; i < list1.size(); i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(totalDistance);
    }
}
