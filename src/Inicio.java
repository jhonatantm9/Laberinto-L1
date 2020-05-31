
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Inicio {
    /*public static void main(String[] args){
        //Se crea la ventana de inicio del juego
        JFrame inicio = new JFrame();
        inicio.setSize(400,300);
        //Texto con las instrucciones del juego
        JTextArea texto = new JTextArea("Para jugar, presiona continuar y usa "
                + "las felchas\npara moverte en el laberinto\n"+"Si necesitas ayuda,"
                + " presiona el botón Mostrar Solución");
        Font fuente2 = new Font("Calibri",0,14);        
        texto.setFont(fuente2);
        texto.setEditable(false);
        
        //Título de la ventana de inicio
        JLabel titulo = new JLabel("Laberinto");
        Font fuente1 = new Font("Calibri",3,30);
        titulo.setFont(fuente1);
        
        //Botón de la ventana de inicio
        JButton continuar = new JButton("Continuar");        
        continuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Juego juego = new Juego();
                inicio.setVisible(false);
            }
        });        
        
        //Se añaden los componentes a la ventana de inicio
        inicio.setLayout(null);
        inicio.add(titulo).setBounds(150,20,200,50);
        inicio.add(texto).setBounds(30,70,320,60);
        inicio.add(continuar).setBounds(150,200,100,30);
        //Se ajusta la ventana de inicio, para mostrarse al iniciar
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
    }*/
}
