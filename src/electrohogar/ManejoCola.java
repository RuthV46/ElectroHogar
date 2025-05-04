package electrohogar;

import javax.swing.JOptionPane;

public class ManejoCola {
    
    //creación de cola de refrigerador
    /*Este método retorna la cola de ponentes mientras que el usuario lo requiera*/
    public Cola ingresarDatos(Cola objC){
        
        Refrigerador objR;
        int resp;
        //Ventana de confirmación
        resp=JOptionPane.showConfirmDialog(null,"Ingresar datos en la Cola de Refrigerador", "Encolar datos", JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_OPTION){
            
            objR=new Refrigerador();//Sobreescribe los datos
            objR=objR.ingresarDatos();
            //Encolar Refrigerador
            objC.Push(objR);//recibe los datos, los encola para poner apuntadores
            resp=JOptionPane.showConfirmDialog(null,"Ingresar otro dato en la cola de Refrigerador", "Encolar datos", JOptionPane.YES_NO_OPTION);
        }
        return objC;    
    }
        
    /*Método que retorna en una cadena los datos almacenados en la cola de Refrigerador, sin perder datos*/
    public String juntarDatos(Cola co, Cola aux){
        
        //cadena de retorno
        String texto="";
        Object re;
        while(co.IsEmpty()==false)//repetir mientras la cola NO ESTE VACIA
        {
            re=co.Pop();//desencola refrigerador
            texto=texto+re.toString()+"\n";
            //encolaremos en la cola auxiliar(aux) para que no se pierda la info
            aux.Push(re);
        }
        devolverOriginal(aux, co);
        return texto;//retorna la informacion desencolada
    }
    
    /*Metodo que toma los datos de la cola Auxiliar y los devuelve a la cola de Origen*/
    public void devolverOriginal(Cola auxiliary, Cola origin){
        while (auxiliary.IsEmpty()==false)
        {
            origin.Push(auxiliary.Pop());
        }
    }
    
    /*Elaborar promedio de precios de los refrigeradores
    1. El metodo acumularPrecio retorna la suma de los precios acumulados
    */
    public double acumularPrecio(Cola co, Cola aux){
        double acum=0;//variable que acumula el precio
        Refrigerador objR;//auxiliar de refrigerador para desencolar cada refrigerador
        while(co.IsEmpty()==false)
        {//mientras tenga datos
            objR=(Refrigerador)co.Pop();//desencolamos el dato
            acum=acum+objR.getPrecioU();//se acumula el precio del refrigerador desencolado
            aux.Push(objR);//guarda el dato para que no se pierda
        }
        devolverOriginal(aux, co);//devuelve la informacion a la cola original
        return acum;
    }
    
     /*Elaborar promedio de precios de los refrigeradores
    2. El metodo contarRefri retorna la suma de cada refrigerador
    */
    public double contarRefri(Cola co, Cola aux){
        int contar=0;//variable que cuenta los refrigeradores de la cola
        while(co.IsEmpty()==false)
        {//mientras tenga datos
            aux.Push(co.Pop());//desencolamos el dato para pasarlo a la cola auxiliar
            contar++;//cuenta un refrigerador
        }
        devolverOriginal(aux, co);//devuelve la informacion a la cola original
        return contar;
    }
    
    /*Elaborar promedio de precios de los refrigeradores
    3. El metodo para realizar el promedio de precios
    */
    public double promediaPrecio(Cola co, Cola aux){
        
        return (acumularPrecio(co, aux)/contarRefri(co, aux));
    }
    
    /*Cuantos refrigeradores son de tipo gas*/
    public int contarTipo(Cola co, Cola aux){
        int contar=0;//variable que cuenta los refrigeradores de la cola
        Refrigerador objR;
        while(co.IsEmpty()==false)
        {//mientras tenga datos en cola
            objR=(Refrigerador)co.Pop();
            if(objR.getTipoEnergia().equalsIgnoreCase("GAS")){ 
                contar++;// va contar los refrigeradores tipo GAS
            }
            aux.Push(objR);//desencolamos el dato para pasarlo a la cola auxiliar
        }
        devolverOriginal(aux, co);//devuelve la informacion a la cola original
        return contar;
    }
    
    /*Cuales refrigeradores son de tipo gas*/
    public String mostrarRefriPorTipo(Cola co, Cola aux){
        
        String texto="";
        Refrigerador objR;
        while(co.IsEmpty()==false){
            objR=(Refrigerador)co.Pop();
            if(objR.getTipoEnergia().equalsIgnoreCase("GAS"))//validar si el dato es tipo GAS
            {
                 texto = texto + objR.toString() + "\n";                 
            }   
            aux.Push(objR); 
        }   
        devolverOriginal(aux, co);
        return texto;
    }
    
    public Cola PruebaEscritorio(Cola co)  {
      co.Push(new Refrigerador("R001", "Whirlpool", "Z400", 2200.0, "GAS"));
      co.Push(new Refrigerador("R002", "Bosch", "B500", 2500.0, "ELECTRICO"));
      co.Push(new Refrigerador("R003", "Samsung", "S600", 2100.0, "GAS"));
      co.Push(new Refrigerador("R004", "LG", "L800", 2800.0, "GAS"));

      return co;
  }
}
