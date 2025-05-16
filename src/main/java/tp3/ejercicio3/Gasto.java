package tp3.ejercicio3;

import static java.lang.System.lineSeparator;

class Gasto {
    TipoDeGasto tipoGasto;
    int monto;

    enum TipoDeGasto {
        CENA, DESAYUNO, ALQUILER_AUTO;
    }

    public Gasto(TipoDeGasto tipoGasto, int monto) throws RuntimeException {
        if (tipoGasto == null) {
            throw new RuntimeException("El tipo de gasto no puede ser nulo");
        }
        if (monto <= 0) {
            throw new RuntimeException("El monto debe ser mayor que cero");
        }

        this.tipoGasto = tipoGasto;
        this.monto = monto;
    }

    public int calcularGastoDeComida() {
        int gastosDeComida = 0;
        if (esTipoDeGasto("CENA") || esTipoDeGasto("DESAYUNO")) {
            gastosDeComida += monto();
        }
        return gastosDeComida;
    }

    public boolean esTipoDeGasto(String tipo) {
        if (tipo == null) return false;
        return tipo.equals(String.valueOf(tipoGasto));
    }

    public String getTipoGastoString() {
        String tipo = String.valueOf(tipoGasto).toLowerCase();
        if (tipo.isEmpty()) return "";
        return tipo.substring(0, 1).toUpperCase() + tipo.substring(1);
    }

    public String formatoDetalleDeGasto() {
        String nombreGasto = getTipoGastoString();
        String marcaExcesoComidas = (esTipoDeGasto("CENA") && monto() > 5000)
                || (esTipoDeGasto("DESAYUNO") && monto() > 1000)
                ? "Exceso" : "";

        return  nombreGasto + "\t" + monto() + "\t" + marcaExcesoComidas + lineSeparator();
    }

    public int monto() {
        return monto;
    }
}
