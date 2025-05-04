package electrohogar;

import javax.swing.JOptionPane;

public class ManejoPila {
    
    //creación de cola de refrigerador
    /*Este método retorna la cola de ponentes mientras que el usuario lo requiera*/
    public Pila ingresarDatos(Pila objP){
        
        Lavadora objL;
        int resp;
        //Ventana de confirmación
        resp=JOptionPane.showConfirmDialog(null,"Ingresar datos en la Pila de Lavadora", "Encolar datos", JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_OPTION){
            
            objL=new Lavadora();//Sobreescribe los datos
            objL=objL.ingresarDatos();
            //Encolar Refrigerador
            objP.Push(objL);//recibe los datos, los encola para poner apuntadores
            resp=JOptionPane.showConfirmDialog(null,"Ingresar otro dato en la cola de Refrigerador", "Encolar datos", JOptionPane.YES_NO_OPTION);
        }
        return objP;    
    }
    
    public String juntarDatos(Pila p, Pila aux){
        
        //cadena de retorno
        String texto="";
        Object lav;
        while(p.IsEmpty()==false)//repetir mientras la cola NO ESTE VACIA
        {
            lav=p.Pop();//desencola refrigerador
            texto=texto+lav.toString()+"\n";
            //encolaremos en la cola auxiliar(aux) para que no se pierda la info
            aux.Push(lav);
        }
        devolverOriginal(aux, p);
        return texto;//retorna la informacion desencolada
    }
    
    public void devolverOriginal(Pila auxiliary, Pila origin){
        while (auxiliary.IsEmpty()==false)
        {
            origin.Push(auxiliary.Pop());
        }
    }
    
     /*Elaborar promedio de precios de las lavadoras
    1. El metodo acumularPrecio retorna la suma de los precios acumulados
    */
    public double acumularPrecio(Pila p, Pila aux){
        double acum=0;//variable que acumula el precio
        Lavadora objL;//auxiliar de refrigerador para desencolar cada Lavadora
        while(p.IsEmpty()==false)
        {//mientras tenga datos
            objL=(Lavadora)p.Pop();//desencolamos el dato
            acum=acum+objL.getPrecioU();//se acumula el precio de la lavadoraa desencolado
            aux.Push(objL);//guarda el dato para que no se pierda
        }
        devolverOriginal(aux, p);//devuelve la informacion a la cola original
        return acum;
    }
    
         /*Elaborar promedio de precios de las lavadoras
    2. El metodo contarLava retorna la suma de cada refrigerador
    */
    public double contarLava(Pila p, Pila aux){
        int contar=0;//variable que cuenta los refrigeradores de la cola
        while(p.IsEmpty()==false)
        {//mientras tenga datos
            aux.Push(p.Pop());//desencolamos el dato para pasarlo a la cola auxiliar
            contar++;//cuenta un refrigerador
        }
        devolverOriginal(aux, p);//devuelve la informacion a la cola original
        return contar;
    }
    
    /*Elaborar promedio de precios de los refrigeradores
    3. El metodo para realizar el promedio de precios
    */
    public double promediaPrecio(Pila p, Pila aux){
        
        return (acumularPrecio(p, aux)/contarLava(p, aux));
    }
    
    public Pila PruebaEscritorio(Pila p)  {
      p.Push(new Lavadora("R001", "Whirlpool", "Z400", 2200.0, 15));
      p.Push(new Lavadora("R002", "Bosch", "B500", 2500.0, 20));
      p.Push(new Lavadora("R003", "Samsung", "S600", 2100.0, 10));
      p.Push(new Lavadora("R004", "LG", "L800", 2800.0, 20));

      return p;
  }
}
