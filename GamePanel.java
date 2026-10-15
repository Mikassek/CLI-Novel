import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GamePanel extends JPanel {
    Dimension dp = new Dimension(640,240);
    Dimension db = new Dimension(25,50);
	//Bildschirmgröße definieren.
	final int screenWidth = 640;
	final int screenHeight = 480;
    private JLabel dialog;
    private List<String> lines = List.of();
    private int dialogIndex = 0;

	//constructor
	public GamePanel() {
        // Panel Einstellungen
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        
        this.setLayout(new BorderLayout());
 
        // TextBox
        JPanel TextBox = new JPanel(new BorderLayout());
        TextBox.setPreferredSize(new Dimension(screenWidth, screenHeight/3));
        TextBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(TextBox, BorderLayout.SOUTH);
 
        // Dialog
        dialog = new JLabel();
        dialog.setHorizontalAlignment(SwingConstants.LEFT);
        TextBox.add(dialog, BorderLayout.NORTH);

        KeyHandler keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);

     JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
    
     this.add(panel);
     JButton b = new JButton("test");
     JButton b1= new JButton("test");
     JButton b2 = new JButton("test");
     b.addKeyListener(keyHandler);
     b1.addKeyListener(keyHandler);
     b2.addKeyListener(keyHandler);
     //panel.setsize(dp);
     panel.add(b);
     panel.add(b1);
     panel.add(b2);
     b.setSize(db);
     b1.setSize(db);
     b2.setSize(db);
     //b.addActionListener(new ActionListener);
     
        try {

            lines = Files.readAllLines(Path.of("assets", "dialog.txt"));
            if (!lines.isEmpty()) {
                dialog.setText(lines.get(dialogIndex));
            }

        }

        catch (IOException e) {
            System.out.println("Could not find or read dialog.txt");
            e.printStackTrace();
        }
        System.out.println("GamePanel erfolgreich geladen");
    }

public void dialogSkip() {
        if (dialogIndex + 1 < lines.size()) {
            dialogIndex++;
            dialog.setText(lines.get(dialogIndex));
        }
    }

}