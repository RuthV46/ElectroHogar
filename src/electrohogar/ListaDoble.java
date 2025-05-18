package electrohogar;

import javax.swing.JOptionPane;

public class ListaDoble {
   
    //atributos propios y privados
    private Nodo Cabeza;

    //constructor vacio
    public ListaDoble() 
    {
        Cabeza=null;//condiciones iniciales de lista doble
    }

    //nodos auxiliares
    Nodo q,p,Fin;
    
    /*metodo para validar si la lista esta vacia 
    o tiene datos, retorna verdadero si no hay datos*/
    public boolean EstaVacia()
    {
       if(getCabeza()==null)  
            //"LISTA VACIA!!!“   //mensaje opcional
            return true;
        else
             return false;
        //fin si 
    }//fin esta vacia

    /*este metodo ubica el apuntador auxiliar Fin en el ultimo nodo
        de la lista*/
    public Nodo UbicarUltimo() 
    {
        Fin=getCabeza(); 
        while(Fin.getSig()!=null)
        {
           Fin=Fin.getSig();
        }//	fin de mientras
        return  Fin;
    }//fin de ubicarultimo

/*este metodo crea un nodo de la lista en caso de que no exista y coloca
    nuevos datos por el apuntador Fin, quedando de primero el primero
    que ingresa, el apuntador Fin es un auxiliar y por eso NO se encapsula
y siempre se debe estar ubicando*/
   public void CrearNodoPorFinal(Object info)
   {
        q=new Nodo(null,info,null);
        if(EstaVacia()==true)
        {
            setCabeza(q);
            Fin=q; 
        }
        else 
        {
            Fin.setSig(q);
            q.setAnt(Fin);
            Fin=q;
        }//Fin si
    }//fin crearlista por final
 
   
    /*este metodo crea un nodo de la lista en caso de que no exista y coloca
    nuevos datos por el apuntador cabeza, quedando de ultimo el primero
    que ingresa*/

    public void CrearNodoPorInicio(Object info)
    {
        q=new Nodo(null,info,null);//se crea el nodo y  se le mandan los 3 parametros o argumentos
        if(EstaVacia()==true)
            setCabeza(q);
        else
        {
            getCabeza().setAnt(q);
            q.setSig(getCabeza());
            setCabeza(q);
        }//Fin si
    }//fin crearlista por final
    
      /*metodo que retorna una cadena con los datos de la lista desde el primero
    NO imprime*/
    public String ImprimirDesdeCabeza()
    {
        String texto=" \n";
        if (EstaVacia()==false)//si la lista tiene datos
        {
            q=getCabeza(); 
            while (q!=null)  
         {
            texto =texto+"\n"+q.toString(); //q.obtenerDato()
            q=q.getSig(); 
         }//fin mientras
        }//Fin si
        return texto ;
    }//Fin imprimir

    /*metodo que retorna una cadena con los datos de la lista desde el ultimo
    NO imprime*/
    public String ImprimirDesdeFinal()
    {
         String texto=" \n";
         if (EstaVacia()==false)
         {
            UbicarUltimo(); //ubica al nodo fin
            while (Fin!=null)
            {
                 texto =texto+"\n"+Fin.toString();//fin.obtenerDato()
                 Fin=Fin.getAnt(); 
            }//fin mientras
         }//Fin si
        return texto ;
    }//Fin imprimir

/*este metodo inserta un nodo de primero y SIEMPRE parte de 
    la base de tener informacion la lista, o sea NO crea la lista desde 
    cero*/
    public void InsertarComoCabeza(Object info)
    {
        if (EstaVacia()==false)//si hay datos
        {
            getCabeza().setAnt(new Nodo(null,info,getCabeza()));
            setCabeza(getCabeza().getAnt());
        }//Fin si
    }//Fin de insertar como cabeza

/*este metodo inserta un nodo de ultimo y SIEMPRE parte de 
    la base de tener informacion la lista, o sea NO crea la lista desde 
    cero*/
public  void InsertarAlFinal(Object info)
{
    if (EstaVacia()==false)
    {
         Fin=UbicarUltimo();
         Fin.setSig(new Nodo(Fin,info,null));	

    }//Fin si
}//Fin de insertar Final

/*Libera el espacio de memoria y elimina el primer dato de la lista
usa el destructor basico que es finalize*/
    public Object LiberarCabeza()
    {
        Object info=null;
        if (EstaVacia()==false)   ///si hay datos
        {
            q=getCabeza();  //toma la memoria donde esta el primer nodo
            info=q.getDato();
                if(getCabeza().getSig()==null)    //si es lista de un solo nodo
                        setCabeza(null);   //lista quedo vacia
                else
                {
                        setCabeza(getCabeza().getSig());
                        getCabeza().setAnt(null);
                }//fin si
                q.finalize();
        }
        else
                JOptionPane.showMessageDialog(null,"Lista vacia No podemos liberar cabeza");
        //fin si
        return info;
    }//fin liberar cabeza

/*Libera el espacio de memoria y elimina el ultimo dato de la lista
usa el destructor basico que es finalize*/
    public Object LiberarUltimo()
    {
        Object info=null;
        if (EstaVacia()==false)   ///si hay datos
        {
                UbicarUltimo();
                info=Fin.getDato();
                if(getCabeza().getSig()==null)    //si es lista de un solo nodo
                        setCabeza(null);   //lista quedo vacia
                else
                        Fin.getAnt().setSig(null);
                //fin si
                Fin.finalize();
         }
        else
                JOptionPane.showMessageDialog(null,"Lista vacia No podemos liberar el ultimo");
        //fin si
        return info;
    }//fin liberar ultimo
   
    public boolean Buscar(String id)
    {
        p=getCabeza();
        Refrigerador objR;
        objR=(Refrigerador)p.getDato();//se toma el primer dato
        String idp=objR.getnSerie();//se toma la identificacion del primer dato 
        while(p!=null&&!(id.equals(idp))) // Continuamos mientras no lleguemos al final Y no encontremos coincidencia
        {    
            p=p.getSig();  // Avanzamos al siguiente nodo
            if(p!=null)  // Si no hemos llegado al final, obtenemos el nuevo dato
            {
              objR=(Refrigerador)p.getDato();//se toma el dato señalado por p en este momento
              idp=objR.getnSerie();//se toma la identificacion del dato señalado por p para compararlo
            }
        }//fin mientras
        if(p==null) 
               return false;  // Si p es null, llegamos al final sin encontrar
        else
                return true;  // Si p no es null, encontramos una coincidencia
        //fin si          
    }//fin buscar
    
    /*
 * Método que elimina un nodo específico de la lista y libera su memoria
 * - Usa el destructor básico finalize() para liberar memoria
 * - Maneja tres casos posibles: nodo cabeza, nodo final o nodo intermedio
 * - Muestra mensajes de error si la lista está vacía o el dato no existe
 */
    public String LiberarDato(String id) {
        // Primero verifica si la lista NO está vacía
        String texto="";
        if (EstaVacia()==false) {
            // Busca el nodo con el id especificado
            if(Buscar(id)==false) {
                // Si no encuentra el dato, muestra un mensaje de error al usuario
                texto="Dato no se encuentra en la lista";
            }
            else {
                // CASO 1: El nodo a eliminar es el primero de la lista (cabeza)
                if(p.getAnt()==null) {  // Equivalente a if(p==obtenerCabeza())
                    LiberarCabeza();  // Llama al método especial para eliminar la cabeza
                }
                else {
                    // CASO 2: El nodo a eliminar es el último de la lista
                    if(p.getSig()==null) {
                        LiberarUltimo();  // Llama al método especial para eliminar el último
                    }
                    else {
                        // CASO 3: El nodo a eliminar está en medio de la lista
                        // Reconecta los nodos adyacentes:
                        // - El siguiente del nodo anterior ahora apunta al siguiente del nodo actual
                        p.getAnt().setSig(p.getSig());
                        // - El anterior del nodo siguiente ahora apunta al anterior del nodo actual
                        p.getSig().setAnt(p.getAnt());
                        // Libera la memoria del nodo eliminado usando el destructor
                        p.finalize();  // liberar(p);
                    }// Fin del caso intermedio
                }// fin si
                texto="Dato se eliminó en la lista "+id;
            }// Fin si(dato encontrado)
        }// Fin si (lista no vacía)
        return texto;
    }// Fin del método LiberarDato


    // Declaración del método que inserta un nuevo nodo después de un nodo específico
    // Recibe:
    // - idBuscar: el identificador del nodo después del cual se insertará
    // - datoIns: el objeto dato que se almacenará en el nuevo nodo
    public void InsertarDespues(String idBuscar, Object datoIns) {

        // Verifica si existe un nodo con el idBuscar en la lista
        // El método Buscar() devuelve true si encuentra el nodo y lo asigna a la variable p
        if(Buscar(idBuscar)==true) {    

            // Si el nodo encontrado (p) es el último de la lista (su siguiente es null)
            if(p.getSig()==null) {
                // Inserta el nuevo dato al final de la lista
                InsertarAlFinal(datoIns);
            }
            else {
                // Si no es el último nodo:
                // 1. Crea un nuevo nodo entre p y p.getSig()
                //    - Su nodo anterior será p
                //    - Contendrá datoIns
                //    - Su nodo siguiente será p.getSig() (el que originalmente seguía a p)
                p.setSig(new Nodo(p, datoIns, p.getSig()));

                // Actualiza el puntero 'ant' del nodo que ahora sigue al nuevo nodo
                // para que apunte al nuevo nodo creado
                p.getSig().getSig().setAnt(p.getSig());
            }//fin si
        }// Fin del if (Buscar)
    }// Fin del método InsertarDespues



    // Declaración del método que inserta un nuevo nodo antes de un nodo específico
    // Recibe:
    // - idBuscar: el identificador del nodo antes del cual se insertará
    // - datoIns: el objeto dato que se almacenará en el nuevo nodo
    public void InsertarAntes(String idBuscar, Object datoIns) {

        // Verifica si existe un nodo con el idBuscar en la lista
        // El método Buscar() devuelve true si encuentra el nodo y lo asigna a la variable p
        if(Buscar(idBuscar)==true) {    

            // Si el nodo encontrado (p) es el primero de la lista (su anterior es null)
            // El comentario sugiere que también se podría verificar con if(p==getCabeza())
            if(p.getAnt()==null) {
                // Inserta el nuevo dato como cabeza de la lista
                InsertarComoCabeza(datoIns);
            }
            else {
                // Si no es el primer nodo:
                // 1. Crea un nuevo nodo entre p.getAnt() y p
                //    - Su nodo anterior será p.getAnt()
                //    - Contendrá datoIns
                //    - Su nodo siguiente será p
                p.setAnt(new Nodo(p.getAnt(), datoIns, p));

                // Actualiza el puntero 'sig' del nodo que ahora precede al nuevo nodo
                // para que apunte al nuevo nodo creado
                p.getAnt().getAnt().setSig(p.getAnt());
            }// Fin del si
        }// Fin del if (Buscar)
    }// Fin del método InsertarAntes    
     
    public Nodo getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.Cabeza = cabeza;
    } 
 
}
