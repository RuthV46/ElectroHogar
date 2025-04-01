package electrohogar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tienda tienda = new Tienda();
        
        System.out.print("Ingrese la cantidad de lavadoras: ");
        int numLavadoras = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numLavadoras; i++) {
            System.out.print("Número de serie: ");
            String numeroSerie = scanner.nextLine();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Capacidad de carga: ");
            double capacidad = scanner.nextDouble();
            scanner.nextLine();
            
            tienda.agregarLavadora(new Lavadora(numeroSerie, marca, modelo, precio, capacidad));
            
            System.out.println("<--->");
        }
        
        System.out.print("Ingrese la cantidad de refrigeradores: ");
        int numRefrigeradores = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numRefrigeradores; i++) {
            System.out.print("Número de serie: ");
            String numeroSerie = scanner.nextLine();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Tipo de energía (gas/eléctrica): ");
            String tipoEnergia = scanner.nextLine();
            
            tienda.agregarRefrigerador(new Refrigerador(numeroSerie, marca, modelo, precio, tipoEnergia));
            
            System.out.println("<--->");
        }
        
        System.out.println("Promedio de precios de lavadoras: " + tienda.calcularPromedioLavadoras());
        System.out.println("Promedio de precios de refrigeradores: " + tienda.calcularPromedioRefrigeradores());
        
        System.out.println("Lista de refrigeradores a gas:");
        tienda.mostrarRefrigeradoresAGas();
        
        scanner.close();
    }
}
