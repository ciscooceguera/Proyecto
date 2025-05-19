import java.util.*;

public class Mazo {
    private ArrayList<Carta> mazo;
    // Constructor del mazo inicializa el atributo
    public Mazo(){
        mazo = new ArrayList<Carta>();
        crearMazo();
        revolverMazo();
    }
    /* Crea el mazo iterando 2 vectores, uno que contiene los
    4 tipos de figura presentes en las cartas, y el otro vector, que contiene
    todos los valores que pueden contener las cartas. */
    public void crearMazo(){
        String[] figurasCartas = {"Corazon","Trebol","Pica","Diamante"};
        int[] valoresCartas = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        for (String figura : figurasCartas) {
            for (int valor : valoresCartas) {
                mazo.add(new Carta(figura,valor));
            }
        }
    }
    // Revuelve el mazo usando la clase Random
    public void revolverMazo(){
        Collections.shuffle(mazo);
    }
    /* toma N cartas, recibe de parámetro el número de cartas que se desean,
    retorna un ArrayList de tipo Carta. */
    public ArrayList<Carta> tomarCartas(int numCartas) {
        ArrayList<Carta> cartas = new ArrayList<>();
        for (int i = 0; i < numCartas; i++) {
            cartas.add(mazo.remove(i));
        }
        return cartas;
    }
    // Limpia el mazo
    public void clearMazo(){
        mazo.clear();
    }
    // toma una carta
    public Carta tomarCarta(){
        return mazo.removeFirst();
    }
    // retorna una cadena string, que representa la impresión en consola del mazo
    public String toString(){
        String mazoString = "";
        for (Carta carta : mazo) {
            mazoString+=carta.toString()+"\n";
        }
        return mazoString;
    }
}
