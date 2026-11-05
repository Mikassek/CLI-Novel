import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;

public class gamePanel extends backgroundController {

    int bildschirmBreite = 640;
    int bildschirmHoehe = 480;
    JLabel dialog;
    dialogController dialogController;
    choiseController choiseController;

    public gamePanel() {

        setPreferredSize(new Dimension(bildschirmBreite, bildschirmHoehe));
        setLayout(new BorderLayout());
        setFocusable(true);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setPreferredSize(new Dimension(bildschirmBreite, bildschirmHoehe / 3));
        textPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(textPanel, BorderLayout.SOUTH);

        dialog = new JLabel("test");
        dialog.setFont(new Font("Calibri", Font.PLAIN, 16));
        dialog.setHorizontalAlignment(SwingConstants.LEFT);
        textPanel.add(dialog, BorderLayout.NORTH);

        dialogController = new dialogController(this);
        choiseController = dialogController.getChoiseController();

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

    // gamePanel & dialogController verbindung
    public void setTextDialog(String text) {
        dialog.setText("<html><div style=\"width:480px;\">" + text + "</div><html>");
    }
}
