import javax.swing.JFrame;

public class gameFrame {
    public gameFrame() {
        JFrame fenster = new JFrame();
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setResizable(false);
        fenster.setTitle("Visual Novel");
        fenster.add(new gamePanel());
        fenster.pack();
        fenster.setVisible(true);
        System.out.println("gameFrame erfolgreich geladen");
    }
}