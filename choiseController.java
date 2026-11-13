import java.awt.Color;
import java.util.List;
import javax.swing.JButton;

public class choiseController {

    JButton button1 = new JButton("test");
    JButton button2 = new JButton("test");
    JButton button3 = new JButton("test");
    int[] zielZeilen = new int[3];
    dialogController dialogController;

    public choiseController(dialogController dialogController) {
        this.dialogController = dialogController;
        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button1.addActionListener(e -> auswahlZiel(0));
        button2.addActionListener(e -> auswahlZiel(1));
        button3.addActionListener(e -> auswahlZiel(2));

        System.out.println("choiseController erfolgreich geladen");
    }

    public void zeigeAuswahl(List<String> zeilen, int auswahlIndex) {
        String[] auswahl1 = zeilen.get(auswahlIndex + 1).split(";");
        String[] auswahl2 = zeilen.get(auswahlIndex + 2).split(";");
        String[] auswahl3 = zeilen.get(auswahlIndex + 3).split(";");
        button1.setText(auswahl1[2]);
        button2.setText(auswahl2[2]);
        button3.setText(auswahl3[2]);
        zielZeilen[0] = Integer.parseInt(auswahl1[1].trim());
        zielZeilen[1] = Integer.parseInt(auswahl2[1].trim());
        zielZeilen[2] = Integer.parseInt(auswahl3[1].trim());
    }

    public void auswahlZiel(int nummer) {
        zeigeButtons(false);
        dialogController.waehleZiel(zielZeilen[nummer]);
    }

    public void zeigeButtons(boolean sichtbarkeit) {
        button1.setVisible(sichtbarkeit);
        button2.setVisible(sichtbarkeit);
        button3.setVisible(sichtbarkeit);
    }
}
