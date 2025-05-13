import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Juegos de Póker");
        ventana.setSize(500,500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ImageIcon pic = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\imageMain.png");
        JLabel image = new JLabel(pic);
        image.setBounds(0,0,500,500);
        ventana.add(image);
        ventana.setContentPane(image);
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,500,500);
        panel.setOpaque(false);
        JButton jugar = new JButton("Jugar");
        JButton creditos = new JButton("Creditos");
        JButton salir = new JButton("Salir");
        jugar.setBounds(100,350,100,50);
        creditos.setBounds(200,350,100,50);
        salir.setBounds(300,350,100,50);
        jugar.setBackground(new Color(70,130,180));
        jugar.setForeground(Color.WHITE);
        jugar.setFocusPainted(false);
        jugar.setFont(new Font("Arial", Font.BOLD,15));
        jugar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        creditos.setBackground(new Color(70,130,180));
        creditos.setForeground(Color.WHITE);
        creditos.setFocusPainted(false);
        creditos.setFont(new Font("Arial", Font.BOLD,15));
        creditos.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        salir.setBackground(new Color(70,130,180));
        salir.setForeground(Color.WHITE);
        salir.setFocusPainted(false);
        salir.setFont(new Font("Arial", Font.BOLD,15));
        salir.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        jugar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jugar.setBackground(new Color(100, 149, 237));
            }
            public void mouseExited(MouseEvent evt) {
                jugar.setBackground(new Color(70, 130, 180));
            }
        });
        creditos.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                creditos.setBackground(new Color(100, 149, 237));
            }
            public void mouseExited(MouseEvent evt) {
                creditos.setBackground(new Color(70, 130, 180));
            }
        });
        salir.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                salir.setBackground(new Color(100, 149, 237));
            }
            public void mouseExited(MouseEvent evt) {
                salir.setBackground(new Color(70, 130, 180));
            }
        });
        ventana.add(jugar);
        ventana.add(creditos);
        ventana.add(salir);
        ventana.add(panel);
        ventana.setVisible(true);
        jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numJugadores = 0;
                Object[] botones = {"Texas Hold 'em","Otro juego"};
                int tipoPoker = JOptionPane.showOptionDialog(ventana,
                        "Elige modalidad","Modalidad",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, botones, botones[0]);
                String tipoPokerStr = "";
                switch (tipoPoker){
                    case 0:
                        while (numJugadores<2 || numJugadores>10) {
                            String numJugadoresStr = JOptionPane.showInputDialog(ventana,
                                    "Número de jugadores", "Jugadores",
                                    JOptionPane.QUESTION_MESSAGE);
                            numJugadores = Integer.parseInt(numJugadoresStr);
                            if (numJugadores<2 || numJugadores>10) {
                                JOptionPane.showMessageDialog(null,
                                        "Solo pueden jugar 2 - 10 jugadores",
                                        "Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        String [] jugadoresJuego1 = new String[numJugadores];
                        for(int i = 0; i < numJugadores; i++){
                            String nombreJugador = JOptionPane.showInputDialog(ventana,
                                    "Ingresa el nombre del jugador "+(i+1),
                                    "Nombre del jugador", JOptionPane.QUESTION_MESSAGE);
                            jugadoresJuego1[i] = nombreJugador;
                        }
                        System.out.println(Arrays.toString(jugadoresJuego1));
                        tipoPokerStr = "Texas Hold 'em'";

                        JuegoDePoker juego = new TexasHoldEm(numJugadores);
                        
                        break;
                    case 1:
                        while (numJugadores<2 || numJugadores>10) {
                            String numJugadoresStr = JOptionPane.showInputDialog(ventana,
                                    "Número de jugadores", "Jugadores",
                                    JOptionPane.QUESTION_MESSAGE);
                            numJugadores = Integer.parseInt(numJugadoresStr);
                            if (numJugadores<2 || numJugadores>4) {
                                JOptionPane.showMessageDialog(null,
                                        "Solo pueden jugar 2 - 10 jugadores",
                                        "Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        String [] jugadoresJuego2 = new String[numJugadores];
                        for(int i = 0; i < numJugadores; i++){
                            String nombreJugador = JOptionPane.showInputDialog(ventana,
                                    "Ingresa el nombre del jugador "+(i+1),
                                    "Nombre del jugador", JOptionPane.QUESTION_MESSAGE);
                            jugadoresJuego2[i] = nombreJugador;
                        }
                        System.out.println(Arrays.toString(jugadoresJuego2));
                        tipoPokerStr = "Otro juego";
                        Mazo mazo = new Mazo();
                        mazo.crearMazo();
                        mazo.revolverMazo();
                        System.out.println(mazo);
                        break;
                }
            }
        });
        creditos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ventana, "Realizado por: \n" +
                                "Francisco Javier Oceguera Gutierrez" +
                                "\n José Ramón Suffo Peimbert",
                        "Créditos", JOptionPane.DEFAULT_OPTION);
            }
        });
        salir.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
