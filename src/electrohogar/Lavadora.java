package electrohogar;

public class Lavadora extends Electrodomestico {
    private double capacidadCarga;
    private Lavadora siguiente;
    
    public Lavadora(String numeroSerie, String marca, String modelo, double precioUnitario, double capacidadCarga) {
        super(numeroSerie, marca, modelo, precioUnitario);
        this.capacidadCarga = capacidadCarga;
        this.siguiente = null;
    }
    
    public void setSiguiente(Lavadora lavadora) {
        this.siguiente = lavadora;
    }
    
    public Lavadora getSiguiente() {
        return this.siguiente;
    }
    
}
