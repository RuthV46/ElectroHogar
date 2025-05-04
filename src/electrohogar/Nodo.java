/*
----------------
      Nodo 
----------------
-Dato: objeto
- sig: Nodo
- ant: Nodo
----------------
Nodo()
Nodo(d)
Nodo(li,d,ld)
----------------

*/

package electrohogar;

import java.util.logging.Level;
import java.util.logging.Logger;

 
public class Nodo  
{
   
    //atributos propios de la clase
    private Object dato;
    private Nodo sig;
    private Nodo ant;
    
//constructor vacio
    public Nodo()
    {} 
    //fin método Nodo

    /*constructor que recibe el dato 
    y crea el nodo con su información
     y coloca las ligas en null*/
    public Nodo(Object d)
    {
        dato=d;
        sig=null;
        
    }//fin método Nodo

    /*este constructor lo vamos a usar para el nodo doble de la lista
    o el arbol, recibe tres parametros*/
    public Nodo(Nodo li,Object d,Nodo ld)
    {
        ant=li;
        dato=d;
        sig=ld;
        
    }//fin método Nodo

    
    
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    //destructor ojo, este metodo finalize se  genera, es el inicio de un constructor
    public void finalize()
    {   try {
        super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
     
    @Override
    public String toString() {
        return dato.toString();
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    
   
}//fin clase nodo


    

