import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends JFrame{
    public static void main(String[] args) {
        crearVentana();
    }

    public static void crearVentana(){

        JFrame ventana = new JFrame("Casino Guasavito");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setSize(500,500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ImageIcon pic = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\fondoMain.png");
        //ImageIcon pic = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\fondoMain.png");
        Image imagenAEscalar = pic.getImage().getScaledInstance(1550, 1000, Image.SCALE_SMOOTH);
        pic = new ImageIcon(imagenAEscalar);
        JLabel image = new JLabel(pic);
        image.setBounds(0, 0, 1920, 1080);
        ventana.add(image);
        ventana.setContentPane(image);

        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1920, 1080);
        panel.setOpaque(false);

        //String rutaBotones="C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\BotonesMain\\";
        String rutaBotones="C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\BotonesMain\\";


        String rutaJugar=rutaBotones+"botonJugar.png";
        String rutaJugarPress=rutaBotones+"botonJugarPress.png";
        JButton jugar = crearBoton(rutaJugar, rutaJugarPress);
        jugar.setBounds(0, 500, 500, 500);
        jugar.setFocusPainted(false);

        String rutaCreditos=rutaBotones+"botonCreditos.png";
        String rutaCreditosPress=rutaBotones+"botonCreditosPress.png";
        JButton creditos = crearBoton(rutaCreditos, rutaCreditosPress);
        creditos.setBounds(500, 500, 500, 500);
        creditos.setFocusPainted(false);

        String rutaSalir=rutaBotones+"botonSalir.png";
        String rutaSalirPress=rutaBotones+"botonSalirPress.png";
        JButton salir = crearBoton(rutaSalir, rutaSalirPress);
        salir.setBounds(1050, 500, 600, 500);
        salir.setFocusPainted(false);

        ventana.add(jugar);
        ventana.add(creditos);
        ventana.add(salir);
        ventana.add(panel);
        ventana.setVisible(true);

        jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jugar = new JFrame();
                jugar.setExtendedState(JFrame.MAXIMIZED_BOTH);
                jugar.setUndecorated(true);
                jugar.setResizable(false);
                jugar.setLocationRelativeTo(null);
                jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jugar.setLayout(null);

                //ImageIcon pic = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\fondoTipo.png");
                ImageIcon pic = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\fondoTipo.png");
                Image imagenAEscalar = pic.getImage().getScaledInstance(1550, 1000, Image.SCALE_SMOOTH);
                pic = new ImageIcon(imagenAEscalar);
                JLabel image = new JLabel(pic);
                image.setBounds(0, 0, 1920, 1080);
                jugar.add(image);
                jugar.setContentPane(image);

                JPanel panel = new JPanel(null);
                panel.setBounds(0, 0, 1920, 1080);
                panel.setOpaque(false);

                String rutaBotones="C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\BotonesTipo";
                //String rutaBotones="C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\BotonesTipo\\";

                String rutaTexas = rutaBotones+"botonTexas.png";
                String rutaTexasPress = rutaBotones+"botonTexasPress.png";
                JButton botonTexas = crearBoton(rutaTexas, rutaTexasPress);
                botonTexas.setBounds(200, 150, 500, 800);
                botonTexas.setFocusPainted(false);

                String ruta5Card = rutaBotones+"boton5Card.png";
                String ruta5CardPress = rutaBotones+"boton5CardPress.png";
                JButton boton5Card = crearBoton(ruta5Card, ruta5CardPress);
                boton5Card.setBounds(900, 150, 500, 800);
                boton5Card.setFocusPainted(false);

                jugar.add(botonTexas);
                jugar.add(boton5Card);
                jugar.add(panel);
                jugar.setVisible(true);

                botonTexas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame texas = new JFrame();
                        texas.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        texas.setUndecorated(true);
                        texas.setResizable(false);
                        texas.setLocationRelativeTo(null);
                        texas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        texas.setLayout(null);
                    }
                });

                boton5Card.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame Card5 = new JFrame();
                        Card5.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        Card5.setUndecorated(true);
                        Card5.setResizable(false);
                        Card5.setLocationRelativeTo(null);
                        Card5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        Card5.setLayout(null);
                    }
                });

//                int numJugadores = 0;
//                Object[] botones = {"Texas Hold 'em","Otro juego"};
//                int tipoPoker = JOptionPane.showOptionDialog(ventana,
//                        "Elige modalidad","Modalidad",
//                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
//                        null, botones, botones[0]);
//                String tipoPokerStr = "";
//                switch (tipoPoker){
//                    case 0:
//                        while (numJugadores<2 || numJugadores>10) {
//                            String numJugadoresStr = JOptionPane.showInputDialog(ventana,
//                                    "Número de jugadores", "Jugadores",
//                                    JOptionPane.QUESTION_MESSAGE);
//                            try{
//                                numJugadores = Integer.parseInt(numJugadoresStr);
//                                if (numJugadores<2 || numJugadores>10) {
//                                    JOptionPane.showMessageDialog(null,
//                                            "Solo pueden jugar 2 - 10 jugadores",
//                                            "Error",JOptionPane.ERROR_MESSAGE);
//                                }
//                            }catch (NumberFormatException exception){
//                                JOptionPane.showMessageDialog(null,"Ingrese un número de jugadores"
//                                );
//                            }
//                        }
//                        String [] jugadoresJuego1 = new String[numJugadores];
//                        for(int i = 0; i < numJugadores; i++){
//                            String nombreJugador = JOptionPane.showInputDialog(ventana,
//                                    "Ingresa el nombre del jugador "+(i+1),
//                                    "Nombre del jugador", JOptionPane.QUESTION_MESSAGE);
//                            jugadoresJuego1[i] = nombreJugador;
//                        }
//                        System.out.println(Arrays.toString(jugadoresJuego1));
//                        JuegoDePoker juego = new TexasHoldEm(numJugadores);
//                        break;
//                    case 1:
//                        while (numJugadores<2 || numJugadores>7) {
//                            String numJugadoresStr = JOptionPane.showInputDialog(ventana,
//                                    "Número de jugadores", "Jugadores",
//                                    JOptionPane.QUESTION_MESSAGE);
//                            numJugadores = Integer.parseInt(numJugadoresStr);
//                            if (numJugadores<2 || numJugadores>7) {
//                                JOptionPane.showMessageDialog(null,
//                                        "Solo pueden jugar 2 - 7 jugadores",
//                                        "Error",JOptionPane.ERROR_MESSAGE);
//                            }
//                        }
//                        String [] jugadoresJuego2 = new String[numJugadores];
//                        for(int i = 0; i < numJugadores; i++){
//                            String nombreJugador = JOptionPane.showInputDialog(ventana,
//                                    "Ingresa el nombre del jugador "+(i+1),
//                                    "Nombre del jugador", JOptionPane.QUESTION_MESSAGE);
//                            jugadoresJuego2[i] = nombreJugador;
//                        }
//                        System.out.println(Arrays.toString(jugadoresJuego2));
//                        tipoPokerStr = "Otro juego";
//                        JuegoDePoker cardDraw5 = new CardDraw5(numJugadores);
//                        break;
//                }

                ImageIcon imagen = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\pokerPregunta.png");
                Image preImagen = imagen.getImage();
                imagen = new ImageIcon(preImagen.getScaledInstance(50,50,Image.SCALE_SMOOTH));
                int numJugadores = 0;
                Object[] botones = {"Texas Hold 'em","Otro juego"};
                int tipoPoker = JOptionPane.showOptionDialog(ventana,
                        "Elige modalidad","Modalidad",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        imagen, botones, botones[0]);
                String tipoPokerStr = "";
                switch (tipoPoker){
                    case 0:
                        while (numJugadores<2 || numJugadores>10) {
                            String numJugadoresStr = JOptionPane.showInputDialog(ventana,
                                    "Número de jugadores", "Jugadores",
                                    JOptionPane.QUESTION_MESSAGE);
                            try{
                                numJugadores = Integer.parseInt(numJugadoresStr);
                                if (numJugadores<2 || numJugadores>10) {
                                    JOptionPane.showMessageDialog(null,
                                            "Solo pueden jugar 2 - 10 jugadores",
                                            "Error",JOptionPane.ERROR_MESSAGE);
                                }
                            }catch (NumberFormatException exception){
                                JOptionPane.showMessageDialog(null,"Ingrese un número de jugadores"
                                        );
                            }
                        }

                        JuegoDePoker juego = new TexasHoldEm(numJugadores,"Texas HoldEm");
                        break;
                    case 1:
                        while (numJugadores<2 || numJugadores>7) {
                            String numJugadoresStr = JOptionPane.showInputDialog(ventana,
                                    "Número de jugadores", "Jugadores",
                                    JOptionPane.QUESTION_MESSAGE);
                            numJugadores = Integer.parseInt(numJugadoresStr);
                            if (numJugadores<2 || numJugadores>7) {
                                JOptionPane.showMessageDialog(null,
                                        "Solo pueden jugar 2 - 7 jugadores",
                                        "Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        tipoPokerStr = "Otro juego";
                        JuegoDePoker cardDraw5 = new CardDraw5(numJugadores,tipoPokerStr);
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

    public static JButton crearBoton(String ruta, String rutaOnPress){
        Image imagen = new ImageIcon(ruta).getImage();
        Image imagenOnPress = new ImageIcon(rutaOnPress).getImage();
        JButton boton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                if (getModel().isPressed()){
                    g2d.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                }else if (getModel().isRollover()){
                    g2d.drawImage(imagenOnPress,0,0,getWidth(),getHeight(),this);
                }else{
                    g2d.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                }
            }
        };
        boton.setContentAreaFilled(false);
        boton.setRolloverEnabled(true);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(false);
        boton.setForeground(Color.BLACK);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                boton.repaint();
            }
            public void mouseExited(MouseEvent evt) {
                boton.repaint();
            }
        });
        return boton;



    }


}