import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Francisco septiembre.
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
     * 
     */
    public void boxBounce(int numBolas2){//--------------------------------------------------------------------------- 0101

        Random aleatorio = new Random();
        myCanvas.setVisible(true);
        //para dibujar el rectángulo.
        myCanvas.drawLine(50, 50, 550, 50);// (50 d x y 50 de y) y (550 d x y 50 de y)
        myCanvas.drawLine(550, 50, 550, 400);//barra derecha 550
        myCanvas.drawLine(550, 400, 50, 400);//suelo 400
        myCanvas.drawLine(50, 400, 50, 50);  //izquierda 500

        ArrayList<BoxBall> bolas = new ArrayList<>();
        for (int cont = 0; cont < numBolas2; cont++)
        {
            int diametro = aleatorio.nextInt(25)+ 5;//calcula el diametro 
            Color colorA = new Color(aleatorio.nextInt(255),aleatorio.nextInt(255),aleatorio.nextInt(255));

            int ladx = aleatorio.nextInt(2);//elige al direccion aleatoriamente entre 0 y 2
            int lady = aleatorio.nextInt(2);
            if (ladx == 0)
            {
                ladx = -1;
            }
            if (lady == 0)
            {
                lady = -1;
            }

            int posInix = aleatorio.nextInt(500);
            int posIniy = aleatorio.nextInt(350);
            if(posInix < 50)
            {
                posInix = 100;
            }
            if(posIniy < 50)
            {
                posIniy = 100;
            }
            //creamos la  bola
            bolas.add(new BoxBall(posInix, posIniy, diametro, colorA, 
                    400, 50, 50, 550, 
                     ladx, lady, myCanvas)); //
            bolas.get(cont).draw();
        }

        while(true)
        {
            myCanvas.wait(50);           // small delay hace que se pare la bola durante un instante
            for (int cont = 0;cont<numBolas2;cont++)
            {
                bolas.get(cont).move();
            }
        }
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
