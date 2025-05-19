import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TexasHoldEm extends JuegoDePoker {
    private ArrayList<Carta> cartasComunitarias;
    Ventana ventana;
    public TexasHoldEm(int numJugadores){
        super(numJugadores);
        iniciarJuego();
        entregarDinero();
    }
  
    public void iniciarJuego(){
        ventana = new Ventana("Texas HoldEm");
    }
    // implementa repartirManos() que es abstracto, llena el arraylist de manos de acuerdo al # de jugadores
    @Override
    public void repartirManos(){
        for (int i = 0; i < numJugadores; i++){
           manos.add(new Mano(mazo.tomarCartas(2)));
        }
    }

    public void entregarDinero(){
        Object[] botones = {"200","500","1000"};
        ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\dineroPregunta.png");
        Image preImagen = imagen.getImage();
        imagen = new ImageIcon(preImagen.getScaledInstance(50,50,Image.SCALE_SMOOTH));
        int opcionDinero = JOptionPane.showOptionDialog(null,
                "¿Cuánto dinero quieres que tenga cada jugador?", "Dinero",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, imagen
                ,botones, botones[0]);
        int dineroInicial=0;
        switch(opcionDinero){
            case 0:
                dineroInicial=200;
                break;
            case 1:
                dineroInicial=500;
                break;
            case 2:
                dineroInicial=1000;
                break;
            default:
                dineroInicial=0;
        }
        for(int i=0;i<numJugadores;i++){
            dinero[i]=dineroInicial;
            System.out.println(dinero[i]);
        }
    }

    public void preguntarCiega() {
        int ciegaPequeña = 0;
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
        dinero[jugadorEnTurno]-=ciegaPequeña;
        bote+=ciegaPequeña;
    }

    public void pagarCiegaGrande(){
        dinero[jugadorEnTurno]-=ciegaGrande;
        bote+=ciegaGrande;
    }
    public void apostar(int dineroApostado){
        dinero[jugadorEnTurno]-=dineroApostado;
        bote+=dineroApostado;
        apuestaMasGrande=dineroApostado;
        ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\apuestaImagen.png");
        Image imagenAEscalar = imagen.getImage();
        JOptionPane.showMessageDialog(null,
                "Jugador "+jugadorEnTurno+" ha apostado +"+apuestaMasGrande+"!",
                "Anuncio de Apuesta",JOptionPane.INFORMATION_MESSAGE,
                imagen);
    }
    public void callear(){
        dinero[jugadorEnTurno]-=apuestaMasGrande;
        bote+=apuestaMasGrande;
        ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\callImagen.png");
        Image imagenAEscalar = imagen.getImage();
        imagen = new ImageIcon(imagenAEscalar.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null,
                "Jugador "+jugadorEnTurno+" ha apostado +"+apuestaMasGrande+"!",
                "Anuncio de Call",JOptionPane.INFORMATION_MESSAGE,
                imagen);
    }
    public void foldear(){
        manos.remove(jugadorEnTurno);
        ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\quitImagen.png");
        Image imagenAEscalar = imagen.getImage();
        imagen = new ImageIcon(imagenAEscalar.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null,
                "Jugador "+jugadorEnTurno+" ha foldeado!",
                "Anuncio de Fold",JOptionPane.INFORMATION_MESSAGE,
                imagen);
    }
}