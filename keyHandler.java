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
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

}
