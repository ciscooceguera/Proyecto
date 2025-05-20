import java.util.*;
import java.util.stream.Collectors;

public class Mano implements Comparable{
    private ArrayList<Carta> mano;
    private int puntaje;
    public Mano(ArrayList<Carta> mano) {
        this.mano = mano;
        acomodarMano();
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
        if (mano.getLast().getValor() == 14){
            return mano.get(mano.size()-2).getValor();
        }
        return mano.getLast().getValor();

    }
    public boolean esEscalera(){
        acomodarMano();
        List<Integer> valores = new ArrayList<>();

        for (Carta carta : mano) {
            int valor = carta.getValor();
            if (!valores.contains(valor)) {
                valores.add(valor);
            }
        }
        if (valores.contains(14)) {
            valores.add(1);
            Collections.sort(valores);
        }

        int consecutivos = 1;
        for (int i = 0; i < valores.size() - 1; i++) {
            if (valores.get(i + 1) == valores.get(i) + 1) {
                consecutivos++;
                if (consecutivos == 5) return true;
            } else {
                consecutivos = 1;
            }
        }
        return false;
    }
    // retorna true si hay un par
    public boolean hayPar(){
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
        for (Carta carta : mano){
            int numRepetidas = cuantasRepetidas(carta);
            if (numRepetidas == 4){
                return true;
            }
        }
        return false;
    }
    public int getValorPoquer(){
        for (Carta carta : mano){
            int numRepetidas = cuantasRepetidas(carta);
            if (numRepetidas == 4){
                return mano.get(mano.size()-1).getValor();
            }
        }
        return 0;
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
    public boolean esFullHouse(){
        return hayPar() && hayTercia();
    }
    // Retorna booleano, evalúa si la mano contiene una escalera real
    public boolean esEscaleraReal(){
        return esMismaFigura() && getCartaMasAlta() == 14 && getCartaMasBaja() == 10 && esEscalera();
    }
    // Retorna booleano, evalúa si la mano contiene una escalera de color
    public boolean esEscaleraDeColor(){
        return esMismaFigura() && esEscalera();
    }
    // Retorna booleano, evalúa si la mano contiene una escalera straight
    public boolean esEscaleraStraight(){
        return !esEscaleraReal() && !esEscaleraDeColor() && esEscalera();
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
    public boolean esFlush(){
        return !esEscalera() && esMismaFigura();
    }
    public ArrayList<Carta> devolverCartas(){
        return mano;
    }
    public int getCartaMasBaja(){
        return Collections.min(mano).getValor();
    }
    public int getValorTercia(){
        for (Carta carta : mano){
            int numRepetidas = cuantasRepetidas(carta);
            if (numRepetidas == 3){
                return mano.get(mano.size()-1).getValor();
            }
        }
        return 0;
    }
    public int getValorParMasAlto(){
        ArrayList<Integer> valoresPares = new ArrayList<>();
        for (Carta carta : mano){
            int numRepetidas = cuantasRepetidas(carta);
            if (numRepetidas == 2){
                valoresPares.add(carta.getValor());
            }
        }
        return Collections.max(valoresPares);
    }
    public int getValorPar(){
        for (Carta carta : mano){
            int numRepetidas = cuantasRepetidas(carta);
            if (numRepetidas == 2){
                return carta.getValor();
            }
        }
        return 0;
    }


    public int getValorParMasBajo(){
        ArrayList<Integer> valoresPares = new ArrayList<>();
        for (Carta carta : mano){
            int numRepetidas = cuantasRepetidas(carta);
            if (numRepetidas == 2){
                valoresPares.add(carta.getValor());
            }
        }
        return Collections.min(valoresPares);
    }
    public int getPuntaje(){
        int puntajeBase = 0;
        if (esEscaleraReal()){
            puntajeBase = 1000 + getCartaMasAlta();
        }else if (esEscaleraDeColor()){
            puntajeBase = 900 + getCartaMasAlta();
        }else if (esPoker()){
            puntajeBase = 800 + getValorPoquer();
        }else if (esFullHouse()){
            puntajeBase = 700 + getValorTercia();
        }else if (esFlush()){
            puntajeBase = 600 + getCartaMasAlta();
        }else if (esEscaleraStraight()){
            puntajeBase = 500 + getCartaMasAlta();
        }else if (hayTercia()){
            puntajeBase = 400 + getValorTercia();
        }else if (hayDosPares()){
            puntajeBase = 300 + getValorParMasAlto();
        }else if (hayPar()){
            puntajeBase = 200 + getValorPar();
        }else{
            puntajeBase = 100 + getCartaMasAlta();
        }
        return puntajeBase;
    }
    @Override
    public int compareTo(Object o) {
        Mano m = (Mano) o;

        if (getPuntaje() == m.getPuntaje()){
            if (hayDosPares() && m.hayDosPares()){
                if (getValorParMasAlto() == m.getValorParMasAlto()) {
                    if (getValorParMasBajo() == m.getValorParMasBajo()) {
                        return getCartaMasAlta() - m.getCartaMasAlta();
                    } else {
                        return getCartaMasBaja() - m.getCartaMasBaja();
                    }
                }
            }else if (hayPar() && m.hayPar()){
                if (getValorPar() == m.getValorPar()) {
                    return getCartaMasAlta() - m.getCartaMasAlta();
                }
            }else{
                acomodarMano();
                m.acomodarMano();
                if (mano.get(mano.size()-2).getValor() - m.mano.get(mano.size()-2).getValor() == 0){
                    if (mano.get(mano.size()-3).getValor() - m.mano.get(mano.size()-3).getValor() == 0){
                        if (mano.get(mano.size()-4).getValor() - m.mano.get(mano.size()-4).getValor() == 0){
                            return mano.get(mano.size()-5).getValor() - m.mano.get(mano.size()-5).getValor();
                        }else{
                            return mano.get(mano.size()-4).getValor() - m.mano.get(mano.size()-4).getValor();
                        }
                    }else{
                        return mano.get(mano.size()-3).getValor() - m.mano.get(mano.size()-3).getValor();
                    }
                }else{
                    return mano.get(mano.size()-2).getValor() - m.mano.get(mano.size()-2).getValor();
                }
            }

        }

        return getPuntaje() - m.getPuntaje();
    }

    public void concatenarCartas(ArrayList<Carta> cartasComunitarias){
        mano.addAll(cartasComunitarias);
        acomodarMano();
    }

    @Override
    public boolean equals(Object obj) {
        int coincidencias = 0;
        acomodarMano();
        Mano m = (Mano) obj;
        m.acomodarMano();
        for (int i = 0; i < mano.size(); i++) {
            if (mano.get(i).getValor() == m.getMano().get(i).getValor()){
                if (mano.get(i).getFigura() == m.getMano().get(i).getFigura()){
                    coincidencias++;
                }
            }
        }
        if (coincidencias == mano.size()){
            return true;
        }
        return false;
    }

    public void removerCarta(Carta carta){
        for (Carta c : mano){
            if (c.getValor() == carta.getValor()){
                if (c.getFigura() == carta.getFigura()){
                    mano.remove(c);
                }
            }
        }
    }
}
