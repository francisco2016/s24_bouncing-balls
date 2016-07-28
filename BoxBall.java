import java.awt.*;
import java.awt.geom.*;

/**
 * Francisco septiembre.
 * Esta clase, BoxBall, está basada en la clase Class BouncingBall - 
 */

public class BoxBall
{
    //private static final int GRAVITY = 3;         ------------eliminado 
    //private int ballDegradation = 2;              ------------eliminado 
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    //private final int groundPosition;             ------------eliminado 
    private final int posicionSuelo;        //------------------------------------------0101
    private final int posicionTecho;        //------------------------------------------0101
    private final int posicionLadoIzquierdo;//---------------------------------------- 0101
    private final int posicionLadoDerecho;  //------------------------------------------0101

    private Canvas canvas;
    private int ySpeed;   // initial downward speed
    private int xSpeed;                 //---------------------------------------- 0101

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,int posicionSuelo,  int posicionTecho,  
    int posicionLadoIzquierdo, int posicionLadoDerecho, int xSpeed, int ySpeed, Canvas drawingCanvas)//
    {
        xPosition = xPos;
        yPosition = yPos;
        diameter = ballDiameter;        
        color = ballColor;
        this.posicionSuelo = posicionSuelo;//----------------------------------------------------- 0101
        this.posicionTecho = posicionTecho; 
        this.posicionLadoDerecho = posicionLadoDerecho;
        this.posicionLadoIzquierdo = posicionLadoIzquierdo;
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;

        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if(yPosition >= (posicionSuelo - diameter)) {   //comprueba si la bola golpea el suelo.
            yPosition = (int)(posicionSuelo - diameter);//si toca el suelo.
            ySpeed = -1;                                // -1 hace invertir la dirección de la bola.
        }
        //         if(yPosition >= (posicionTecho - diameter)) {   
        //             yPosition = (int)(posicionTecho - diameter);
        //             ySpeed = 1;                                
        //         }
        if(yPosition <= (posicionTecho)) {   
            yPosition = (int)(posicionTecho +1);
            ySpeed = 1;                                
        }      
        if(xPosition >= (posicionLadoDerecho - diameter)) {   
            xPosition = (int)(posicionLadoDerecho - diameter);
            xSpeed = -1;                                
        }
        if(xPosition <= (posicionLadoIzquierdo )) {   
            xPosition = (int)(posicionLadoIzquierdo);
            xSpeed = 1;                                
        }
        //         if(xPosition >= (posicionLadoIzquierdo - diameter)) {   
        //             xPosition = (int)(posicionLadoIzquierdo - diameter);
        //             xSpeed = 1;                                
        //         }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
