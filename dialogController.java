import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class dialogController {
    List<String> zeilen;
    int dialogIndex = 0;

    boolean aufAuswahlWarten = false;
    int backgroundIndex = -1;
    gamePanel gamePanel;
    choiseController choiseController;

    public dialogController(gamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.choiseController = new choiseController(this);
    }

    public choiseController getChoiseController() {
        return choiseController;
    }

    public void start() {
        try {
            Path dialogDatei = Path.of("assets", "dialog.txt");
            if (!Files.exists(dialogDatei)) {
                dialogDatei = Path.of("CLI-Novel", "assets", "dialog.txt");
            }
            zeilen = Files.readAllLines(dialogDatei);
            zeigeDialog();
        } catch (IOException e) {
            System.out.println("dialog.txt konnte nicht gefunden werden.");
        }
        System.out.println("dialogController erfolgreich geladen");
    }

    public void zeigeDialog() {
        int aktuellerBackgroundIndex = dialogIndex;
        while (aktuellerBackgroundIndex >= 0
                && !zeilen.get(aktuellerBackgroundIndex).startsWith("[BACKGROUND]")) {
            aktuellerBackgroundIndex--;
        }
        if (aktuellerBackgroundIndex >= 0 && aktuellerBackgroundIndex != backgroundIndex) {
            String dateiname = zeilen.get(aktuellerBackgroundIndex)
                    .substring("[BACKGROUND]".length()).trim();
            gamePanel.setHintergrundbild(dateiname);
            backgroundIndex = aktuellerBackgroundIndex;
        }

        while (zeilen.get(dialogIndex).startsWith("[BACKGROUND]")) {
            dialogIndex++;
            if (dialogIndex >= zeilen.size()) {
                return;
            }
        }

        String zeile = zeilen.get(dialogIndex);
        gamePanel.setTextDialog(zeile.replace("[AUSWAHL]", "").trim());

        if (zeile.contains("[AUSWAHL]")) {
            aufAuswahlWarten = true;
            choiseController.zeigeAuswahl(zeilen, dialogIndex);
            choiseController.zeigeButtons(true);
        } else {
            aufAuswahlWarten = false;
            choiseController.zeigeButtons(false);
        }
    }

    public void skipDialog() {

        if (aufAuswahlWarten == true) {
            return;
        }

        if (dialogIndex + 1 < zeilen.size()) {
            dialogIndex++;
            merger();
            zeigeDialog();
        }

    }

    public void waehleZiel(int zielZeile) {
        aufAuswahlWarten = false;
        dialogIndex = zielZeile - 1;
        zeigeDialog();
    }

    public void merger() {
        String zeile = zeilen.get(dialogIndex);
        if (zeile.startsWith("[MERGE];")) {
            String[] mergetemp = zeilen.get(dialogIndex).split(";");
            dialogIndex = Integer.parseInt(mergetemp[1]) - 1;
        }
    }
}
