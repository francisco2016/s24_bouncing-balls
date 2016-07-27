import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
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
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        Random aleatorio = new Random(); //------------------------------------------------------------------- 0100
        ArrayList<BouncingBall> bolas2 = new ArrayList<>();

        for(int i = 0; i < numBolas; i ++){//para iterar el nº de numBolas, e ir creando las bolas totales.
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
            bolas2.add(ball);//guardo cada bola creada en la colección bolas2.
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            
            for(BouncingBall bolas3: bolas2){//recorro la colección bolas2 para poder dar movimiento a cada bola
            bolas3.move();
            // stop once ball has travelled a certain distance on x axis
            if(bolas3.getXPosition() >= 550) {//si una de las bolas llega a esta posición, la animación se para.
                finished = true;
            }
        }
        }
    }
}
