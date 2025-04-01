package electrohogar;

import java.util.Scanner;

public abstract class Electrodomestico {
    /*El modificador protected en la clase Electrodomestico permite que las clases hijas (Lavadora y Refrigerador
         accedan directamente a los atributos sin necesidad de usar getters y setters
    */
    protected String numeroSerie;
    protected String marca;
    protected String modelo;
    protected double precioUnitario;
    
    public Electrodomestico(String numeroSerie, String marca, String modelo, double precioUnitario) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.precioUnitario = precioUnitario;
    }
    
    public double getPrecioUnitario() {
        return this.precioUnitario;
    }
}