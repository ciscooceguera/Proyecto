import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CardDraw5 extends JuegoDePoker {
    public CardDraw5(int numJugadores) {
        super(numJugadores);
        iniciarJuego();
    }

    public void iniciarJuego() {
        Ventana ventana = new Ventana("Card Draw 5",this);
    }

    @Override
    public void repartirManos() {
        for(int i=0; i<numJugadores; i++){
          //  manos.add(new Mano(mazo.tomarCartas(5)));
        }
    }
}
