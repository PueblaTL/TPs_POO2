package tp3.ejercicio3;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {
        var g1 = new Gasto(Gasto.TipoDeGasto.DESAYUNO,1000);
        var g2 = new Gasto(Gasto.TipoDeGasto.CENA,6000);
        var reporte = new ReporteDeGastos();
        reporte.agregarGasto(g1);
        reporte.agregarGasto(g2);
        System.out.println(
        reporte.obtenerFormatoDetalleTotal());
    }
}
