package electrohogar;

import javax.swing.JOptionPane;

public class Refrigerador extends Electrodomestico {
    private String tipoEnergia;

    public Refrigerador() {
    }

    public Refrigerador(String nSerie, String marca, String modelo, double precioU, String tipoEnergia) {
        super(nSerie, marca, modelo, precioU);
        this.tipoEnergia = tipoEnergia;
    }
    
    public Refrigerador ingresarDatos(){
        
        //locales auxiliares para la lectura
        String serie, trademark, model, type;
        double priceU=0;
        serie=Validaciones.leerString("Digite el numero de serie del refrigerador: ");
        trademark=Validaciones.leerString("Digite la marca del refrigerador: ");
        model=Validaciones.leerString("Digite el modelo del refrigerador: ");
        priceU=Validaciones.leerReal("Digite el precio unitario del refrigerador: ");
        type=Validaciones.leerTipo("Digite el tipo de energia del refrigerador: \n"
                +"GAS o ELECTRICO: ").toUpperCase();
        //instanciamos la clase o sea crear el objeto
        Refrigerador objR;
        //llamar al constructor
        objR=new Refrigerador(serie, trademark, model, priceU, type);
        return objR;
    }

    @Override
    public String toString() {
        super.toString();
        return "Refrigerador {"+ super.toString() + ", tipo de Energia=" + tipoEnergia + "}";
    }
    
    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {               
        this.tipoEnergia = tipoEnergia;
    }
    
}
