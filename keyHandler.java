import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    boolean enterPressed;
    dialogController dialogController;

    public keyHandler(dialogController dialogController) {
        this.dialogController = dialogController;
        System.out.println("keyHandler erfolgreich geladen");
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && enterPressed == false) {
            enterPressed = true;
            dialogController.skipDialog();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dialogController.gamePanel.setSaveMenu(!dialogController.gamePanel.savepanel.isVisible());
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}
