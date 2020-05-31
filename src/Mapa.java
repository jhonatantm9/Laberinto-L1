
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Mapa {
    
    public int filas=14;
    public int columnas=14;
    public int tamanoBloque=40;
    Color verdeClaro = new Color(182,255,175);
    Color amarilloClaro = new Color(255,255,45);
    
    /*Matriz de juego, donde los 0 y 3 representan espacios vacíos, los 1
    representan bloques, 2 representa la casilla final y los 3 son las casillas
    por donde debe pasar para ganar
    */
    public static int[][] matrizJuego = {
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1}, {1,3,3,0,0,1,1,1,1,0,1,1,0,1},
    {1,1,3,1,1,1,0,0,1,3,3,3,3,1}, {1,1,3,0,0,1,1,0,1,3,1,1,3,1},
    {1,0,3,1,0,0,1,0,1,3,1,1,3,1}, {1,1,3,1,0,1,1,0,1,3,0,1,3,1},
    {1,0,3,1,0,0,0,0,1,3,1,1,3,1}, {1,1,3,1,1,1,1,1,1,3,0,1,3,1},
    {1,1,3,3,3,3,3,3,3,3,1,1,3,1}, {1,1,0,1,1,1,1,1,1,0,1,1,3,1},
    {1,0,0,0,0,0,0,0,1,0,1,3,3,1}, {1,1,0,1,1,1,1,0,1,1,0,3,1,1},
    {1,0,0,0,0,0,0,1,1,1,1,3,2,1}, {1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    
    /**
     * Permite pintar el mapa del juego, los bloques sólidos y la solución
     * cuando se presione el botón de presionar solución
     * @param grafico Permite dar color y forma a los elementos
     */
    public void paint(Graphics grafico){
                
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(matrizJuego[i][j]==1){//Bloque sólido
                    grafico.setColor(Color.DARK_GRAY);
                    grafico.fillRect(j*40, i*40, tamanoBloque, tamanoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(j*40, i*40, tamanoBloque, tamanoBloque);
                }
                else if(matrizJuego[i][j]==2){//Casilla final (meta)
                    grafico.setColor(verdeClaro);
                    grafico.fillRect(j*40, i*40, tamanoBloque, tamanoBloque);
                }
                if(Juego.mostrarSolucion && matrizJuego[i][j]==3){
                    //Casillas por donde se llega a la meta
                    grafico.setColor(amarilloClaro);
                    grafico.fillRect(j*40, i*40, tamanoBloque, tamanoBloque);
                }
            }
        }
    }
}
