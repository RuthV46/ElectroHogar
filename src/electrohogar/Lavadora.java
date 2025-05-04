package electrohogar;

import javax.swing.JOptionPane;

public class Lavadora extends Electrodomestico {
    private double capacidadKilo;

    public Lavadora(double capacidadKilo) {
        this.capacidadKilo = capacidadKilo;
    }

    public Lavadora() {
    }
    
    public Lavadora(String nSerie, String marca, String modelo, double precioU, double capacidadKilo) {
        super(nSerie, marca, modelo, precioU);
        this.capacidadKilo = capacidadKilo;
    }
    
    public Lavadora ingresarDatos(){
        
        //locales auxiliares para la lectura
        String serie,trademark,model;
        double priceU, capacity;
        serie=Validaciones.leerString("Digite el numero de serie de la lavadora: ");
        trademark=Validaciones.leerString("Digite la marca de la lavadora: ");
        model=Validaciones.leerString("Digite el modelo de la lavadora: ");
        priceU=Validaciones.leerReal("Digite el precio unitario de la lavadora: ");
        capacity=Validaciones.leerReal("Digite la capacidad de carga en kilos de la lavadora: ");
        
        //instanciamos la clase o sea crear el objeto
        Lavadora objL;
        //llamar al constructor
        objL=new Lavadora(serie,trademark, model, priceU, capacity);
        return objL;
    }

    @Override
    public String toString() {
        //Para llamar la informacion contenida en los atributos heredados se realiza lo siguiente:
        return "Lavadora {"+ super.toString() + ", capacidad de carga= " + capacidadKilo +" Kg }";
    }

    public double getCapacidadKilo() {
        return capacidadKilo;
    }

    public void setCapacidadKilo(double capacidadKilo) {
        this.capacidadKilo = capacidadKilo;
    }
    
}
