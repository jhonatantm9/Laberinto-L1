

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Juego extends JPanel{
    
    Player jugador = new Player();
    Mapa mapa = new Mapa();    
    public static boolean mostrarSolucion=false;
    public static boolean juegoCompletado=false;
    /**
     * Verifica si se presiona una tecla. La entrada se envía al jugador, donde
     * se verifica si es una flecha direccional y se produce el movimiento
     */
    public Juego(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
              
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                jugador.movimientoUsuario(ke);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
        });
        setFocusable(true);
    }
    
    public static void main(String[] args){
        
        
        /*Se crea la ventana principal del juego y se le añade la clase juego,
        que permite mostrar el mapa, el jugador y los botones de solución
        */
        JFrame ventana = new JFrame();
        Juego juego = new Juego();
        ventana.add(juego);
        ventana.setSize(900,600);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Se crea un nuevo botón que muestra la solución del laberinto
        JButton botonMostrar = new JButton("Mostrar Solución");
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mostrarSolucion=true;
                ventana.setFocusable(true);
            }
        });
        botonMostrar.setFocusable(false);
        ventana.setLayout(null);
        ventana.add(botonMostrar).setBounds(650, 350, 150, 30);
        //Se crea un botón que oculta la solución del laberinto
        JButton botonOcultar = new JButton("Ocultar Solución");
        botonOcultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mostrarSolucion=false;
            }
        });
        botonOcultar.setFocusable(false);
        ventana.add(botonOcultar).setBounds(650, 400, 150, 30);
        //Se crea un texto con instrucciones
        JTextArea texto = new JTextArea("Para jugar, usa las felchas para\n"
                + "moverte en el laberinto\nSi necesitas ayuda,"
                + " presiona el botón\n Mostrar Solución");
        Font fuente2 = new Font("Calibri",0,16);        
        texto.setFont(fuente2);
        texto.setEditable(false);
        texto.setFocusable(false);
        ventana.add(texto).setBounds(610,160,240,80);
        //Se crea el título de la ventana
        JLabel titulo = new JLabel("Laberinto");
        Font fuente1 = new Font("Calibri",3,30);
        titulo.setFont(fuente1);
        titulo.setFocusable(false);
        ventana.add(titulo).setBounds(660,100,150,30);
                
        
        //Este ciclo, vuelve a pintar la ventana, para mostrar los movimientos del jugador
        while(true){
            //Este Try catch, retarda 10 milisegundos la ejecución del ciclo
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            ventana.repaint();
        }
        
    }
    
    /**
     * Este método pinta el juego y el jugador. Basicamente permite
     * visualizar el juego
     * @param grafico 
     */
    @Override
    public void paint(Graphics grafico){        
        mapa.paint(grafico);
        jugador.paint(grafico);
    }
    
}
