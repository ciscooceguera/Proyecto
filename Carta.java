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
            case "Corazon", "Diamante":
                color = "Rojo";
                break;
            case "Pica", "Trebol":
                color = "Negro";
                break;
        }
    }
    // Metodo que retorna la ruta que representa a la carta
    public String obtenerImgRuta(){
        String path = "C:\\Users\\joser\\IdeaProjects\\Proyecto\\Cartas\\";
        switch(valor){
            case 11:
                path += "J"+figura+".png";
                break;
            case 12:
                path += "Q"+figura+".png";
                break;
            case 13:
                path += "K"+figura+".png";
                break;
            case 14:
                path += "A"+figura+".png";
                break;
            default:
                path += valor+figura+".png";
        }
        return path;
    }
    // retorna una cadena String que representa la impresión en consola de una carta
    public String toString(){
        switch(valor){
            case 11:
                return figura+": J";
            case 12:
                return figura+": Q";
            case 13:
                return figura+": K";
            case 14:
                return figura+": A";
        }
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
}