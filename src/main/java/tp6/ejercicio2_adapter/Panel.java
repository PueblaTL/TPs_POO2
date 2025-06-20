package tp6.ejercicio2_adapter;

public interface Panel {

    void circulo(Coordenada coor, int radio);

    void linea(Coordenada coor, int longitud);

    void texto(Coordenada coor, String texto);

}