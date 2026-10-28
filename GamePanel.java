import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;

public class gamePanel extends JPanel {

    static int bildschirmBreite = 640;
    int bildschirmHoehe = 480;
    static JLabel dialog;

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
        new dialogController(this);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        add(buttonPanel, BorderLayout.CENTER);

        //buttons & logik
        new choiseController(this);

        JPanel buttonWrapper = new JPanel(new GridLayout(3, 1, 0, 10));
        buttonWrapper.setOpaque(false);
        buttonWrapper.add(choiseController.button1);
        buttonWrapper.add(choiseController.button2);
        buttonWrapper.add(choiseController.button3);
        buttonPanel.add(buttonWrapper);

        System.out.println("gamePanel erfolgreich geladen");
    }

    // gamePanel & dialogController verbindung
    public static void setTextDialog(String text) {
        dialog.setText("<html><div style=\"width:480px;\">" + text + "</div><html>");
    }

    Image hintergrundbild = Toolkit.getDefaultToolkit().createImage("CLI-Novel/assets/hintergrundbild.jpg");
    @Override 
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(hintergrundbild, 0, 0, getWidth(), getHeight(), this);
    }
}