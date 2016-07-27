import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line
                myCanvas.setVisible(true);
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        Random aleatorio = new Random(); //------------------------------------------------------------------- 0100
        int posicionX = aleatorio.nextInt(80);
        int posicionY = aleatorio.nextInt(300);
        int radio = aleatorio.nextInt(50) +11;
        
        float RED = aleatorio.nextFloat();
        float BLUE = aleatorio.nextFloat();
        float GREEN = aleatorio.nextFloat();
        
        Color color = new Color(RED, BLUE, GREEN);
        
        // crate and show the balls
        BouncingBall ball = new BouncingBall(posicionX, posicionY, radio, color, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
