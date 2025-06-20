package tp6.ejercicio2_adapter;

import java.awt.*;

public class DibujoAdapter implements Panel{
    Graphics2D g2d;

    public DibujoAdapter(Graphics2D g2d) {
        this.g2d = g2d;
    }

    @Override
    public void circulo(Coordenada coordenada,int radio) {
        g2d.drawOval(coordenada.x() - radio,
                coordenada.y() - radio,
                radio * 2,
                radio * 2);
    }

    @Override
    public void linea(Coordenada coordenada,int longitud) {
        g2d.drawLine(coordenada.x(), coordenada.y(), coordenada.x() + longitud, coordenada.y());
    }

    @Override
    public void texto(Coordenada coordenada,String texto) {
        g2d.drawString(texto, coordenada.x(), coordenada.y());
    }
}