import javax.swing.JFrame;

public class GameFrame {

	public GameFrame() {
		
		//Ein neues Fenster wird deklarieren.
		JFrame window = new JFrame();
		//Was passieren soll wenn man das Fenster schließt.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Funktion zur Größenveränderung umschalten.
		window.setResizable(false);
		//Anzeigename des Fensters deklarieren.
		window.setTitle("Visual Novel");
		//Initialisiert das GamePanel
		GamePanel GamePanel = new GamePanel();
		//Fügt das GamePanel dem Fenster hinzu.
		window.add(GamePanel);
		//???
		window.pack();
		//Das Fenster erscheint in der Mitte des Bildschirms
		window.setLocationRelativeTo(null);
		//Fenster Sichtbarkeit umschalten.
		window.setVisible(true);
		
		System.out.println("GameFrame erfolgreich geladen");
		
	}

}