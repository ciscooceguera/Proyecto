import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CardDraw5 extends JuegoDePoker {
    public CardDraw5(int numJugadores) {
        super(numJugadores);
        crearInterfaz();
    }

    public void crearInterfaz(){
        JFrame ventana = new JFrame("5 Card Draw");
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(45,87,44));
        ventana.setSize(1250,900);

        JPanel botones = new JPanel();
        botones.setLayout(null);
        botones.setBackground(new Color(45,87,44));
        botones.setBounds(0,700, 1200, 200);
        JButton fold = new JButton("Fold");
        JButton check = new JButton("Check");
        JButton raise = new JButton("Raise");
        JButton bet = new JButton("Bet");
        JButton call = new JButton("Call");
        call.setBackground(new Color(255,255,255));
        call.setFont(new Font("Arial",Font.BOLD,20));
        call.setBounds(150,50,100,50);
        fold.setBackground(new Color(255,255,255));
        fold.setFont(new Font("Arial",Font.BOLD,20));
        fold.setBounds(350,50,100,50);
        raise.setBackground(new Color(255,255,255));
        raise.setFont(new Font("Arial",Font.BOLD,20));
        raise.setBounds(550,50,100,50);
        check.setBackground(new Color(255,255,255));
        check.setFont(new Font("Arial",Font.BOLD,20));
        check.setBounds(750,50,100,50);
        bet.setBackground(new Color(255,255,255));
        bet.setFont(new Font("Arial",Font.BOLD,20));
        bet.setBounds(950,50,100,50);
        botones.add(call);
        botones.add(fold);
        botones.add(check);
        botones.add(bet);
        botones.add(raise);
        ventana.add(botones);

        JPanel informacionPartida = new JPanel();
        informacionPartida.setLayout(new GridLayout(1,2));
        informacionPartida.setBackground(new Color(45,87,44));
        informacionPartida.setBounds(425,550, 400, 100);
        JTextArea turno = new JTextArea();
        turno.setEditable(false);
        turno.setFont(new Font("Monospaced", Font.BOLD, 30));
        TitledBorder turnoTitulo = BorderFactory.createTitledBorder("Turno:");
        turnoTitulo.setTitleColor(new Color(255,255,255));
        turno.setBorder(turnoTitulo);
        turno.setBackground(new Color(45,87,44));
        JTextArea dinero = new JTextArea();
        dinero.setEditable(false);
        dinero.setFont(new Font("Monospaced", Font.BOLD, 30));
        TitledBorder dineroTitulo = BorderFactory.createTitledBorder("Dinero: ");
        dineroTitulo.setTitleColor(new Color(255,255,255));
        dinero.setBorder(dineroTitulo);
        dinero.setBackground(new Color(45,87,44));
        informacionPartida.add(turno);
        informacionPartida.add(dinero);
        ventana.add(informacionPartida);

        JPanel cartasJugador = new JPanel();
        cartasJugador.setLayout(new GridLayout(1,5));
        cartasJugador.setBackground(new Color(255,255,255));
        cartasJugador.setBounds(250,175, 750, 200);
        ventana.add(cartasJugador);

        JTextArea bote = new JTextArea();
        bote.setLayout(null);
        bote.setBackground(Color.RED);
        bote.setBounds(50,350, 100, 200);
        TitledBorder boteTitulo = BorderFactory.createTitledBorder("Bote: ");
        boteTitulo.setTitleColor(new Color(255,255,255));
        bote.setBorder(boteTitulo);
        ventana.add(bote);

        JTextArea informacionJugadores = new JTextArea();
        informacionJugadores.setLayout(null);
        informacionJugadores.setBackground(Color.RED);
        informacionJugadores.setBounds(1050,250, 150, 400);
        TitledBorder jugadores = BorderFactory.createTitledBorder("Jugadores: ");
        jugadores.setTitleColor(new Color(255,255,255));
        informacionJugadores.setBorder(jugadores);
        ventana.add(informacionJugadores);

        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void repartirManos() {

    }
}
