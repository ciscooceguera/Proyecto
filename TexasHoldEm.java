import java.util.ArrayList;

public class TexasHoldEm extends JuegoDePoker {
    public TexasHoldEm(){
        super();
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
        System.out.println("Es escalera de color?: " + manoConEscaleraReal.esEscaleraDeColor());
        System.out.println("Es escalera straight?: " + manoConEscaleraReal.esEscaleraStraight());
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
        System.out.println("Es escalera de color?: " + manoConEscaleraColor.esEscaleraDeColor());
        System.out.println("Es escalera straight?: " + manoConEscaleraColor.esEscaleraStraight());

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
        System.out.println("Es escalera de color?: " + manoConEscaleraStraight.esEscaleraDeColor());
        System.out.println("Es escalera straight?: " + manoConEscaleraStraight.esEscaleraStraight());




    }

}