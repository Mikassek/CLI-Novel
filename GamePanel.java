import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    this.add(dialog);

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