import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.*;
import java.util.HashMap;

public abstract class JuegoDePoker {
    protected Mazo mazo;
    protected ArrayList<Mano> manos;
    protected int numJugadores, ciegaPequeña, ciegaGrande, bote, jugadorEnTurno, apuestaMasGrande;
    protected int[] dinero;
    protected HashMap<String,Integer> jugadores;
    protected int numJugadores;
    public JuegoDePoker(int numJugadores) {
        this.numJugadores = numJugadores;
        mazo = new Mazo();
        manos = new ArrayList<>();
        dinero = new int[numJugadores];
        jugadores = new HashMap<>();
        inicializarComponentes();
        ciegaPequeña = 0;
        ciegaGrande = 0;
        bote = 0;
        jugadorEnTurno = 0;
        apuestaMasGrande = 0;
    }
    // inicializa el mazo y llama repartir manos
    public void inicializarComponentes() {
        mazo.crearMazo();
        mazo.revolverMazo();
        repartirManos();
    }
    // obtiene la jugada más alta de la mano
    public String obtenerJugada(){
        return obtenerJugada();
    }
    // reparte las manos de los jugadores
    public abstract void repartirManos();

}
