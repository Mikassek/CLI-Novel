import javax.swing.JFrame;

public class GameFrame {

	public GameFrame() {
		// Ein neues Fenster wird deklariert.
		JFrame window = new JFrame();
		// Was passieren soll wenn man das Fenster schließt.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Funktion zur Größenveränderung umschalten.
		window.setResizable(false);
		// Anzeigename des Fensters einstellen.
		window.setTitle("Visual Novel");
		// Initialisiert das GamePanel
		GamePanel GamePanel = new GamePanel();
		// Fügt das GamePanel dem Fenster hinzu.
		window.add(GamePanel);
		// ???
		window.pack();
		// Das Fenster erscheint in der Mitte des Bildschirms
		window.setLocationRelativeTo(null);
		// Fenster Sichtbarkeit umschalten.
		window.setVisible(true);
		// ???
		GamePanel.requestFocusInWindow();
		
		System.out.println("GameFrame erfolgreich geladen");
		
	}

}