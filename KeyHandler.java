import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	private final GamePanel gamePanel;
	public boolean enterPressed;

	public KeyHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		System.out.println("KeyHandler erfolgreich geladen");
	}

	@Override
    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER && !enterPressed) {
			enterPressed = true;
			gamePanel.dialogSkip();
		}
	}

	@Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        enterPressed = false;
		}
	}
}