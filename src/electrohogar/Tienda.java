package electrohogar;

public class Tienda {
    private Lavadora primeraLavadora;
    private Refrigerador primerRefrigerador;
    
    public Tienda() {
        this.primeraLavadora = null;
        this.primerRefrigerador = null;
    }
    
    public void agregarLavadora(Lavadora lavadora) {
        if (this.primeraLavadora == null) {
            this.primeraLavadora = lavadora;
        } else {
            Lavadora temp = this.primeraLavadora;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(lavadora);
        }
    }
    
    public void agregarRefrigerador(Refrigerador refrigerador) {
        if (this.primerRefrigerador == null) {
            this.primerRefrigerador = refrigerador;
        } else {
            Refrigerador temp = this.primerRefrigerador;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(refrigerador);
        }
    }
    
    public double calcularPromedioLavadoras() {
        double suma = 0;
        int cantidad = 0;
        Lavadora temp = this.primeraLavadora;
        while (temp != null) {
            suma += temp.getPrecioUnitario();
            cantidad++;
            temp = temp.getSiguiente();
        }
        return cantidad == 0 ? 0 : suma / cantidad;
    }
    
    public double calcularPromedioRefrigeradores() {
        double suma = 0;
        int cantidad = 0;
        Refrigerador temp = this.primerRefrigerador;
        while (temp != null) {
            suma += temp.getPrecioUnitario();
            cantidad++;
            temp = temp.getSiguiente();
        }
        return cantidad == 0 ? 0 : suma / cantidad;
    }
    
    public void mostrarRefrigeradoresAGas() {
        Refrigerador temp = this.primerRefrigerador;
        while (temp != null) {
            if (temp.getTipoEnergia().equalsIgnoreCase("gas")) {
                System.out.println("Refrigerador a gas: " + temp.marca + " " + temp.modelo);
            }
            temp = temp.getSiguiente();
        }
    }    
}
