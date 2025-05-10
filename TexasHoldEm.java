import java.util.ArrayList;
public class TexasHoldEm extends JuegoDePoker {
    private ArrayList<Carta> cartasComunitarias;
    public TexasHoldEm(int numJugadores){
        super(numJugadores);
    }
    public void iniciarJuego(){


    }
    // implementa repartirManos() que es abstracto, llena el arraylist de manos de acuerdo al # de jugadores
    @Override
    public void repartirManos(){
        for (int i = 0; i < numJugadores; i++){
           manos.add(new Mano(mazo.tomarCartas(2)));
        }
    }

}
