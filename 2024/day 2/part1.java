import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException{
        File input = new File("input2.txt");
        Scanner scanner = new Scanner(input);
        int safe = 0;
        while(scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            ArrayList<Integer> report = new ArrayList<>();
            for (String part : parts) {
                report.add(Integer.parseInt(part));
            }
            if (isSafe(report)) {
                ++safe;
            }
        }
        scanner.close();
        System.out.println(safe);
    }

    public static boolean isSafe(ArrayList<Integer> report) {
        boolean decreasing = false;
        for (int i = 0; i < report.size() - 1; i++) {
            int diff = report.get(i + 1) - report.get(i);
            if (i == 0) {
                decreasing = diff < 0;
            }
            if (decreasing) {
                diff = -diff;
            }
            if (diff > 3 || diff < 1) {
                return false;
            }
        }
        return true;
    }
}