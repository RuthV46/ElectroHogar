package electrohogar;

import javax.swing.JOptionPane;

public class Validaciones {
    
    	//Metodo para leer numeros enteros
	public static int leerEntero(String mensaje)
	{
		int num = 0;
                do{
		try
		{
	      	    
                    num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                    if(num<=0)
                        JOptionPane.showMessageDialog(null,"ERROR, el Numero debe ser mayor que cero");
                       
                }
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"ERROR - OJO la Excepcion es: " + e);
		}
                 }while(num<=0);
		return num;
	}

	//Metodo para leer numeros reales
	public static double leerReal(String mensaje)
	{
		double num = 0;
                do{
		try
		{
	      	    
                    num = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                    if(num<=0)
                        JOptionPane.showMessageDialog(null,"ERROR, el Numero debe ser mayor que cero");
                       
                }
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"ERROR - OJO la Excepcion es: " + e);
		}
                 }while(num<=0);
		return num;
	}
        //Metodo para leer cadenas de texto
	public static String leerString(String mensaje)
	{
		String cadena= "";
                do{
		try
		{
	      	    
                    cadena = JOptionPane.showInputDialog(mensaje);
                    if(cadena.equals(""))
                        JOptionPane.showMessageDialog(null,"ERROR, NO debe dejarla en blanco, \n¡DEBE ingresar informacion!");
                       
                }
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"ERROR - OJO la Excepcion es: " + e);
		}
                 }while(cadena.equals(""));
		return cadena;
        } 
        
        //Metodo para aceptar entrada de cadena de tipos de energia o gas
        public static String leerTipo(String mensaje) {
            String cadena = "";
            boolean ingresoValido = false;//Controla si el dato es correcto. Empieza en false porque aún no se ha validado.

            do {
                try {
                    cadena = JOptionPane.showInputDialog(mensaje);
                    if (cadena != null) {  // Verificar que no se haya presionado Cancelar
                        
                        //Compara la entrada de cadena (ignorando mayúsculas/minúsculas) con las opciones válidas
                        if (cadena.equalsIgnoreCase("GAS") || cadena.equalsIgnoreCase("ELECTRICO")) {
                            ingresoValido = true;//Si la entrada es correcta, sale del bucle
                        } else {//Si es incorrecto, muestra un mensaje de error y el bucle continúa.
                            JOptionPane.showMessageDialog(null, "ERROR, Ingresar solo GAS o ELECTRICO!");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR - OJO la Excepción es: " + e);
                }
            } while (!ingresoValido);//Mientras NO sea válido, se repite el ciclo 

            return cadena;//Devuelve "GAS" o "ELECTRICO" (en el formato en que se ingresó)
        }
}
