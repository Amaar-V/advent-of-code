import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException{
        File input = new File("input2.txt");
        Scanner scanner = new Scanner(input);
        long sum = 0;
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            List<String> parts = Pattern.compile("mul\\(\\d+,\\d+\\)")
                                        .matcher(line)
                                        .results()
                                        .map(matchResult -> matchResult.group())
                                        .collect(Collectors.toList());
            for (String part : parts) {
                long num1 = Long.parseLong(part.substring(part.indexOf('(') + 1, part.indexOf(',')));
                long num2 = Long.parseLong(part.substring(part.indexOf(',') + 1, part.indexOf(')')));
                sum += num1 * num2;
            }
        }
        scanner.close();
        System.out.println(sum);
    }
}