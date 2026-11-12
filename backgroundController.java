import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class backgroundController extends JPanel {

    Image hintergrundbild = Toolkit.getDefaultToolkit().createImage("assets/hintergrundbild.jpg");

    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(hintergrundbild, 0, 0, getWidth(), getHeight(), this);
    }

}