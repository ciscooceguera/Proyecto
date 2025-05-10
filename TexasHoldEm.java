import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class TexasHoldEm extends JuegoDePoker {
    public TexasHoldEm(){
        super();
    }

    public void crearInterfaz(){
        JFrame ventana = new JFrame("Texas Hold Em");
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

        JPanel cartasJugador = new JPanel();
        cartasJugador.setLayout(new GridLayout(1,2));
        cartasJugador.setBackground(new Color(255,255,255));
        cartasJugador.setBounds(475,300, 300, 200);
        ventana.add(cartasJugador);

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

        JPanel cartasRonda = new JPanel();
        cartasRonda.setLayout(new GridLayout(1,5));
        cartasRonda.setBackground(new Color(255,255,255));
        cartasRonda.setBounds(250,50, 750, 200);
        ventana.add(cartasRonda);

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

    public void iniciarJuego(){
        int opc = 0;
        /*while (opc == 0) {
            Mazo mazo = new Mazo();
            mazo.crearMazo();
            System.out.println(mazo);
            mazo.revolverMazo();
            System.out.println(mazo);
            Mano mano1 = new Mano(mazo.tomarCartas(5));
            System.out.println(mano1);
            mano1.acomodarMano();
            System.out.println(mano1);
            System.out.println(mano1.esEscalera());
            System.out.println("Continuar?: ");
            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();
        }*/

        ArrayList<Carta> manoSinEscalera = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            manoSinEscalera.add(new Carta("Corazón",i+1));
            if (i == 2){
                manoSinEscalera.set(i, new Carta("Pica",8));
            }
        }
        Mano manoNoEscalera = new Mano(manoSinEscalera);
        System.out.println("Mano sin escalera: \n");
        System.out.println(manoNoEscalera);
        System.out.println("Es escalera?: " + manoNoEscalera.esEscalera());
        //
        manoSinEscalera = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            manoSinEscalera.add(new Carta("Corazón",i+1));
        }
        Mano manoConEscaleraReal = new Mano(manoSinEscalera);
        System.out.println("Mano sin escalera: \n");
        System.out.println(manoConEscaleraReal);
        System.out.println("Es escalera?: " + manoConEscaleraReal.esEscalera());
        System.out.println("Es escalera real?: " + manoConEscaleraReal.esEscaleraReal());
//        System.out.println("Es escalera de color?: " + manoConEscaleraReal.esEscaleraDeColor());
//        System.out.println("Es escalera straight?: " + manoConEscaleraReal.esEscaleraStraight());
        //
        manoSinEscalera = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            manoSinEscalera.add(new Carta("Corazón",i+1));
            if (i == 3){
                manoSinEscalera.set(i, new Carta("Diamante",i+1));
            }
        }
        Mano manoConEscaleraColor = new Mano(manoSinEscalera);
        System.out.println("Mano sin escalera: \n");
        System.out.println(manoConEscaleraColor);
        System.out.println("Es escalera?: " + manoConEscaleraColor.esEscalera());
        System.out.println("Es escalera real?: " + manoConEscaleraColor.esEscaleraReal());
//        System.out.println("Es escalera de color?: " + manoConEscaleraColor.esEscaleraDeColor());
//        System.out.println("Es escalera straight?: " + manoConEscaleraColor.esEscaleraStraight());

        //
        manoSinEscalera = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            manoSinEscalera.add(new Carta("Corazón",i+1));
            if (i == 3){
                manoSinEscalera.set(i, new Carta("Pica",i+1));
            }
        }
        Mano manoConEscaleraStraight = new Mano(manoSinEscalera);
        System.out.println("Mano sin escalera: \n");
        System.out.println(manoConEscaleraStraight);
        System.out.println("Es escalera?: " + manoConEscaleraStraight.esEscalera());
        System.out.println("Es escalera real?: " + manoConEscaleraStraight.esEscaleraReal());
//        System.out.println("Es escalera de color?: " + manoConEscaleraStraight.esEscaleraDeColor());
//        System.out.println("Es escalera straight?: " + manoConEscaleraStraight.esEscaleraStraight());




    }

}