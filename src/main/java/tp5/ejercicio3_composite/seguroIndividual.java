package tp5.ejercicio3_composite;

public class seguroIndividual implements Seguro{
    private int CostoSeguro;

    public seguroIndividual (int Costo){
        this.CostoSeguro = Costo;
    }
    @Override
    public int getCosto() {
        return CostoSeguro;
    }
}
