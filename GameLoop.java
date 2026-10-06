import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameLoop extends JPanel implements Runnable {

	//Screen settings
	//Kachelgröße definieren.
	final int originalTileSize = 16;                  //16x16px
	//Kachel Skalierungsfaktor definieren.
	final int scale = 3;
	//Skalierte Kachelgröße definieren.
	final int tileSize = originalTileSize * scale;    //48x48px
	//how much tiles in one coulum
	final int maxScreenCol = 16;
	//how much tiles in one row
	final int maxScreenRow = 12;
	//Bildschirmgröße definieren.
	final int screenWidth = tileSize * maxScreenCol;  //768px
	final int screenHeight = tileSize * maxScreenRow; //576px
	
	//FPS definieren.
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	
	//time
	Thread gameThread;
	
	//set player default position
	int playerX = ( screenWidth / 2 ) - tileSize; //centered
	int playerY = ( screenHeight / 2 ) - tileSize; //centered
	int playerSpeed = 4;
	
	public void startGameThread( ) {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		System.out.println("Die Spielschleife läuft");
		//GAME LOOP
		
		double drawInterval = 1000000000/FPS; //0.01666sec
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			long currentTime = System.nanoTime(); 
			//1 UPDATE: UPDATE INFORMATION character posiion
			update();
			//2 DRAW: draw the screen with the updates
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				//conversion from nanosec to millisec
				remainingTime = remainingTime/1000000;
				if(remainingTime <0) {
					remainingTime = 0;
				}
				Thread.sleep((long)remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//constructor
	public GameLoop() {
		//???
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		//set background color
		this.setBackground(Color.black);
		//??? double buffer
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void update() {
		if (keyH.upPressed == true) {
			playerY -= playerSpeed;
		} else if (keyH.downPressed == true) {
			playerY += playerSpeed;
		} else if (keyH.leftPressed == true) {
			playerX -= playerSpeed;
		} else if (keyH.rightPressed == true) {
			playerX += playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, 48, 48);
		g2.dispose();
	}

}