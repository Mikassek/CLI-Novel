import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class dialogController {

    static List<String> zeilen;
    static int dialogIndex = 0;
    static boolean aufAuswahlWarten = false;

    public dialogController(gamePanel gamePanel) {

        keyHandler keyHandler = new keyHandler();
        gamePanel.addKeyListener(keyHandler);

        try {
            zeilen = Files.readAllLines(Path.of("CLI-Novel", "assets", "dialog.txt"));
            zeigeDialog();
        } catch (IOException e) {
            System.out.println("dialog.txt konnte nicht gefunden werden.");
        }

        System.out.println("dialogController erfolgreich geladen");

    }

    public static void zeigeDialog() {
        String zeile = zeilen.get(dialogIndex);
        gamePanel.setTextDialog(zeile);

        if (zeile.contains("[AUSWAHL]")) {
            aufAuswahlWarten = true;
            choiseController.zeigeAuswahl(zeilen, dialogIndex);
            choiseController.zeigeButtons(true);
        } else {
            aufAuswahlWarten = false;
            choiseController.zeigeButtons(false);
        }

    }

    public static void skipDialog() {

        if (aufAuswahlWarten == true) {
            return;
        }

        if (dialogIndex + 1 < zeilen.size()) {
            dialogIndex++;
            zeigeDialog();
        }

    }

}
