import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

public abstract class JuegoDePoker   {
    ArrayList<Integer> foldJugadores;
    protected Mazo mazo;
    protected ArrayList<Jugador> jugadores;
    protected int numJugadores, ciegaPequeña, ciegaGrande, boteInt, jugadorEnTurno, apuestaMasGrande, dineroInicial;

    public JuegoDePoker(int numJugadores) {
        this.numJugadores = numJugadores;
        mazo = new Mazo();
        foldJugadores = new ArrayList<>();
        jugadores = new ArrayList<>();
        ciegaPequeña = 0;
        ciegaGrande = 0;
        boteInt = 0;
        jugadorEnTurno = 1;
        apuestaMasGrande = 0;
        inicializarComponentes();
    }
    // inicializa el mazo y llama repartir manos
    public void inicializarComponentes() {
        mazo.crearMazo();
        mazo.revolverMazo();
        entregarDinero();
        pedirNombresJugadores();
        repartirManos();
    }
    //Se encarga de pedir los nombres a cada jugador.
    public void pedirNombresJugadores() {
        for (int i = 0; i< numJugadores; i++){
            String nombre = JOptionPane.showInputDialog(null,
                    "Ingresa el nombre del jugador: ","Nombres",
                    JOptionPane.QUESTION_MESSAGE);
            jugadores.add(new Jugador(nombre,dineroInicial));
        }
    }
    //Se encarga de entregar una cantidad de dinero que se elige a cada jugador.
    public void entregarDinero() {
        Object[] botones = {"200", "500", "1000"};
        ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\dineroPregunta.png");
        Image preImagen = imagen.getImage();
        imagen = new ImageIcon(preImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        int opcionDinero = JOptionPane.showOptionDialog(null,
                "¿Cuánto dinero quieres que tenga cada jugador?", "Dinero",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, imagen
                , botones, botones[0]);
        switch (opcionDinero) {
            case 0:
                dineroInicial = 200;
                break;
            case 1:
                dineroInicial = 500;
                break;
            case 2:
                dineroInicial = 1000;
                break;
            default:
                dineroInicial = 0;
        }
    }
    // reparte las manos de los jugadores
    public abstract void repartirManos();
}