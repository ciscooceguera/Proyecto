import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class Ventana extends JFrame {
    protected JPanel botones = new JPanel();
    protected JButton fold = new JButton("Fold");
    protected JButton check = new JButton("Check");
    protected JButton raise = new JButton("Raise");
    protected JButton bet = new JButton("Bet");
    protected JButton call = new JButton("Call");
    protected JPanel cartasJugador = new JPanel();
    protected JPanel informacionPartida = new JPanel();
    protected JTextArea turno = new JTextArea();
    protected JTextArea dinero = new JTextArea();
    protected JPanel cartasRonda = new JPanel();
    protected JTextArea bote = new JTextArea();
    protected JTextArea informacionJugadores = new JTextArea();

    public Ventana(String tipoPoker){
        if(tipoPoker.equals("Texas HoldEm")){
            super.setTitle(tipoPoker);
            crearInterfazTexas();
        }else if(tipoPoker.equals("Card Draw 5")){
            super.setTitle("Card Draw 5");
            crearInterfaz5CardDraw();
        }
    }

    public void crearInterfazTexas(){
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(45,87,44));
        this.setSize(1250,900);

        botones.setLayout(null);
        botones.setBackground(new Color(45,87,44));
        botones.setBounds(0,700, 1200, 200);
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
        this.add(botones);

        cartasJugador.setLayout(new GridLayout(1,2));
        cartasJugador.setBackground(new Color(255,255,255));
        cartasJugador.setBounds(475,300, 300, 200);
        this.add(cartasJugador);

        informacionPartida.setLayout(new GridLayout(1,2));
        informacionPartida.setBackground(new Color(45,87,44));
        informacionPartida.setBounds(425,550, 400, 100);
        turno.setEditable(false);
        turno.setFont(new Font("Monospaced", Font.BOLD, 30));
        TitledBorder turnoTitulo = BorderFactory.createTitledBorder("Turno:");
        turnoTitulo.setTitleColor(new Color(255,255,255));
        turno.setBorder(turnoTitulo);
        turno.setBackground(new Color(45,87,44));
        dinero.setEditable(false);
        dinero.setFont(new Font("Monospaced", Font.BOLD, 30));
        TitledBorder dineroTitulo = BorderFactory.createTitledBorder("Dinero: ");
        dineroTitulo.setTitleColor(new Color(255,255,255));
        dinero.setBorder(dineroTitulo);
        dinero.setBackground(new Color(45,87,44));
        informacionPartida.add(turno);
        informacionPartida.add(dinero);
        this.add(informacionPartida);

        cartasRonda.setLayout(new GridLayout(1,5));
        cartasRonda.setBackground(new Color(255,255,255));
        cartasRonda.setBounds(250,50, 750, 200);
        this.add(cartasRonda);

        bote.setLayout(null);
        bote.setBackground(Color.RED);
        bote.setBounds(50,350, 100, 200);
        TitledBorder boteTitulo = BorderFactory.createTitledBorder("Bote: ");
        boteTitulo.setTitleColor(new Color(255,255,255));
        bote.setBorder(boteTitulo);
        this.add(bote);

        informacionJugadores.setLayout(null);
        informacionJugadores.setBackground(Color.RED);
        informacionJugadores.setBounds(1050,250, 150, 400);
        TitledBorder jugadores = BorderFactory.createTitledBorder("Jugadores: ");
        jugadores.setTitleColor(new Color(255,255,255));
        informacionJugadores.setBorder(jugadores);
        this.add(informacionJugadores);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void crearInterfaz5CardDraw(){
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(45,87,44));
        this.setSize(1250,900);

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
        this.add(botones);

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
        this.add(informacionPartida);

        JPanel cartasJugador = new JPanel();
        cartasJugador.setLayout(new GridLayout(1,5));
        cartasJugador.setBackground(new Color(255,255,255));
        cartasJugador.setBounds(250,175, 750, 200);
        this.add(cartasJugador);

        JTextArea bote = new JTextArea();
        bote.setLayout(null);
        bote.setBackground(Color.RED);
        bote.setBounds(50,350, 100, 200);
        TitledBorder boteTitulo = BorderFactory.createTitledBorder("Bote: ");
        boteTitulo.setTitleColor(new Color(255,255,255));
        bote.setBorder(boteTitulo);
        this.add(bote);

        JTextArea informacionJugadores = new JTextArea();
        informacionJugadores.setLayout(null);
        informacionJugadores.setBackground(Color.RED);
        informacionJugadores.setBounds(1050,250, 150, 400);
        TitledBorder jugadores = BorderFactory.createTitledBorder("Jugadores: ");
        jugadores.setTitleColor(new Color(255,255,255));
        informacionJugadores.setBorder(jugadores);
        this.add(informacionJugadores);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cambiarCartasComunitarias(ArrayList<Carta> cartas){
        for(Carta c : cartas){
            cartasRonda.add(new JLabel(c.obtenerIcono()));
        }
    }
}