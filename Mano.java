import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
    // retorna true si hay un par
    public boolean hayPar(){
        acomodarMano();
        int contadorCartasConsecutivas = 1;
        for (Carta carta : mano) {
            if (cuantasRepetidas(carta) == 2){
                return true;
            }
        }
        return false;
    }
    // retorna true si hay dos pares
    public boolean hayDosPares(){
        HashSet<Integer> pares = new HashSet<>();
        acomodarMano();
        for (int i = 0; i<mano.size(); i++){
            Carta carta = mano.get(i);
            if (cuantasRepetidas(carta) == 2){
                pares.add(carta.getValor());
            }
        }
        return pares.size() == 2;
    }
    // retorna true si hay una tercia
    public boolean hayTercia(){
        for (Carta carta : mano){
            int numRepetidas = cuantasRepetidas(carta);
            if (numRepetidas == 3){
                return true;
            }
        }
        return false;
    }
    public int cuantasRepetidas(Carta carta){
        int contadorCartasRepetidas = 1;
        for (Carta cartas : mano) {
            if (cartas.getValor() == carta.getValor()){
                contadorCartasRepetidas++;
            }
        }
        return contadorCartasRepetidas-1;
    }
    // retorna booleano si la mano contiene un póquer; 4 cartas del mismo valor
    public boolean esPoker(){
        acomodarMano();
        for (Carta carta : mano){
            int numRepetidas = cuantasRepetidas(carta);
            if (numRepetidas == 4){
                return true;
            }
        }
        return false;
    }
    // acomoda la mano usando sort() de Collections
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
    public boolean esMismoColor(){
        int contadorRepeticionesColor = 0;
        String colorActual = "";
        for (Carta carta : mano){
            if (contadorRepeticionesColor != 0){
                if (carta.getColor().equals(colorActual)){
                    contadorRepeticionesColor++;
                }else{
                    break;
                }
            }else{
                colorActual = carta.getColor();
                contadorRepeticionesColor++;
            }
        }
        return contadorRepeticionesColor == mano.size();
    }
    // Retorna booleano, evalúa si la mano contiene una escalera real
    public boolean esEscaleraReal(){
        return esMismaFigura();
    }
    // Retorna booleano, evalúa si la mano contiene una escalera de color
    public boolean esEscaleraDeColor(){
        return esMismoColor();
    }
    // Retorna booleano, evalúa si la mano contiene una escalera straight
    public boolean esEscaleraStraight(){
        return !esEscaleraReal() && !esEscaleraDeColor();
    }
    // Retorna una cadena que representa la impresión de la mano en consola
    public String toString(){
        String manoString = "";
        for (Carta carta : mano) {
            manoString += carta.toString()+"\n";
        }
        return manoString;
    }
    public int getCartaMasAlta(){
        return Collections.max(mano).getValor();
    }

}
