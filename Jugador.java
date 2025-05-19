public class Jugador {
    private String nombre;
    private int dinero;
    private Mano mano;
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
}
