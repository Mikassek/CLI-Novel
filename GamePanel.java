import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.*;

public class GamePanel extends JPanel {
    public static int score[] = {0,0,0};
    private JButton b,b1, b2;
    public int  target1, target2, target3;
    Dimension db = new Dimension(25,50);
   

    Image hintergrund_test = Toolkit.getDefaultToolkit().createImage("assets/hintergrund_test.jpg");

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
      JPanel TextBox = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics g2 = g.create();
                g2.setColor(new Color(0, 0, 0, 123));
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };
        TextBox.setOpaque(false);
 
        // Größe des Textboxes einstellen
        TextBox.setPreferredSize(new Dimension(screenWidth, screenHeight/3));
        // Rahmen des Textboxes einstellen.
        TextBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // Hintergrundfarbe des Textboxes einstellen.
       // TextBox.setBackground(new Color(0, 0, 0, 123));
        // ???
        this.add(TextBox, BorderLayout.SOUTH);
 
        // Deklaration des Textes.
        dialog = new JLabel();
        dialog.setForeground(Color.white);
        // Horizontale Ausrichtung des Textes.
        dialog.setHorizontalAlignment(SwingConstants.LEFT);
        // ???
        TextBox.add(dialog, BorderLayout.NORTH);
        
        KeyHandler keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);

       
        JPanel ButtonPanel = new JPanel(new GridBagLayout());
        ButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));   
        ButtonPanel.setOpaque(false);

        b = createSemiTransparentButton("test");
        b1 = createSemiTransparentButton("test");
        b2 = createSemiTransparentButton("test");
        b.setForeground(Color.white);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        JPanel buttons = new JPanel(new GridLayout(3, 1, 0, 10));
        buttons.setOpaque(false);  
        //panel.setsize(dp);
        buttons.add(b);
        buttons.add(b1);
        buttons.add(b2);
        b.setFocusable(false);
      b1.setFocusable(false);
        b2.setFocusable(false);
        ButtonPanel.add(buttons);
        this.add(ButtonPanel, BorderLayout.CENTER);
         
          
        
        

     
        try {

            lines = Files.readAllLines(Path.of("assets", "dialog.txt"));
  
            dialogShow();
            buttonpress();
               
           }

        catch (IOException e) {
            System.out.println("Could not find or read dialog.txt");
            e.printStackTrace();
        }
        repaint();
        System.out.println("GamePanel erfolgreich geladen");

    }


    


   
    public void dialogSkip() {
        if (dialogIndex + 1 < lines.size()) {
            dialogIndex++;
            dialogShow();
           
        }
    }
    public void dialogBack() {
        if (dialogIndex > 0) {
            dialogIndex--;
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
               String[] d1 = lines.get(dialogIndex + 1).split(",");
               String[] d2 = lines.get(dialogIndex + 2).split(",");
               String[] d3 = lines.get(dialogIndex + 3).split(","); 
            b.setText(d1[2]);
            b1.setText(d2[2]);
            b2.setText(d3[2]);

             target1 = Integer.parseInt(d1[1]);
             target2 = Integer.parseInt(d2[1]);
             target3 = Integer.parseInt(d3[1]);
        }        
       
    }

     public void buttonpress() {
         b.addActionListener(e -> {
           dialogIndex = target1;
           dialogShow();
        });
         b1.addActionListener(e -> {
             dialogIndex = target2;
           dialogShow();
        });
         b2.addActionListener(e -> {
            dialogIndex = target3;
           dialogShow();
        });
    }


    private JButton createSemiTransparentButton(String text) {
    JButton button = new JButton(text) {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics g2 = g.create();
            g2.setColor(new Color(0, 0, 0, 128));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();
 
            super.paintComponent(g);
        }
    };
 
    button.setOpaque(false);
    button.setContentAreaFilled(false);
    return button;
}
     @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(hintergrund_test, 0, 0, getWidth(), getHeight(), this);
    }
}
