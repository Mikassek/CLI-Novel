import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class dialogController {
    List<String> zeilen;
    int dialogIndex = 0;
    
    boolean aufAuswahlWarten = false;
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
            zeilen = Files.readAllLines(Path.of( "assets", "dialog.txt"));
            zeigeDialog();
        } catch (IOException e) {
            System.out.println("dialog.txt konnte nicht gefunden werden.");
        }

        System.out.println("dialogController erfolgreich geladen");

    }

    public void zeigeDialog() {
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
        if (zeile.startsWith("[MERGE;")){
            String[] mergetemp = zeilen.get(dialogIndex).split(";");
            dialogIndex = Integer.parseInt(mergetemp[1]) -1;
          
        }
    }

}
