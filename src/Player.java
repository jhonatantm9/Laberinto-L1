
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Player {
    
    //Componenetes del jugador: posiciones en la ventana, ancho, altura y 
    //movimiento del jugador
    public int posX=40;
    public int posY=40;
    public int ancho=40;
    public int alto=40;
    public int movimiento =40;
    Color azulClaro = new Color(10,190,225);//Color del jugador en RGB
    
    /**
     * Este método dibuja un círculo que representa al jugador, por medio de
     * la función de "paint"
     * @param grafico Lo que permite hacer las diferentes formas de los gráficos 
     */
    public void paint(Graphics grafico){
        //Los colores se asignan para las acciones que se hacen después de estos
        grafico.setColor(azulClaro);
        grafico.fillOval(posX, posY, ancho, alto);
        grafico.setColor(Color.BLACK);
        grafico.drawOval(posX, posY, ancho, alto);
    }
    
    /**
     * Permite el movimiento del usuario teniendo en cuenta las excepciones de
     * no moverse a través de los bloques sólidos
     * @param evento 
     */
    public void movimientoUsuario(KeyEvent evento){
        //Flecha izquierda, equivalente a la tecla 37
        if(evento.getKeyCode()==37){
            if(Mapa.matrizJuego[(posY/40)][(posX/40)-1]!=1){
                posX=posX-movimiento;
            }
            
        }
        //Flecha derecha, equivalente a la tecla 39
        if(evento.getKeyCode()==39){
            if(Mapa.matrizJuego[(posY/40)][(posX/40)+1]!=1){
                posX=posX+movimiento;
            }
            else{
                
            }
        }
        //Flecha de arriba, equivalente a la tecla 38 
        if(evento.getKeyCode()==38){
            if(Mapa.matrizJuego[(posY/40)-1][(posX/40)]!=1){
                posY=posY-movimiento;
            }
            
        }
        //Flecha de abajo, equivalente a la tecla 40 
        if(evento.getKeyCode()==40){
            if(Mapa.matrizJuego[(posY/40)+1][(posX/40)]!=1){
                posY=posY+movimiento;
            }
        }
        //Condicional que verifica si el jugador llegó a la casilla de meta
        if(Mapa.matrizJuego[(posY/40)][(posX/40)]==2){
            /*Panel se selección Sí o No, si se selecciona Sí, se reinicia el juego,
            sino, se sale de la aplicación
            */
            int opcion = JOptionPane.showConfirmDialog(null, "¡Felicidades! Has completado el"
                    + " laberinto. ¿Desea seguir jugando?","Juego Terminado",
                    JOptionPane.YES_NO_OPTION);
            if(opcion==0){
                posX=40;
                posY=40;
            }
            else{
                System.exit(0);
            }
        }
    }
}
