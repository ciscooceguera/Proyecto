import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class CardDraw5 extends JuegoDePoker {
    private int countRondas = 0;
    private int countCalls = 0;
    private ArrayList<Carta> cartasComunitarias;
    private Ventana ventana;

    public CardDraw5(int numJugadores) {
        super(numJugadores);
        cartasComunitarias = new ArrayList<>();
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
        actualizarDineroPlayers();
        ventana.mostrarManos(jugadores);
    }

    public void nuevaRonda(){
        jugadores.getLast().incrementarDinero(boteInt);
        evaluarJugadorSinDinero();
        if (jugadores.size() == 1){
            finDelJuego();
        }else {
            countRondas = 0;
            cartasComunitarias.clear();
            ventana.reiniciarCartasComunitarias();
            ventana.setVisible(true);
            boteInt = 0;
            mostrarDineroTurnoActual();
            mostrarManoEnTurno();
            mostrarDineroEnElBote();
            mostrarMensajeEnBanner();
            countCalls = 2;
            apuestaMasGrande = 0;
            jugadorEnTurno = 1;
            mazo.clearMazo();
            mazo.crearMazo();
            mazo.revolverMazo();
            foldJugadores.clear();
            repartirManos();
            pagarCiegaPequeña();
            cambiarTurno();
            pagarCiegaGrande();
            cambiarTurno();
            actualizarDineroPlayers();
            ventana.mostrarManos(jugadores);
            System.out.println(cartasComunitarias);
        }
    }

    public void mostrarManoEnTurno(){
        ventana.mostrarCartasJugadorTurno(jugadores.get(jugadorEnTurno-1).getMano());
    }

    // implementa repartirManos() que es abstracto, llena el arraylist de manos de acuerdo al # de jugadores
    @Override
    public void repartirManos(){
        for (int i = 0; i < jugadores.size(); i++){
            Jugador jugador = jugadores.get(i);
            jugador.setMano(new Mano(mazo.tomarCartas(5)));
            jugadores.set(i, jugador);
        }
    }

    public void mostrarDineroEnElBote(){
        ventana.mostrarPot(boteInt);
    }

    public void mostrarDineroTurnoActual(){
        ventana.setTextDineroJugador(jugadores.get(jugadorEnTurno-1).getDinero());
        mostrarManoEnTurno();
    }

    public void mostrarMensajeEnBanner(){
        ventana.mostrarMensajeTurno(jugadores.get(jugadorEnTurno-1).getNombre());
    }

    public void cambiarTurno(){
        int jugadorHizoFold = 1;
        while (jugadorHizoFold == 1) {
            jugadorEnTurno = jugadorEnTurno % jugadores.size() + 1;
            if (!foldJugadores.contains(jugadorEnTurno-1)) {
                jugadorHizoFold=0;
            }
        }
        mostrarDineroTurnoActual();
        mostrarDineroEnElBote();
        mostrarMensajeEnBanner();
        if (verificarNumJugadoresRestantes()==1 || (cartasComunitarias.size()==5 && jugadorEnTurno == 1)
                && countCalls == jugadores.size() - foldJugadores.size()){
            finRonda();
        }
        actualizarDineroPlayers();
    }

    public void evaluarJugadorSinDinero(){
        jugadores.removeIf(jugador -> jugador.getDinero()<=0);
    }

    public void finRonda(){
        int posicionGanador = 0;
        if (verificarNumJugadoresRestantes()==1) {
            for (int i = 0; i < jugadores.size(); i++) {
                if (!foldJugadores.contains(i)) {
                    JOptionPane.showMessageDialog(null,"Ganador ronda: " + jugadores.get(posicionGanador).getNombre());
                    nuevaRonda();
                }
            }
        }else{
            for (int i = 0; i < jugadores.size(); i++) {
                if (!foldJugadores.contains(i)) {
                    Mano mano = jugadores.get(i).getMano();
                    mano.concatenarCartas(cartasComunitarias);
                    Jugador newJugador = jugadores.get(i);
                    newJugador.setManoComunitaria(mano);
                    jugadores.set(i, newJugador);
                }
            }
            Collections.sort(jugadores);
            JOptionPane.showMessageDialog(null,"Ganador ronda: " + jugadores.getLast().getNombre());
            nuevaRonda();
        }
    }

    public void finDelJuego(){
        JOptionPane.showMessageDialog(null,"Ganador juego: " + jugadores.getFirst().getNombre());
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
        if (jugador.getDinero() >= ciegaPequeña) {
            jugador.reducirDinero(ciegaPequeña);
            jugadores.set(jugadorEnTurno - 1, jugador);
            boteInt += ciegaPequeña;
        }else{
            jugador.reducirDinero(jugador.getDinero());
            jugadores.set(jugadorEnTurno - 1, jugador);
            boteInt += jugador.getDinero();
        }
        ventana.mostrarPot(boteInt);
        countCalls++;
    }

    public void pagarCiegaGrande(){
        Jugador jugador = jugadores.get(jugadorEnTurno-1);
        if (jugador.getDinero() >= ciegaGrande) {
            jugador.reducirDinero(ciegaGrande);
            jugadores.set(jugadorEnTurno - 1, jugador);
            boteInt += ciegaGrande;
        }else{
            jugador.reducirDinero(jugador.getDinero());
            jugadores.set(jugadorEnTurno - 1, jugador);
            boteInt += jugador.getDinero();
        }
        ventana.mostrarPot(boteInt);
        countCalls++;
        if (countCalls == jugadores.size()-foldJugadores.size()){
            ventana.switchCallPorCheck();
        }
    }

    public void subir(){
        String apuesta = JOptionPane.showInputDialog(null,"Ingresa dinero: ","Apuesta",JOptionPane.PLAIN_MESSAGE);
        int dineroApostado = Integer.parseInt(apuesta);
        if (dineroApostado > jugadores.get(jugadorEnTurno-1).getDinero()){
            JOptionPane.showMessageDialog(null,
                    "No tienes dinero suficiente",
                    "Anuncio de Apuesta",JOptionPane.INFORMATION_MESSAGE);
        }else {
            if (dineroApostado > apuestaMasGrande) {
                Jugador jugador = jugadores.get(jugadorEnTurno - 1);
                jugador.reducirDinero(dineroApostado);
                jugadores.set(jugadorEnTurno - 1, jugador);
                ventana.switchCheckPorCall();
                boteInt += dineroApostado;
                ventana.mostrarPot(boteInt);
                apuestaMasGrande = dineroApostado;
                countCalls = 1;
                ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\apuestaImagen.png");
                Image imagenAEscalar = imagen.getImage();
                cambiarTurno();
                verificarSiYaTodosDecidieronAcciones();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Apuesta mínima " + apuestaMasGrande,
                        "Anuncio de Apuesta", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void callear(){
        countCalls++;
        if (jugadores.get(jugadorEnTurno-1).getDinero() != 0) {
            Jugador jugador = jugadores.get(jugadorEnTurno - 1);
            if (apuestaMasGrande < jugadores.get(jugadorEnTurno - 1).getDinero()) {
                jugador.reducirDinero(apuestaMasGrande);
            } else {
                jugador.reducirDinero(jugador.getDinero());
            }
            jugadores.set(jugadorEnTurno - 1, jugador);
            boteInt += apuestaMasGrande;
            ventana.mostrarPot(boteInt);
            ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\callImagen.png");
            Image imagenAEscalar = imagen.getImage();
            imagen = new ImageIcon(imagenAEscalar.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        /*JOptionPane.showMessageDialog(null,
                "Jugador "+jugadorEnTurno+" ha apostado +"+apuestaMasGrande+"!",
                "Anuncio de Call",JOptionPane.INFORMATION_MESSAGE,
                imagen);*/
            cambiarTurno();
            verificarSiYaTodosDecidieronAcciones();
        }else{
            cambiarTurno();
            verificarSiYaTodosDecidieronAcciones();
        }
        if (countCalls == jugadores.size()-foldJugadores.size()){
            ventana.switchCallPorCheck();
            apuestaMasGrande = 0;
        }
    }

    public void foldear(){
        foldJugadores.add(jugadorEnTurno-1);
        cambiarTurno();
        verificarSiYaTodosDecidieronAcciones();
    }
    public void check(){
        cambiarTurno();
        verificarSiYaTodosDecidieronAcciones();
    }

    public void  verificarSiYaTodosDecidieronAcciones(){
        if (jugadorEnTurno-1 == 0){
            if (countRondas >= 1){

            }
            countRondas++;
        }
    }

    public void actualizarDineroPlayers(){
        ventana.mostrarDineroDeTodosLosJugadores(jugadores);
    }
}
