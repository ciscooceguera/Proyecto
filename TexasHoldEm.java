import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TexasHoldEm extends JuegoDePoker {
    private ArrayList<Carta> cartasComunitarias;
    public TexasHoldEm(int numJugadores){
        super(numJugadores);
        iniciarJuego();
    }
  
    public void iniciarJuego(){
        Ventana ventana = new Ventana("Texas HoldEm");
    }
    // implementa repartirManos() que es abstracto, llena el arraylist de manos de acuerdo al # de jugadores
    @Override
    public void repartirManos(){
        for (int i = 0; i < numJugadores; i++){
           manos.add(new Mano(mazo.tomarCartas(2)));
        }
    }
}