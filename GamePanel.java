import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	//Bildschirmgröße definieren.
	final int screenWidth = 640;
	final int screenHeight = 480;

	public static int  i = 0;
	
	//constructor
	public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        JLabel dialog = new JLabel();
        KeyHandler KeyHandler = new KeyHandler();
        this.add(dialog);
        this.addKeyListener(KeyHandler);

        try {

            List<String> lines = Files.readAllLines(
                Path.of("CLI-Novel", "assets", "dialog.txt")
           );

           dialog.setText(lines.get(i));


            /*while (i < lines.size()); {
                if (KeyHandler.enterPressed == true) {
                    dialog.setText(lines.get(i));
                    i++;
                }
            }*/

            for (int i = 0; i < lines.size();) {
                if (KeyHandler.enterPressed == true) {
                    dialog.setText(lines.get(i));
                    i++;
                }
            }

        } 
        catch (IOException e) {
            System.out.println("Could not find or read dialog.txt");
            e.printStackTrace();
        }
        System.out.println("GamePanel erfolgreich geladen");
    }	

}