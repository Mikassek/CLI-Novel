import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Path filePath = Path.of(
            "C:\\Users\\daniel\\Desktop\\Daniel & Mika Visual Novel\\projekt\\CLI-Novel\\assets\\dialog.txt"
        );

        try {
            List<String> lines = Files.readAllLines(filePath);

            Scanner scanner = new Scanner(System.in);

            for (String line : lines) {
                System.out.println(line);
                scanner.nextLine();
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Could not find or read dialog.txt");
            e.printStackTrace();
        }
    }
}
