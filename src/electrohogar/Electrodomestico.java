package electrohogar;

public abstract class Electrodomestico {
    private String nSerie, marca, modelo;
    private double precioU;
    
    public Electrodomestico(){}

    public Electrodomestico(String nSerie, String marca, String modelo, double precioU) {
        this.nSerie = nSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.precioU = precioU;
    }

    @Override
    public String toString() {
        return " nSerie=" + nSerie + ", marca=" + marca + ", modelo=" + modelo + ", precioU=" + precioU;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }   

}
    
    
