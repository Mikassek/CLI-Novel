import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

	public static int  i = 0;
	
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
        JLabel dialog = new JLabel();
        dialog.setHorizontalAlignment(SwingConstants.LEFT);
        TextBox.add(dialog, BorderLayout.NORTH);
 
        // KeyHandler KeyHandler = new KeyHandler();
        // this.addKeyListener(KeyHandler);





     JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
    
     this.add(panel);
     JButton b = new JButton("test");
     JButton b1= new JButton("test");
     JButton b2 = new JButton("test");
     //panel.setsize(dp);
     panel.add(b);
     panel.add(b1);
     panel.add(b2);
     b.setSize(db);
     b1.setSize(db);
     b2.setSize(db);
     //b.addActionListener(new ActionListener);
     
    try {

        List<String> lines = Files.readAllLines(
            Path.of("CLI-Novel", "assets", "dialog.txt")
        );

        final int[] i = {0};

        dialog.setText(lines.get(i[0]));

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    i[0]++;
                    
                    if (i[0] < lines.size()) {
                        dialog.setText(lines.get(i[0]));
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

    } catch (IOException e) {

        System.out.println("Could not find or read dialog.txt");
        e.printStackTrace();
    }

    System.out.println("GamePanel erfolgreich geladen");
}

	

}