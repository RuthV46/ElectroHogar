package electrohogar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        Tienda tienda = new Tienda();
        String opcionLavadora;
        String opcionRefrigerador;
        
        System.out.print("¿Desea ingresar una lavadora? SI/NO:  ");
        opcionLavadora = scanner.next();
        scanner.nextLine();
        
        while(!"NO".equals(opcionLavadora)){
            
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
            
            System.out.print("¿Desea adicionar lavadora? SI/NO: ");
            opcionLavadora = scanner.next();
            scanner.nextLine();
        }
        
        System.out.print("¿Desea ingresar un refrigerador? SI/NO: ");
        opcionRefrigerador = scanner.next();
        scanner.nextLine();
        
        while(!"NO".equals(opcionRefrigerador)){
                    
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
            System.out.print("¿Desea adicionar refrigerador? SI/NO: ");
            opcionRefrigerador = scanner.next();
            scanner.nextLine();
        } 
        
        System.out.println("Promedio de precios de lavadoras: " + tienda.calcularPromedioLavadoras());
        System.out.println("Promedio de precios de refrigeradores: " + tienda.calcularPromedioRefrigeradores());
        
        System.out.println("Lista de refrigeradores a gas:");
        tienda.mostrarRefrigeradoresAGas();
        
        scanner.close();
    }
}
