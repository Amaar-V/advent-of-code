import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part2 {
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
            if (isSafe(report, false)) {
                System.err.println(report);
                ++safe;
            }
        }
        scanner.close();
        System.out.println(safe);
    }

    public static boolean isSafe(ArrayList<Integer> report, boolean skipped) {
        boolean decreasing = false;
        for (int i = 1; i < report.size(); i++) {
            int diff = report.get(i) - report.get(i - 1);
            if (i == 1) {
                decreasing = diff < 0;
            }
            if (decreasing) {
                diff = -diff;
            }
            if (diff > 3 || diff < 1) {
                if (skipped) {
                    return false;
                } else {
                    if (i == 2){
                        ArrayList<Integer> report1 = new ArrayList<>(report.subList(1, report.size()));
                        boolean result = isSafe(report1, true);
                        if (result) {
                            return true;
                        }
                    }
                    ArrayList<Integer> report1 = new ArrayList<>(report.subList(0, i - 1));
                    report1.addAll(report.subList(i, report.size()));
                    ArrayList<Integer> report2 = new ArrayList<>(report.subList(0, i));
                    report2.addAll(report.subList(i + 1, report.size()));
                    boolean result = isSafe(report1, true) || isSafe(report2, true);
                    return result;
                }
            }
        }
        return true;
    }
}
