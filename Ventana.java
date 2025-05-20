import javax.annotation.processing.SupportedSourceVersion;
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
    protected JButton carta1,carta2;
    protected JPanel panelDineroJugador,panelPot;
    protected JButton cartaC1, cartaC2, cartaC3, cartaC4, cartaC5;
    protected JTextArea mensajeTurno, dineroJugadores, textManos;
    protected JPanel panelMano, panelDineroDeJugadores;
    protected JLayeredPane panelMensajeTurno;
    protected JLayeredPane panelManos;
    protected JButton bannerMsg, bannerRojo;
    protected JTextArea textDineroJugador, textPot;
    protected JTextArea turno = new JTextArea();
    protected JTextArea dinero = new JTextArea();
    protected JPanel cartasComunitarias;
    protected JTextArea bote = new JTextArea();
    protected JTextArea informacionJugadores = new JTextArea();
    protected TexasHoldEm juego;
    protected CardDraw5 juegoCard;
    // constructor de la ventana
    public Ventana(String tipoPoker,JuegoDePoker juegoDePoker){
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        inicializarComponentes();
        if(tipoPoker.equals("Texas HoldEm")){
            juego = (TexasHoldEm) juegoDePoker;
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
        textManos = new JTextArea();
        textPot = new JTextArea();
        textDineroJugador = new JTextArea();
        dineroJugadores = new JTextArea();

        bannerMsg = crearBotonRectangularBordeado("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImageCasino\\bannerMsg.png",
                480,240,0);

        bannerRojo = crearBotonRectangularBordeado("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImageCasino\\bannerRojo.png",
                480,480,0);
        bannerRojo.setVisible(false);

        pilaDeFichas = crearBotonRectangularBordeado("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\ImageCasino\\pilaDeFichas.png");
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



        fold.addActionListener(e ->{
            juego.foldear();
        });

        call.addActionListener(e -> {
            juego.callear();
        });

        raise.addActionListener(e -> {
            juego.subir();
        });

        check.addActionListener(e -> {
            juego.check();
        });

        int x = 760;
        int y = 720;
        int anchoCarta = 210;
        int altoCarta = 263;

        panelMano = new JPanel();
        panelMano.setLayout(null);
        panelMano.setOpaque(false);
        panelMano.setBounds(x, y, anchoCarta*2 +50, altoCarta+50);

        panelDineroJugador = new JPanel();
        panelDineroJugador.setLayout(null);
        panelDineroJugador.setOpaque(false);
        panelDineroJugador.setBounds(1550,850,450,350);

        panelPot = new JPanel();
        panelPot.setOpaque(false);
        panelPot.setLayout(null);
        panelPot.setBounds(850,340,450,350);

        panelMensajeTurno = new JLayeredPane();
        panelMensajeTurno.setLayout(null);
        panelMensajeTurno.setOpaque(false);
        panelMensajeTurno.setBounds(0,50,480,240);

        bannerMsg.setBounds(0,0,480,240);
        panelMensajeTurno.add(bannerMsg,Integer.valueOf(0));

        panelManos = new JLayeredPane();
        panelManos.setOpaque(false);
        panelManos.setLayout(null);
        panelManos.setBounds(1500,500,480,480);

        bannerRojo.setBounds(0,0,480,480);
        panelManos.add(bannerRojo,Integer.valueOf(0));


        cartasComunitarias = new JPanel();
        cartasComunitarias.setLayout(null);
        cartasComunitarias.setOpaque(false);
        cartasComunitarias.setBounds(550,460,1389,182);

        panelDineroDeJugadores = new JPanel();
        panelDineroDeJugadores.setLayout(null);
        panelDineroDeJugadores.setOpaque(false);
        panelDineroDeJugadores.setBounds(1500,0,400,400);


        inicializarCuadrosDeTextos();



        this.add(panelMano);
        this.add(panelPot);
        this.add(cartasComunitarias);
        this.add(panelMensajeTurno);
        this.add(panelManos);
        this.add(panelDineroJugador);
        this.add(fold);
        this.add(raise);
        this.add(call);
        this.add(check);
        this.add(panelDineroDeJugadores);
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
    public JButton crearBotonRectangularBordeado(String ruta){
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
    public JButton crearBotonRectangularBordeado(String ruta, int nuevoAncho, int nuevoAlto, int angulo){
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


    public void reiniciarCartasComunitarias(){
        //this.remove(cartasComunitarias);

        System.out.println("Componentes antes del rem: " + cartasComunitarias.getComponentCount());
        System.out.println("Componentes despues del remove: " + cartasComunitarias.getComponentCount());

        //this.add(cartasComunitarias);
        cartasComunitarias.removeAll();
        cartasComunitarias.revalidate();
        cartasComunitarias.repaint();

        this.revalidate();
        this.repaint();
    }

    // Muestra las cartas comunitarias en la mesa.
    public void mostrarCartasComunitarias(ArrayList<Carta> cartas){
        System.out.println(cartas);
        cartasComunitarias.revalidate();
        cartasComunitarias.repaint();
        int x = 0;
        int y = 0;
        int anchoCarta = 145;
        int altoCarta = 181;
        int xIncrementos = 166;
        for (Carta c : cartas){
            JButton botonCarta = crearBotonRectangularBordeado(c.obtenerImgRuta());
            botonCarta.setBounds(x,y,anchoCarta,altoCarta);
            x+=xIncrementos;
            cartasComunitarias.add(botonCarta);
        }
        cartasComunitarias.revalidate();
        cartasComunitarias.repaint();
        this.revalidate();
        this.repaint();
    }
    public void switchCallPorCheck(){
        call.setVisible(false);
        check.setVisible(true);
    }
    public void switchCheckPorCall(){
        check.setVisible(false);
        call.setVisible(true);
    }
    // Muestra la mano del jugador
    public void mostrarCartasJugadorTurno(Mano cartas){
        panelMano.removeAll();
        panelMano.revalidate();
        panelMano.repaint();

        ArrayList<Carta> cartasArray = cartas.getMano();
        int x = 15;
        int y = 0;
        int anchoCarta = 210;
        int altoCarta = 263;
        x+=150;
        JButton boton1 = crearBotonRectangularBordeado(cartasArray.get(0).obtenerImgRuta(),anchoCarta,altoCarta,25);
        boton1.setBounds(x,y,anchoCarta,altoCarta);
        x=15;
        JButton boton2 = crearBotonRectangularBordeado(cartasArray.get(1).obtenerImgRuta(),anchoCarta,altoCarta,-25);
        boton2.setBounds(x,y,anchoCarta,altoCarta);


        panelMano.add(boton1);
        panelMano.add(boton2);
        panelMano.revalidate();
        panelMano.repaint();
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
    }
    public void mostrarManos(ArrayList<Jugador> jugadores){
        String texto = "";
        for (Jugador jugador : jugadores){
            texto += jugador.getNombre() + ": " + jugador.getMano();
        }
        textManos.setText(texto);
    }

    // muestra el dinero del jugador
    public void mostrarDineroJugador(int dinero) {
        textDineroJugador.setText("$" + dinero);
    }
    // inicializa el panel del dinero
    public void inicializarCuadrosDeTextos(){
        textDineroJugador.setText("$");
        try {
            Font cinzelDec = Font.createFont(Font.TRUETYPE_FONT
                            , new File("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\FuentesNuevas\\CinzelDecorative-Bold.ttf"))
                    .deriveFont(Font.BOLD, 100f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(cinzelDec);
            textDineroJugador.setFont(cinzelDec);
            textDineroJugador.setForeground(Color.WHITE);

        }catch(Exception e){
        }
        textDineroJugador.setBounds(0,0,420,230);
        textDineroJugador.setVisible(true);
        textDineroJugador.setOpaque(false);
        textDineroJugador.setBorder(null);
        textDineroJugador.setEnabled(false);
        panelDineroJugador.add(textDineroJugador);

        textPot.setText("$"+0);
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
        textPot.setBounds(0,0,420,230);
        textPot.setVisible(true);
        textPot.setOpaque(false);
        textPot.setBorder(null);
        textPot.setEnabled(false);
        panelPot.add(textPot);

        mensajeTurno.setText("" + " Is Thinking...");
        try {
            Font cinzelDec = Font.createFont(Font.TRUETYPE_FONT
                            , new File("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\FuentesNuevas\\CinzelDecorative-Bold.ttf"))
                    .deriveFont(Font.BOLD, 30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(cinzelDec);
            mensajeTurno.setFont(cinzelDec);
            mensajeTurno.setForeground(Color.WHITE);

        }catch(Exception e){
        }
        mensajeTurno.setBounds(20,100,480,240);
        mensajeTurno.setVisible(true);
        mensajeTurno.setOpaque(false);
        mensajeTurno.setBorder(null);
        mensajeTurno.setEnabled(false);
        panelMensajeTurno.add(mensajeTurno,Integer.valueOf(1));

        textManos.setText("");
        try {
            Font cinzelDec = Font.createFont(Font.TRUETYPE_FONT
                            , new File("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\FuentesNuevas\\CinzelDecorative-Bold.ttf"))
                    .deriveFont(Font.BOLD, 30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(cinzelDec);
            textManos.setFont(cinzelDec);
            textManos.setForeground(Color.WHITE);

        }catch(Exception e){
        }
        textManos.setBounds(20,100,480,240);
        textManos.setVisible(true);
        textManos.setOpaque(false);
        textManos.setBorder(null);
        textManos.setEnabled(false);
        panelManos.add(textManos,Integer.valueOf(1));

        dineroJugadores.setText("Dinero Jugadores: \n");
        try {
            Font cinzelDec = Font.createFont(Font.TRUETYPE_FONT
                            , new File("C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\FuentesNuevas\\CinzelDecorative-Bold.ttf"))
                    .deriveFont(Font.BOLD, 30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(cinzelDec);
            dineroJugadores.setFont(cinzelDec);
            dineroJugadores.setForeground(Color.WHITE);

        }catch(Exception e){
        }
        dineroJugadores.setBounds(0,0,400,400);
        dineroJugadores.setVisible(true);
        dineroJugadores.setOpaque(false);
        dineroJugadores.setBorder(null);
        dineroJugadores.setEnabled(false);
        panelDineroDeJugadores.add(dineroJugadores);

    }
    // actualiza el dinero del jugador en el frame
    public void setTextDineroJugador(int dinero){
        textDineroJugador.setText("S" + String.valueOf(dinero));
    }
    // muestra el dinero en el pot
    public void mostrarPot(int pot){
        textPot.setText("$"+pot);
    }
    // desactivar los botones
    public void endGame(){
        fold.setEnabled(false);
        check.setEnabled(false);
        raise.setEnabled(false);
        call.setEnabled(false);
        JButton botonSalir = new JButton("Salir");
        JPanel salirPanel = new JPanel();
        salirPanel.setLayout(null);
        salirPanel.setBounds(1800,900,100,30);
        botonSalir.setBounds(0,0,100,30);
        salirPanel.add(botonSalir);
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(salirPanel);
    }
    public void mostrarDineroDeTodosLosJugadores(ArrayList<Jugador> jugadores){
        String mensajeDinero = "";
        for (Jugador jugador : jugadores){
            mensajeDinero += jugador.getNombre() + ": $" + jugador.getDinero() + "\n";
        }
        dineroJugadores.setText(mensajeDinero);
    }
}
