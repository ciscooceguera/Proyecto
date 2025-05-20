import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
public class TexasHoldEm extends JuegoDePoker {
    private int countRondas = 0;
    private int countCalls = 0;
    private ArrayList<Carta> cartasComunitarias;
    private Ventana ventana;
    public TexasHoldEm(int numJugadores){
        super(numJugadores);
        cartasComunitarias = new ArrayList<>();
        iniciarJuego();
    }
    // Controlar el flujo del juego
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
        iniciarCartasComunitarias();
    }
    // Se encarga de reiniciar los componentes en caso de que haya concluido una ronda del juego
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
            iniciarCartasComunitarias();
            System.out.println(cartasComunitarias);
        }
    }
    // Se encarga de inicializar las cartas comunitarias del juego (3 cartas)
    public void iniciarCartasComunitarias(){
        cartasComunitarias = mazo.tomarCartas(3);
        ventana.mostrarCartasComunitarias(cartasComunitarias);
    }
    // Añade exclusivamente una sola carta al ArrayList de cartas comunitarias
    public void agregarCartaComunitaria(){
      if (!(cartasComunitarias.size() == 5)){
            cartasComunitarias.add(mazo.tomarCarta());
            ventana.mostrarCartasComunitarias(cartasComunitarias);
        }else{
          finRonda();
      }
    }
    // Muestra en el JFrame la mano contenido del jugador en turno actual
    public void mostrarManoEnTurno(){
        ventana.mostrarCartasJugadorTurno(jugadores.get(jugadorEnTurno-1).getMano());
    }
    // Implementa repartirManos() que es abstracto, llena el arraylist de manos de acuerdo al # de jugadores
    @Override
    public void repartirManos(){
        for (int i = 0; i < jugadores.size(); i++){
           Jugador jugador = jugadores.get(i);
           jugador.setMano(new Mano(mazo.tomarCartas(2)));
           jugadores.set(i, jugador);
        }
    }
    // Actualiza el dinero total contenido en el pot, en el JFrame
    public void mostrarDineroEnElBote(){
        ventana.mostrarPot(boteInt);
    }
    // Actualiza el dinero total del jugador en turno actual, en el JFrame
    public void mostrarDineroTurnoActual(){
        ventana.setTextDineroJugador(jugadores.get(jugadorEnTurno-1).getDinero());
        mostrarManoEnTurno();
    }
    // Actualiza un mensaje en el JFrame que representa el turno del jugador actual
    public void mostrarMensajeEnBanner(){
        ventana.mostrarMensajeTurno(jugadores.get(jugadorEnTurno-1).getNombre());
    }
    // Se encarga de gestionar el cambio de turno
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
    // Se encarga de evaluar y remover aquellos jugadores que ya no tienen dinero
    public void evaluarJugadorSinDinero(){
        jugadores.removeIf(jugador -> jugador.getDinero()<=0);
    }
    // Se encarga de la lógica tras el final de una ronda para determinar el ganador
    public void finRonda(){
        if (verificarNumJugadoresRestantes()==1) {
            for (int i = 0; i < jugadores.size(); i++) {
                if (!foldJugadores.contains(i)) {
                    JOptionPane.showMessageDialog(null,"Ganador ronda: " + jugadores.get(i).getNombre());
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
        }
        nuevaRonda();
    }
    // Se encarga de la lógica para concluir el juego, cuando solo queda un jugador con dinero
    public void finDelJuego(){
        JOptionPane.showMessageDialog(null,"Ganador juego: " + jugadores.getFirst().getNombre());
        ventana.dispose();
    }
    // Evalúa cuántos jugadores no han foldeado
    public int verificarNumJugadoresRestantes(){
        if (jugadores.size()-foldJugadores.size() == 1){
            return 1;
        }
        return 0;
    }
    // Pregunta la ciega que se pagará en la partida
    public void preguntarCiega() {
        while (ciegaPequeña < 1 || ciegaPequeña > 10) {
            String ciegaStr = JOptionPane.showInputDialog(null,
                    "¿Cuánto se pagará de ciega pequeña? $1-$10", "Ciega pequeña",
                    JOptionPane.QUESTION_MESSAGE);
            ciegaPequeña = Integer.parseInt(ciegaStr);
            ciegaGrande = ciegaPequeña*2;
            apuestaMasGrande = ciegaGrande;
            if(ciegaPequeña < 1 || ciegaPequeña > 10 ){
                JOptionPane.showMessageDialog(null,
                        "Precio de ciega no válido",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    // Se encarga de cobrarle al jugador respectivo la ciega pequeña
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
    // Se encarga de cobrarle al jugador respectivo la ciega grande
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
    // Se encarga de la lógica cuando se busca subir la apuesta
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
                cambiarTurno();
                verificarSiYaTodosDecidieronAcciones();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Apuesta mínima " + apuestaMasGrande,
                        "Anuncio de Apuesta", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    // Se encarga de la lógica cuando el jugador decide callear
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
    // Se encarga de la lógica cuando el jugador desea foldear
    public void foldear(){
        foldJugadores.add(jugadorEnTurno-1);
        cambiarTurno();
        verificarSiYaTodosDecidieronAcciones();
    }
    // Se encarga de la lógica cuando el jugador desea hacer check
    public void check(){
        cambiarTurno();
        verificarSiYaTodosDecidieronAcciones();
    }
    /* Se encarga de determinar si ya todos los jugadores tomaron una accion,
       es decir, que el juego ya dio un giro de turnos completo
    */
    public void  verificarSiYaTodosDecidieronAcciones(){
        if (jugadorEnTurno-1 == 0){
            if (countRondas >= 1){
                agregarCartaComunitaria();
            }
        }
        countRondas++;
    }
    // Se encarga de actualizar el dinero de los jugadores en el JFrame
    public void actualizarDineroPlayers(){
        ventana.mostrarDineroDeTodosLosJugadores(jugadores);
    }
}