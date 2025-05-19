import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TexasHoldEm extends JuegoDePoker {
    private ArrayList<Carta> cartasComunitarias;
    private Ventana ventana;
    public TexasHoldEm(int numJugadores,String tipoPoker){
        super(numJugadores,tipoPoker);
        iniciarJuego();
    }
    public void iniciarJuego(){
        ventana = new Ventana("Texas HoldEm",this);
        ventana.setVisible(true);
        mostrarDineroTurnoActual();
        mostrarManoEnTurno();
        mostrarDineroEnElBote();
        mostrarMensajeEnBanner();
        preguntarCiega();
        pagarCiegaPequeña();
        cambiarTurno();
        pagarCiegaGrande();
        cambiarTurno();
    }
    /*
    public void nuevaRonda(){
        boteInt = 0;
        jugadorEnTurno = 1;
        mazo.clearMazo();
        mazo.crearMazo();
        mazo.revolverMazo();
        repartirManos();
        mostrarDineroTurnoActual();
        mostrarManoEnTurno();
        mostrarDineroEnElBote();
        mostrarMensajeEnBanner();
        pagarCiegaPequeña();
        cambiarTurno();
        pagarCiegaGrande();
        cambiarTurno();
    }
    */

    public void mostrarManoEnTurno(){
        ventana.mostrarCartasJugadorTurno(jugadores.get(jugadorEnTurno-1).getMano());
    }
    // implementa repartirManos() que es abstracto, llena el arraylist de manos de acuerdo al # de jugadores
    @Override
    public void repartirManos(){
        for (int i = 0; i < numJugadores; i++){
           Jugador jugador = jugadores.get(i);
           jugador.setMano(new Mano(mazo.tomarCartas(2)));
           jugadores.set(i, jugador);
        }
    }
    public void mostrarDineroEnElBote(){
        ventana.mostrarPot(boteInt);
    }
    public void mostrarDineroTurnoActual(){
        ventana.setTextDineroJugador(jugadores.get(jugadorEnTurno-1).getDinero());
    }
    public void mostrarMensajeEnBanner(){
        ventana.mostrarMensajeTurno(jugadores.get(jugadorEnTurno-1).getNombre());
    }
    public void cambiarTurno(){
        int jugadorHizoFold = 1;
        while (jugadorHizoFold == 1) {
            jugadorEnTurno = jugadorEnTurno % numJugadores + 1;
            if (!foldJugadores.contains(jugadorEnTurno)) {
                jugadorHizoFold=0;
            }else if (evaluarJugadorSinDinero()){
                jugadores.remove(jugadorEnTurno);
            }
        }
        mostrarDineroTurnoActual();
        mostrarDineroEnElBote();
        mostrarMensajeEnBanner();
        if (verificarNumJugadoresRestantes()==1){
            finRonda();
        }
    }
    public boolean evaluarJugadorSinDinero(){
        if (jugadores.get(jugadorEnTurno-1).getDinero() == 0){
            return true;
        }
        return false;
    }
    public void finRonda(){
        JOptionPane.showMessageDialog(null,"Ganador ronda: " + jugadores.get(jugadorEnTurno-1).getNombre());
        //nuevaRonda();
    }
    public void finDelJuego(){
        JOptionPane.showMessageDialog(null,"Ganador juego: " + jugadores.get(jugadorEnTurno-1).getNombre());
        ventana.endGame();
    }
    public int verificarNumJugadoresRestantes(){
        if (jugadores.size()-foldJugadores.size() == 1){
            return 1;
        }
        return 0;
    }

    public void preguntarCiega() {
        while (ciegaPequeña < 1 || ciegaPequeña > 10) {
            String ciegaStr = JOptionPane.showInputDialog(null,
                    "¿Cuánto se pagará de ciega pequeña? $1-$10", "Ciega pequeña",
                    JOptionPane.QUESTION_MESSAGE);
            ciegaPequeña = Integer.parseInt(ciegaStr);
            ciegaGrande = ciegaPequeña*2;
            if(ciegaPequeña < 1 || ciegaPequeña > 10 ){
                JOptionPane.showMessageDialog(null,
                        "Precio de ciega no válido",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void pagarCiegaPequeña(){
        Jugador jugador = jugadores.get(jugadorEnTurno-1);
        jugador.reducirDinero(ciegaPequeña);
        jugadores.set(jugadorEnTurno-1, jugador);
        boteInt+=ciegaPequeña;
        ventana.mostrarPot(boteInt);
    }

    public void pagarCiegaGrande(){
        Jugador jugador = jugadores.get(jugadorEnTurno-1);
        jugador.reducirDinero(ciegaGrande);
        jugadores.set(jugadorEnTurno-1, jugador);
        boteInt+=ciegaGrande;
        ventana.mostrarPot(boteInt);
    }
    public void subir(){
        String apuesta = JOptionPane.showInputDialog(null,"Ingresa dinero: ","Apuesta",JOptionPane.PLAIN_MESSAGE);
        int dineroApostado = Integer.parseInt(apuesta);
        Jugador jugador = jugadores.get(jugadorEnTurno-1);
        jugador.reducirDinero(dineroApostado);
        jugadores.set(jugadorEnTurno-1, jugador);
        boteInt+=dineroApostado;
        ventana.mostrarPot(boteInt);
        apuestaMasGrande=dineroApostado;
        ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\apuestaImagen.png");
        Image imagenAEscalar = imagen.getImage();
        JOptionPane.showMessageDialog(null,
                "Jugador "+jugadorEnTurno+" ha apostado +"+apuestaMasGrande+"!",
                "Anuncio de Apuesta",JOptionPane.INFORMATION_MESSAGE,
                imagen);
    }
    public void callear(){
        Jugador jugador = jugadores.get(jugadorEnTurno-1);
        jugador.reducirDinero(apuestaMasGrande);
        jugadores.set(jugadorEnTurno-1, jugador);
        boteInt+=apuestaMasGrande;
        ventana.mostrarPot(boteInt);
        ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\callImagen.png");
        Image imagenAEscalar = imagen.getImage();
        imagen = new ImageIcon(imagenAEscalar.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null,
                "Jugador "+jugadorEnTurno+" ha apostado +"+apuestaMasGrande+"!",
                "Anuncio de Call",JOptionPane.INFORMATION_MESSAGE,
                imagen);
    }
    public void foldear(){
        foldJugadores.add(jugadorEnTurno-1);
        cambiarTurno();
    }
    public void check(){

    }

}