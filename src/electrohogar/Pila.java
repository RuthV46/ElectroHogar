package electrohogar;

import javax.swing.JOptionPane;

public class Pila 
{
    //atributos propios y privados
    private int Maxsize;//tamaño maximo del almacenamiento
    private int Size;//contador de nodos para que no se pase de maximo tamaño
    private Nodo Top,q;//apuntador al tope y auxiliar q
    
    //constructores
    public Pila()
    {}
    public Pila(int n)//condiciones iniciales del constructor
    {
        Maxsize=n;
        Top=null;
        Size=0;
    }
         
    
    //METODO QUE RETORNA VERDADERO SI NO HAY PILA O ESTA VACIA O RETORNA FALSO SI YA SE CREO LA PILA Y EXISTE ALGUN DATO
    public boolean IsEmpty() 
    {//si esta vacia
        if(Size <= 0)
            return true;
        else
            return false;
    }

    //METODO QUE RETORNA VERDADERO SI NO HAY ESPACIO EN LA PILA PARA MAS DATOS Y RETORNA FALSO SI EXISTE ESPACIO PARA ALGUN DATO
    public boolean IsFull() 
    {//si esta llena o sea ya se llego al maximo
        if(Size >= Maxsize)
            return true;
        else 
            return false;
    }
    
   //  JOptionPane.showMessageDialog(null,"*****Pila LLena DESBORDAMIENTO DE PILA*****");//OPCIONAL
          
    
    // poner un elemento en la pila 
    public void Push(Object d)//apilar
    {
        if(IsFull()==false)//se van a colocar datos...problema?si esta llena
        {
            Size=Size + 1;
            q=new Nodo(d);
            q.setSig(Top);
            Top=q;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"*****Pila Llena DESBORDAMIENTO DE PILA*****");
              //(OPCIONAL);opcional avisarle al usuario pila LLENA
        }
        //opcional avisarle al usuario "pila LLENA..Desbordamiento de pila"
    }//fin de push - apilar
    
    
    //sacar un elemento de la pila
    public Object Pop()
    {
        Object d=null;
        if(IsEmpty()==false)//se van a quitar  datos...problema?si esta vacia
        {
            if (Top.getSig() == null) 
            {
                d = Top.getDato();
                Top=null;
            } else {
                d =Top.getDato();
                q=Top;
                Top=Top.getSig();
                q.finalize();
                q=(null);
            }
            Size=Size- 1;
        }    
        else
        {
            JOptionPane.showMessageDialog(null,"*****Pila Vacia SUBDESBORDAMIENTO DE PILA*****");
              //OPCIONAL);opcional avisarle al usuario pila VACIA
        }
        return d;
        
    }//fin  de pop - desapilar

    //muestra el objeto del tope de la pila sin extraerlo o desapilarlo
    public Object  Peek()
    {
       Object dato=null; 
       if(IsEmpty()==false)
       {
           dato=Top.getDato();
       }
      return dato;	
    }//Fin método pop


}//fin clase pila
