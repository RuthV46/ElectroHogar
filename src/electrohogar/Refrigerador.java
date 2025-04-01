package electrohogar;

public class Refrigerador extends Electrodomestico{
    private String tipoEnergia;
    private Refrigerador siguiente;
    
    public Refrigerador(String numeroSerie, String marca, String modelo, double precioUnitario, String tipoEnergia) {
        super(numeroSerie, marca, modelo, precioUnitario);
        this.tipoEnergia = tipoEnergia;
        this.siguiente = null;
    }
    
    public void setSiguiente(Refrigerador refrigerador) {
        this.siguiente = refrigerador;
    }
    
    public Refrigerador getSiguiente() {
        return this.siguiente;
    }
    
    public String getTipoEnergia() {
        return this.tipoEnergia;
    }
    
}
