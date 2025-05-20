public class Jugador implements Comparable{
    private String nombre;
    private int dinero;
    private Mano mano, manoComunitaria;
    public Jugador(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;

    }
    // Se encarga de incrementar el dinero del jugador, con un valor recibido como parámetro.
    public void incrementarDinero(int sumDinero){
        dinero += sumDinero;
    }
    // Se encarga de reducir el dinero del jugador, con un valor recibido como parámetro.
    public void reducirDinero(int sumDinero){
        dinero -= sumDinero;
    }
    // Se encarga de regresar el dinero del jugador con un getter.
    public int getDinero(){
        return dinero;
    }
    // Se encarga de regresar el nombre del jugador con un getter.
    public String getNombre(){
        return nombre;
    }
    // Se encarga de regresar la mano del jugador con un getter.
    public Mano getMano(){
        return mano;
    }
    // Se encarga de establecer una mano para el jugador, con un valor recibido como parámetro.
    public void setMano(Mano mano){
        this.mano = mano;
    }
    // Se encarga de establecer una mano nueva para el jugador, con un valor recibido como parámetro.
    public void setManoComunitaria(Mano manoComunitaria){
        this.manoComunitaria = new Mano(manoComunitaria.getMano());
    }


    // Se encarga de comparar las manos comunitarias de 2 jugadores mediante la interfaz de Comparable.
    @Override
    public int compareTo(Object o){
        Jugador jugador = (Jugador)o;
        return manoComunitaria.compareTo(jugador.manoComunitaria);
    }

    // Se encarga de regresar todos los datos del jugador mediante un método toString().
    public String toString(){
        return "\nNombre: " + nombre + "\nDinero: " + dinero + "\nMano: " + mano;
    }
}