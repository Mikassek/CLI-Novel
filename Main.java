import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int  i = 0;
    public static int[] Punkte = new int[0];
    static Scanner auswealer = new Scanner(System.in);

   
    
    public static void main(String[] args) throws IOException {

        new GameFrame();

            List<String> lines = Files.readAllLines(
                Path.of("CLI-Novel", "assets", "dialog.txt")
            );

            Scanner scanner = new Scanner(System.in);

            for (i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains("[AUSWAHL]")) {
                    String auswahl1 = lines.get(i + 1);
                    String auswahl2 = lines.get(i + 2); //Es gibt sicherlich eine besseren weg das zu schreiben , ich bin aber zu faul darüber grade nachzudenken und will einfach das es läuft (für jetzt)
                    String auswahl3 = lines.get(i + 3);
                    auswahl(auswahl1,auswahl2,auswahl3);
                } else {
                    System.out.print(lines.get(i));
                    scanner.nextLine();
                }
            }

            scanner.close();

    }

    public static int auswahl(String auswahl1, String auswahl2, String auswahl3) {
        System.out.println(auswahl1);
        System.out.println(auswahl2);
        System.out.println(auswahl3);
        String temp_string = auswealer.nextLine();
        int wahl = Integer.parseInt(temp_string);
        /*switch(wahl) {
            case 1: Punkte[0]++;
            case 2: Punkte[1]++;
            case 3: Punkte[2]++;
             //Temporär , keine ahnung bis jetzt was sonst zurückgegeben werden soll
            
        }*/

        return 1;
        
    } 

}