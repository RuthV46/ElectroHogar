package electrohogar;

import javax.swing.JOptionPane;

public class Cola 
{
    //atributos propios y privados
    private int Maxsize;//tamaño maximo del almacenamiento
    private int Size;//contador de nodos para que no se pase de maximo tamaño
    private  Nodo Final,Front,q;//apuntador a la cabeza de la fila y  apuntador a la cola de la fila y q auxiliar
    /*
        Final,Front solo se usaran en esta clase, NO USAR EN OTRA CLASE
    */
     
    //constructores, no hace nada en concreto pero se debe de poner
    public Cola()
    {}
    public Cola(int n)//condiciones iniciales del constructor para crear una cola
    {
        Maxsize=n;
        Final=null;
        Front=null;
        Size=0;
        
    }
    
    /*Los Estados de una cola son:
Cola llena � full tail
Cola con algunos elementos 
Cola vac�a � empty tail
*/
        
    public boolean IsEmpty() 
    {//si esta vacia
        if(Size<= 0)
            return true;
        else
            return false;
    }

    
    public boolean IsFull() 
    {//si esta llena o sea ya se llego al maximo
        if(Size>= Maxsize)
            return true;
        else 
            return false;
    }
    
    //poner un elemento en la cola 
        
    public void Push(Object d)//encolar
    {
        if (IsFull()==false)//se le puede ingresar informacion
        { 
            Size=Size+ 1;
            q=new Nodo(d);
            if(Front==null)//si es el primer dato
               {
                Front=q;
                Final=q ;
                }
             else//si ya hay un dato
                {
                 Final.setSig(q);
                 Final=q;
                }//fin si 
        }//fin si
        else
        {
        //sino pila llena//  
            JOptionPane.showMessageDialog(null,"*****Pila LLena DESBORDAMIENTO DE PILA*****");//OPCIONAL//opcional
        }
    }//fin de push - encolar
    
    
    //sacar un elemento de la cola
    public Object Pop()//desencolar
    {
        Object d=null;
        if (IsEmpty()==false)
        {
            Size= Size- 1;
            if(Front==Final)
            {
                d = Front.getDato();
                Front=null;
                Final=null;
            }
            else
            {
                d =Front.getDato();
                q=Front;
                Front=Front.getSig();
                q.finalize();
                q=(null);
            }
            } 
        else
        {
        //sino pila vacia//  
            JOptionPane.showMessageDialog(null,"*****Pila Vacia SUBDESBORDAMIENTO DE PILA*****");//OPCIONAL
        }
        
        return d;
    }//fin de pop - encolar
  
    //muestra el objeto del Front de la cola sin extraerlo o desencolarlo)
    public Object  Peek()
    {
       Object dato=null; 
       if(IsEmpty()==false)
       {
           dato=Front.getDato();
       }
       return dato;
    }//Fin método peek


}//fin clase cola
