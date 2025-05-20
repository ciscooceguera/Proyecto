import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class Main extends JFrame{
    public static void main(String[] args) {
        crearVentana();
    }

    public static void crearVentana(){
        JFrame ventana = new JFrame();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setUndecorated(true);
        ventana.setResizable(false);

        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ImageIcon pic = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\fondoMain.png");
        //ImageIcon pic = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\fondoMain.png");
        Image imagenAEscalar = pic.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
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
        creditos.setBounds(525, 500, 500, 500);
        creditos.setFocusPainted(false);

        String rutaSalir=rutaBotones+"botonSalir.png";
        String rutaSalirPress=rutaBotones+"botonSalirPress.png";
        JButton salir = crearBoton(rutaSalir, rutaSalirPress);
        salir.setBounds(1050, 500, 500, 500);
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
                Image imagenAEscalar = pic.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                pic = new ImageIcon(imagenAEscalar);
                JLabel image = new JLabel(pic);
                image.setBounds(0, 0, 1920, 1080);
                jugar.add(image);
                jugar.setContentPane(image);

                JPanel panel = new JPanel(null);
                panel.setBounds(0, 0, 1920, 1080);
                panel.setOpaque(false);

                String rutaBotones="C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\BotonesTipo\\";
                //String rutaBotones="C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\BotonesTipo\\";

                String rutaTexas = rutaBotones + "botonTexas.png";
                String rutaTexasPress = rutaBotones + "botonTexasPress.png";
                JButton botonTexas = crearBoton(rutaTexas, rutaTexasPress);
                botonTexas.setBounds(200, 150, 500, 800);
                botonTexas.setFocusPainted(false);

                String ruta5Card = rutaBotones + "boton5Card.png";
                String ruta5CardPress = rutaBotones + "boton5CardPress.png";
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

                        //ImageIcon pic = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\fondoJugadoresTexas.png");
                        ImageIcon pic = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\fondoJugadoresTexas.png");
                        Image imagenAEscalar = pic.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                        pic = new ImageIcon(imagenAEscalar);
                        JLabel image = new JLabel(pic);
                        image.setBounds(0, 0, 1920, 1080);
                        texas.add(image);
                        texas.setContentPane(image);

                        //String rutaBotones = "C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\BotonesTexas\\";
                        String rutaBotones = "C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\botonesTexas\\";
                        int y = 100;
                        for(int i=2;i<=10;i++) {
                            String rutaBoton = rutaBotones + "boton" + i + "Jugadores.png";
                            String rutaBotonPress = rutaBotones + "boton" + i + "JugadoresPress.png";
                            JButton botonJugadores = crearBoton(rutaBoton, rutaBotonPress);
                            botonJugadores.setBounds(40, y, 200, 200);
                            y+=80;
                            botonJugadores.setFocusPainted(false);
                            int numero = i;
                            botonJugadores.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    TexasHoldEm juego = new TexasHoldEm(numero);
                                    texas.setVisible(false);
                                }
                            });
                            texas.add(botonJugadores);
                        }

                        String rutaInformacion = rutaBotones+"botonInformacion.png";
                        String rutaInformacionPress = rutaBotones+"botonInformacionPress.png";
                        JButton botonInformacion = crearBoton(rutaInformacion, rutaInformacionPress);
                        botonInformacion.setBounds(720, 340, 500, 500);
                        botonInformacion.setFocusPainted(false);

                        botonInformacion.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                JFrame informacion = new JFrame();
                                informacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                informacion.setUndecorated(true);
                                informacion.setResizable(false);
                                informacion.setLocationRelativeTo(null);
                                informacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                informacion.setLayout(null);

                                //ImageIcon pic = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\fondoInformaciónTexas.png");
                                ImageIcon pic = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\fondoInformaciónTexas.png");
                                Image imagenAEscalar = pic.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                                pic = new ImageIcon(imagenAEscalar);
                                JLabel image = new JLabel(pic);
                                image.setBounds(0, 0, 1920, 1080);
                                informacion.add(image);
                                informacion.setContentPane(image);

                                //String rutaBotones = "C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\BotonesTexas\\";
                                String rutaBotones = "C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\botonesTexas\\";
                                String rutaVolver = rutaBotones+"botonVolver.png";
                                String rutaVolverPress = rutaBotones+"botonVolverPress.png";
                                JButton botonVolver = crearBoton(rutaVolver, rutaVolverPress);
                                botonVolver.setBounds(525, 540, 500, 500);
                                botonVolver.setFocusPainted(false);

                                botonVolver.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        informacion.setVisible(false);
                                    }
                                });

                                informacion.add(botonVolver);
                                informacion.setVisible(true);
                            }
                        });

                        texas.add(botonInformacion);
                        texas.setVisible(true);
                        jugar.setVisible(false);
                    }
                });

                boton5Card.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame card5 = new JFrame();
                        card5.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        card5.setUndecorated(true);
                        card5.setResizable(false);
                        card5.setLocationRelativeTo(null);
                        card5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        card5.setLayout(null);

                        //ImageIcon pic = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\fondoJugadores5Card.png");
                        ImageIcon pic = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\fondoJugadores5Card.png");

                        Image imagenAEscalar = pic.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                        pic = new ImageIcon(imagenAEscalar);
                        JLabel image = new JLabel(pic);
                        image.setBounds(0, 0, 1920, 1080);
                        card5.add(image);
                        card5.setContentPane(image);

                        //String rutaBotones = "C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\BotonesTexas\\";
                        String rutaBotones = "C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\botonesTexas\\";

                        int y = 180;
                        for(int i=2;i<=7;i++) {
                            String rutaBoton = rutaBotones + "boton" + i + "Jugadores.png";
                            String rutaBotonPress = rutaBotones + "boton" + i + "JugadoresPress.png";
                            JButton botonJugadores = crearBoton(rutaBoton, rutaBotonPress);
                            botonJugadores.setBounds(40, y, 200, 200);
                            y+=90;
                            botonJugadores.setFocusPainted(false);
                            int numero = i;
                            botonJugadores.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    CardDraw5 juego = new CardDraw5(numero);
                                    card5.setVisible(false);
                                }
                            });
                            card5.add(botonJugadores);
                        }

                        String rutaInformacion = rutaBotones+"botonInformacion.png";
                        String rutaInformacionPress = rutaBotones+"botonInformacionPress.png";
                        JButton botonInformacion = crearBoton(rutaInformacion, rutaInformacionPress);
                        botonInformacion.setBounds(720, 340, 500, 500);
                        botonInformacion.setFocusPainted(false);

                        botonInformacion.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                JFrame informacion = new JFrame();
                                informacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                informacion.setUndecorated(true);
                                informacion.setResizable(false);
                                informacion.setLocationRelativeTo(null);
                                informacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                informacion.setLayout(null);

                                //ImageIcon pic = new ImageIcon("C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\fondoInformación5Card.png");
                                ImageIcon pic = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImagenesMain\\fondoInformación5Card.png");

                                Image imagenAEscalar = pic.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
                                pic = new ImageIcon(imagenAEscalar);
                                JLabel image = new JLabel(pic);
                                image.setBounds(0, 0, 1920, 1080);
                                informacion.add(image);
                                informacion.setContentPane(image);

                                String rutaBotones = "C:\\Users\\joser\\IdeaProjects\\Proyecto\\ImagenesMain\\BotonesTexas\\";

                                String rutaVolver = rutaBotones+"botonVolver.png";
                                String rutaVolverPress = rutaBotones+"botonVolverPress.png";
                                JButton botonVolver = crearBoton(rutaVolver, rutaVolverPress);
                                botonVolver.setBounds(525, 540, 500, 500);
                                botonVolver.setFocusPainted(false);

                                botonVolver.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        informacion.setVisible(false);
                                    }
                                });

                                informacion.add(botonVolver);
                                informacion.setVisible(true);
                            }
                        });
                        card5.add(botonInformacion);
                        card5.setVisible(true);
                        jugar.setVisible(false);
                    }
                });
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