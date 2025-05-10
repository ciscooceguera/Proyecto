import java.util.ArrayList;

public abstract class JuegoDePoker {
    protected Mazo mazo;
    protected ArrayList<Mano> manos;
    protected int numJugadores;
    public JuegoDePoker(int numJugadores) {
        this.numJugadores = numJugadores;
        mazo = new Mazo();
        manos = new ArrayList<>();
        inicializarComponentes();
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
