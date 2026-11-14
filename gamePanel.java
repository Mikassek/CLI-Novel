import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class gamePanel extends backgroundController {

    int bildschirmBreite = 640;
    int bildschirmHoehe = 480;
    JLabel dialog;
    JPanel savepanel;
    dialogController dialogController;
    choiseController choiseController;
    saveGame save;

    public gamePanel() {

        setPreferredSize(new Dimension(bildschirmBreite, bildschirmHoehe));
        setLayout(new BorderLayout());
        setFocusable(true);

        savepanel = new JPanel(new GridLayout(1, 3, 5, 0));
        savepanel.setVisible(false);
        add(savepanel, BorderLayout.NORTH);
        savepanel.setOpaque(false);
        JButton SpeicherButton = new JButton("Speichern");
        SpeicherButton.setBackground(Color.WHITE);
        SpeicherButton.setFocusable(false);
        savepanel.add(SpeicherButton);
        SpeicherButton.addActionListener(e -> {
            save.saveGameCreate();
            save.SaveGameWrite();
        });
        JButton LadenButton = new JButton("Laden");
        LadenButton.setBackground(Color.WHITE);
        LadenButton.setFocusable(false);
        savepanel.add(LadenButton);
        LadenButton.addActionListener(e -> {
            int index = save.SaveGameRead();
            dialogController.dialogIndex = index;
            dialogController.zeigeDialog();
        });
        JButton leerenButton = new JButton("Leeren");
        leerenButton.setBackground(Color.WHITE);
        leerenButton.setFocusable(false);
        savepanel.add(leerenButton);
        leerenButton.addActionListener(e -> {
            try {
                FileWriter SaveWrite = new FileWriter("saves/savegame.txt");
                SaveWrite.write("0");
                SaveWrite.close();
                System.out.println("Savegame gelöscht");
            } catch (IOException ex) {
                System.out.println("Fehler beim Löschen des Savegames");
                ex.printStackTrace();
            }
        });

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setPreferredSize(new Dimension(bildschirmBreite, bildschirmHoehe / 4));
        textPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(textPanel, BorderLayout.SOUTH);

        dialog = new JLabel("test");
        dialog.setFont(new Font("Calibri", Font.PLAIN, 16));
        dialog.setHorizontalAlignment(SwingConstants.LEFT);
        textPanel.add(dialog, BorderLayout.NORTH);

        dialogController = new dialogController(this);
        choiseController = dialogController.getChoiseController();

        save = new saveGame();                      
        save.dialogController = dialogController;   


        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        add(buttonPanel, BorderLayout.CENTER);

        JPanel buttonWrapper = new JPanel(new GridLayout(3, 1, 0, 10));
        buttonWrapper.setOpaque(false);
        buttonWrapper.add(choiseController.button1);
        buttonWrapper.add(choiseController.button2);
        buttonWrapper.add(choiseController.button3);
        buttonPanel.add(buttonWrapper);

        addKeyListener(new keyHandler(dialogController));
        dialogController.start();

        System.out.println("gamePanel erfolgreich geladen");
    }

    public void setTextDialog(String text) {
        dialog.setText("<html><div style=\"width:480px;\">" + text + "</div><html>");
    }

    public void setSaveMenu(boolean escapePressed) {
        savepanel.setVisible(escapePressed);
    }
}
