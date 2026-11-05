import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Graphics;

public class backgroundController extends JPanel {

    Image hintergrundbild = Toolkit.getDefaultToolkit().createImage("CLI-Novel/assets/hintergrundbild.jpg");

    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(hintergrundbild, 0, 0, getWidth(), getHeight(), this);
    }

}