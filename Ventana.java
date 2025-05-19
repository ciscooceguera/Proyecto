import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
public class Ventana extends JFrame {
    protected JButton fold;
    protected JButton check;
    protected JButton raise;
    protected JButton pilaDeFichas;
    protected JButton call;
    protected JTextArea mensajeTurno;
    protected JButton bannerMsg;
    protected ArrayList<JButton> botonesCartasComunitarias;
    protected JTextArea textDineroJugador, textPot;
    protected JTextArea turno = new JTextArea();
    protected JTextArea dinero = new JTextArea();
    protected JPanel cartasRonda = new JPanel();
    protected JTextArea bote = new JTextArea();
    protected JTextArea informacionJugadores = new JTextArea();
    // constructor de la ventana
    public Ventana(String tipoPoker){
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        inicializarComponentes();
        if(tipoPoker.equals("Texas HoldEm")){
            super.setTitle(tipoPoker);
            crearInterfazTexas();
        }else if(tipoPoker.equals("Card Draw 5")){
            super.setTitle("Card Draw 5");
        }
    }
    // inicializa los botones
    public void inicializarComponentes(){
        String rutaDefault = "C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImageCasino\\BotonesImage\\";
        String rutaFold = rutaDefault + "buttonFold.png";
        String rutaFoldOnPress = rutaDefault + "buttonFoldOnPress.png";
        String rutaRaise = rutaDefault + "buttonRaise.png";
        String rutaRaiseOnPress = rutaDefault + "buttonRaiseOnPress.png";
        String rutaCall = rutaDefault + "buttonCall.png";
        String rutaCallOnPress = rutaDefault + "buttonCallOnPress.png";
        String rutaCheck = rutaDefault + "buttonCheck.png";
        String rutaCheckOnPress = rutaDefault + "buttonCheckOnPress.png";
        fold = botonCircular(rutaFold,rutaFoldOnPress);
        raise = botonCircular(rutaRaise,rutaRaiseOnPress);
        call = botonCircular(rutaCall,rutaCallOnPress);
        check = botonCircular(rutaCheck,rutaCheckOnPress);

        mensajeTurno = new JTextArea();
        textPot = new JTextArea();
        textDineroJugador = new JTextArea();

        bannerMsg = botonRectangularBordeado("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImageCasino\\bannerMsg.png",
                480,240,0);
        botonesCartasComunitarias = new ArrayList<>();

        pilaDeFichas = botonRectangularBordeado("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImageCasino\\pilaDeFichas.png");
        pilaDeFichas.setBounds(700,320,120,120);
        this.add(pilaDeFichas);
    }
    // crea la interfaz para el texas hold 'em
    public void crearInterfazTexas(){
        JPanel panelFondo = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Image fondo = new ImageIcon("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImageCasino\\mesaPokerRoja.png").getImage();
                g.drawImage(fondo, 0, 0, 1920, 1080, this);
            }
        };
        panelFondo.setBounds(0, 0, 1920, 1080);

        int tamanoFichas = 150;
        int posicionXFichasBotones = 50;
        int posicionYFichasBotones = 530;
        int incrementosEnY = 25+tamanoFichas;
        fold.setBounds(posicionXFichasBotones, posicionYFichasBotones, tamanoFichas, tamanoFichas);
        call.setBounds(posicionXFichasBotones, posicionYFichasBotones + incrementosEnY, tamanoFichas, tamanoFichas);
        raise.setBounds(posicionXFichasBotones, posicionYFichasBotones + incrementosEnY*2, tamanoFichas, tamanoFichas);
        check.setBounds(posicionXFichasBotones, posicionYFichasBotones + incrementosEnY, tamanoFichas, tamanoFichas);
        check.setVisible(false);

        bannerMsg.setBounds(0,50,480,240);

        fold.addActionListener(e ->{

        });

        call.addActionListener(e -> {

        });

        raise.addActionListener(e -> {

        });

        check.addActionListener(e -> {


        });

        this.add(fold);
        this.add(raise);
        this.add(call);
        this.add(check);
        this.add(bannerMsg);
        this.add(panelFondo);
        this.add(panelFondo);
        this.setVisible(true);
    }
    /* Retorna un botón con imagen circular, recibe la ruta de la imagen, y la imagen que mostrará cuando el cursor esté
       encima del botón, se usará para definir los botones que se representarán con im◙genes de fichas.*/
    public JButton botonCircular(String ruta,String rutaOnPress){
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
            public void mouseEntered(MouseEvent e) {repaint();}
            public void mouseExited(MouseEvent e) {repaint();}
        });
        return boton;
    }
    /* Retorna un botón con una imagen de fondo que representa a la carta, es utilizado para mostrar las cartas
       comunitarias en la mesa. */
    public JButton botonRectangularBordeado(String ruta){
        Image imagen = new ImageIcon(ruta).getImage();
        JButton boton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                Shape clip = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),10,10);
                g2d.setClip(clip);
                g2d.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                g2d.dispose();
            }
        };
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(false);
        return boton;
    }
    /* Retorna un botón con una imagen de fondo que representa a la carta, es utilizado para mostrar las cartas
       del jugador.*/
    public JButton botonRectangularBordeado(String ruta, int nuevoAncho, int nuevoAlto, int angulo){
        Image imagen = redimensionarImagen(ruta, nuevoAncho, nuevoAlto);
        JButton boton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.rotate(Math.toRadians(angulo), getWidth()/2, getHeight()/2);

                Shape clip = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),10,10);
                g2d.setClip(clip);
                g2d.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                g2d.dispose();
            }
        };
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(false);
        return boton;
    }
    // Muestra las cartas comunitarias en la mesa.
    public void mostrarCartasComunitarias(ArrayList<Carta> cartas){
        int x = 550;
        int y = 460;
        int anchoCarta = 145;
        int altoCarta = 181;
        int xIncrementos = 166;

        for (Carta carta : cartas){
            JButton botonCarta = botonRectangularBordeado(carta.obtenerImgRuta());
            botonCarta.setBounds(x,y,anchoCarta,altoCarta);
            x+=xIncrementos;
            this.add(botonCarta);
            botonesCartasComunitarias.add(botonCarta);
        }
    }
    // Muestra la mano del jugador
    public void mostrarCartasJugadorTurno(ArrayList<Carta> cartas){
        int x = 760;
        int y = 720;
        int anchoCarta = 210;
        int altoCarta = 263;

        Carta carta = new Carta("Diamante",2);
        Carta carta2 = new Carta("Diamante",14);
        x+=150;
        JButton buttonCarta = botonRectangularBordeado(carta.obtenerImgRuta(),anchoCarta,altoCarta,25);
        buttonCarta.setBounds(x,y,anchoCarta,altoCarta);
        x-=150;
        JButton buttonCarta2 = botonRectangularBordeado(carta2.obtenerImgRuta(),anchoCarta,altoCarta,-25);
        buttonCarta2.setBounds(x,y,anchoCarta,altoCarta);

        this.add(buttonCarta);
        this.add(buttonCarta2);
    }
    // Redimensiona una imagen a la escala deseada
    public Image redimensionarImagen(String ruta,int nuevoAncho, int nuevoAlto){
        Image imagen = new ImageIcon(ruta).getImage();
        BufferedImage imagenRedimensionada = new BufferedImage(nuevoAncho, nuevoAlto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imagenRedimensionada.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(imagen, 0, 0, nuevoAncho, nuevoAlto, null);
        g2d.dispose();
        return imagenRedimensionada;
    }
    public void mostrarMensajeTurno(String nombre){
        mensajeTurno.setText(nombre + " Is Thinking...");
        try {
            Font cinzelDec = Font.createFont(Font.TRUETYPE_FONT
                            , new File("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\FuentesNuevas\\CinzelDecorative-Regular.ttf"))
                            .deriveFont(Font.BOLD, 24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(cinzelDec);
            mensajeTurno.setFont(cinzelDec);
            mensajeTurno.setForeground(Color.WHITE);

        }catch(Exception e){
        }
        mensajeTurno.setBounds(20,154,480,240);
        mensajeTurno.setVisible(true);
        mensajeTurno.setOpaque(false);
        mensajeTurno.setBorder(null);
        mensajeTurno.setEnabled(false);
        this.add(mensajeTurno);
    }

    // muestra el dinero del jugador
    public void mostrarDineroJugador(int dinero){
        textDineroJugador.setText("$"+dinero);
        try {
            Font cinzelDec = Font.createFont(Font.TRUETYPE_FONT
                            , new File("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\FuentesNuevas\\CinzelDecorative-Bold.ttf"))
                    .deriveFont(Font.BOLD, 100f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(cinzelDec);
            textDineroJugador.setFont(cinzelDec);
            textDineroJugador.setForeground(Color.YELLOW);

        }catch(Exception e){
        }
        textDineroJugador.setBounds(1550,850,420,230);
        textDineroJugador.setVisible(true);
        textDineroJugador.setOpaque(false);
        textDineroJugador.setBorder(null);
        textDineroJugador.setEnabled(false);
        this.add(textDineroJugador);
    }
    // muestra el dinero en el pot
    public void mostrarPot(int pot){
        textPot.setText("$"+pot);
        try {
            Font cinzelDec = Font.createFont(Font.TRUETYPE_FONT
                            , new File("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\FuentesNuevas\\CinzelDecorative-Bold.ttf"))
                    .deriveFont(Font.BOLD, 80f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(cinzelDec);
            textPot.setFont(cinzelDec);
            textPot.setForeground(Color.WHITE);
        }catch(Exception e){
        }
        textPot.setBounds(850,340,420,230);
        textPot.setVisible(true);
        textPot.setOpaque(false);
        textPot.setBorder(null);
        textPot.setEnabled(false);
        this.add(textPot);
    }
}