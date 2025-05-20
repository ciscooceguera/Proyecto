public class Jugador implements Comparable{
    private String nombre;
    private int dinero;
    private Mano mano, manoComunitaria;
    public Jugador(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;

    }
    public void incrementarDinero(int sumDinero){
        dinero += sumDinero;
    }
    public void reducirDinero(int sumDinero){
        dinero -= sumDinero;
    }
    public int getDinero(){
        return dinero;
    }
    public String getNombre(){
        return nombre;
    }
    public Mano getMano(){
        return mano;
    }
    public void setMano(Mano mano){
        this.mano = mano;
    }
    public void setManoComunitaria(Mano manoComunitaria){
        this.manoComunitaria = new Mano(manoComunitaria.getMano());
    }


    @Override
    public int compareTo(Object o){
        Jugador jugador = (Jugador)o;
        return manoComunitaria.compareTo(jugador.manoComunitaria);
    }

    public String toString(){
        return "\nNombre: " + nombre + "\nDinero: " + dinero + "\nMano: " + mano;
    }
}
