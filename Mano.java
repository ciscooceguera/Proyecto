import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mano {
    private ArrayList<Carta> mano;
    public Mano(ArrayList<Carta> mano) {
        this.mano = mano;
    }
    public ArrayList<Carta> getMano() {
        return mano;
    }
    public Carta eliminarCarta(int posicion){
        return mano.remove(posicion);
    }
    /* Retorna tipo int, devuelve el valor de la carta con el mayor valor en la mano
    ignorando el As. */
    public int getValorMayor(){
        acomodarMano();
        if (mano.getLast().getValor() == 14){
            return mano.get(mano.size()-2).getValor();
        }
        return mano.getLast().getValor();

    }
    public boolean esEscalera(){
        acomodarMano();
        int contadorCartasConsecutivas = 1;
        int valorActual = 0;
        for (Carta carta : mano) {
            if (valorActual != 0){
                if (valorActual+1 == carta.getValor()){
                    valorActual = carta.getValor();
                    contadorCartasConsecutivas++;
                }else if (carta.getValor() == 14 && getValorMayor() == 5){
                    contadorCartasConsecutivas++;
                }
            }else{
                valorActual = carta.getValor();
            }
        }
        return contadorCartasConsecutivas == mano.size();
    }
    public void acomodarMano(){
        Collections.sort(mano);
    }
    public boolean esMismaFigura(){
        int contadorRepeticionesFigura = 0;
        String figuraActual = "";
        for (Carta carta : mano){
            if (contadorRepeticionesFigura != 0){
                if (carta.getFigura().equals(figuraActual)){
                    contadorRepeticionesFigura++;
                }else{    // retorna booleano, evalúa si todas las cartas que componen la mano son de la misma figura

                    break;
                }
            }else{
                figuraActual = carta.getFigura();
                contadorRepeticionesFigura++;
            }
        }
        return contadorRepeticionesFigura == mano.size();
    }
    // retorna booleano, evalúa si todas las cartas que componen la mano son del mismo color
//    public boolean esMismoColor(){
//        int contadorRepeticionesColor = 0;
//        String colorActual = "";
//        for (Carta carta : mano){
//            if (contadorRepeticionesColor != 0){
//                if (carta.getColor().equals(colorActual)){
//                    contadorRepeticionesColor++;
//                }else{
//                    break;
//                }
//            }else{
//                colorActual = carta.getColor();
//                contadorRepeticionesColor++;
//            }
//        }
//        return contadorRepeticionesColor == mano.size();
//    }
    // Retorna booleano, evalúa si la mano contiene una escalera real
    public boolean esEscaleraReal(){
        return esMismaFigura();
    }
    // Retorna booleano, evalúa si la mano contiene una escalera de color
//    public boolean esEscaleraDeColor(){
//        return esMismoColor();
//    }
    // Retorna booleano, evalúa si la mano contiene una escalera straight
//    public boolean esEscaleraStraight(){
//        return !esEscaleraReal() && !esEscaleraDeColor();
//    }
//    // Retorna una cadena que representa la impresión de la mano en consola
//    public String toString(){
//        String manoString = "";
//        for (Carta carta : mano) {
//            manoString += carta.toString()+"\n";
//        }
//        return manoString;
//    }

}
