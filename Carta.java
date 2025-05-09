import javax.swing.*;

public class Carta implements Comparable {
    private String figura, color;
    private int valor;
    // Constructor recibe la figura de la carta y el valor
    public Carta(String figura, int valor){
        this.figura = figura;
        this.valor = valor;
        setColor();
    }
    // Retorna el color
    public String getColor(){
        return color;
    }
    // Setter para definir el color de la carta
    public void setColor(){
        switch(figura){
            case "Corazón", "Diamante":
                color = "Rojo";
                break;
            case "Pica", "Trébol":
                color = "Negro";
                break;
        }
    }
    // Método que retorna la imagen que representa a la carta
    public Icon obtenerIcono(){
        String path = "C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\Proyecto\\Cartas\\"+figura+valor+".jpg";
        return new ImageIcon(path);
    }
    // retorna una cadena String que representa la impresión en consola de una carta
    public String toString(){
        return figura + ": " + valor;
    }
    // retorne el valor
    public int getValor(){
        return valor;
    }
    // getter figura
    public String getFigura(){
        return figura;
    }
    // compara una carta con otra
    @Override
    public int compareTo(Object o) {
        Carta otraCarta = (Carta) o;
        return valor - otraCarta.valor;
    }

    // borrar metodos, lo puse para probar cosas
    public void setValor(int valor){
        this.valor = valor;
    }
    public void setFigura(String figura){
        this.figura = figura;
    }
}
