import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
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
    private JButton b,b1, b2;
    Dimension db = new Dimension(25,50);

	//Bildschirmgröße definieren.
	final int screenWidth = 640;
	final int screenHeight = 480;
    Dimension dp = new Dimension(640,screenHeight/2);
    private JLabel dialog;
    private List<String> lines = List.of();
    private int dialogIndex = 0;

	// 
	public GamePanel() {

        // Panel Größe einstellen.
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        // ???
        this.setDoubleBuffered(true);
        // ???
        this.setFocusable(true);
        // ???
        this.setLayout(new BorderLayout());
 
        // Deklaration des Textboxes.
        JPanel TextBox = new JPanel(new BorderLayout());
        // Größe des Textboxes einstellen
        TextBox.setPreferredSize(new Dimension(screenWidth, screenHeight/3));
        // Rahmen des Textboxes einstellen.
        TextBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // Hintergrundfarbe des Textboxes einstellen.
        TextBox.setBackground(Color.GRAY);
        // ???
        this.add(TextBox, BorderLayout.SOUTH);
 
        // Deklaration des Textes.
        dialog = new JLabel();
        // Horizontale Ausrichtung des Textes.
        dialog.setHorizontalAlignment(SwingConstants.LEFT);
        // ???
        TextBox.add(dialog, BorderLayout.NORTH);

        KeyHandler keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);

       
            JPanel ButtonPanel = new JPanel(new GridBagLayout());
            ButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
            
       
        b = new JButton("test");
        b1= new JButton("test");
        b2 = new JButton("test");
        JPanel buttons = new JPanel(new GridLayout(3, 1, 0, 10));
        //panel.setsize(dp);
        buttons.add(b);
        buttons.add(b1);
        buttons.add(b2);
        ButtonPanel.add(buttons);
        this.add(ButtonPanel, BorderLayout.CENTER);
         
        //b.addActionListener(new ActionListener);
     
        try {

            lines = Files.readAllLines(Path.of("assets", "dialog.txt"));
            dialogShow();
                
               
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
            dialogShow();
           
        }
    }
    public void dialogShow(){
         b.setVisible(false);
         b1.setVisible(false);
         b2.setVisible(false);
         if (lines.isEmpty()) return;

        String line = lines.get(dialogIndex);
        dialog.setText(line);

        if (line.contains("[AUSWAHL]")){
             b.setVisible(true);
             b1.setVisible(true);
             b2.setVisible(true);
            b.setText(lines.get(dialogIndex + 1));
            b1.setText(lines.get(dialogIndex + 2));
            b2.setText(lines.get(dialogIndex + 3));
             dialogIndex += 3 ;
        }
    }
}
