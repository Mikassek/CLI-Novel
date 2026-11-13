import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class backgroundController extends JPanel {

    Image hintergrundbild;
    String aktuellerHintergrund;

    public void setHintergrundbild(String dateiname) {

        Path datei = Path.of("CLI-Novel","assets", dateiname);

        try {
            hintergrundbild = ImageIO.read(datei.toFile());
            aktuellerHintergrund = dateiname;
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(hintergrundbild, 0, 0, getWidth(), getHeight(), this);
    }
}