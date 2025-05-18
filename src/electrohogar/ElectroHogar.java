package electrohogar;

import javax.swing.JOptionPane;

public class ElectroHogar {
    public static void main(String[] args) {
        //Instaciar las clases para usar
        Refrigerador ObjR=new Refrigerador();
        Lavadora ObjL=new Lavadora();
        ElectroHogar ObjE=new ElectroHogar();
        
        //Instaciar pila y pila auxiliar
        Pila objP=new Pila(10000);
        Pila objPA=new Pila(1000);
        //Instaciar cola y cola auxiliar
        Cola objC=new Cola(10000);
        Cola objCA=new Cola(10000);
        //Lista doble de refrigerador
        ListaDoble objLD=new ListaDoble();
        //Instaciar clases de manejo
        ManejoPila objMP=new ManejoPila();
        ManejoCola objMC=new ManejoCola();
        ManejoListas objML=new ManejoListas();
        
        String serie = null, texto=null;
        
        int opt;//opcion de menus
        do{
            opt=Integer.parseInt(JOptionPane.showInputDialog("Menu\n"
                + "1. Manejo de Cola de Refrigerador\n"
                + "2. Manejo de Pila de Lavadora\n"
                + "3. Manejo de Lista Doble de Refrigerador\n"
                + "4. Manejo de otras historias o requisitos de usuario\n"
                + "5. Salir"));
            switch(opt){                
                case 1:
                    int option1;//opcion cola
                    do{//repetir el menu mientras sea solicitado
                        option1=Integer.parseInt(JOptionPane.showInputDialog("Menu\n"
                        +"1. Ingresar Datos Refrigerador cola\n"
                        + "2. Mostrar cola de refrigeradores\n"
                        + "3. Mostrar promedio de precios de Refrigeradors\n"
                        + "4. Mostrar refrigeradores de tipo GAS\n"
                        + "5. SALIR"));

                        switch (option1){
                            case 1:
                                int resp=JOptionPane.showConfirmDialog(null, "Desea usar los datos asignados por defecto", "Encolando", JOptionPane.YES_NO_OPTION);
                                if(resp==JOptionPane.YES_OPTION)
                                    objC=objMC.PruebaEscritorio(objC);
                                else
                                    objC=objMC.ingresarDatos(objC);
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "La cola de refrigeradores es:\n"+objMC.juntarDatos(objC, objCA));
                                break;
                            case 3:
                                if(objC.IsEmpty()==false)//validar que la cola tenga datos
                                {
                                   JOptionPane.showMessageDialog(null, "El promedio de precios de los refrigeradores es: $ "+objMC.promediaPrecio(objC, objCA)); 
                                }
                                break;
                            case 4: 
                                if(objC.IsEmpty()==false)//validar que la cola tenga datos
                                {
                                   JOptionPane.showMessageDialog(null, "La cantidad de refrigeradores tipo GAS son: "+objMC.contarTipo(objC, objCA)+"\n"+
                                   objMC.mostrarRefriPorTipo(objC, objCA));
                                }
                                break;
                        }
                    }while(option1<5);
                break;
                
                case 2:
                    int option2;//opcion pila
                    do{//repetir el menu mientras sea solicitado
                        option2=Integer.parseInt(JOptionPane.showInputDialog("Menu\n"
                        +"1. Ingresar Datos Lavadora cola\n"
                        + "2. Mostrar pila de lavadoras\n"
                        + "3. Mostrar promedio de precios de Lavadoras\n"
                        + "4. SALIR"));

                        switch (option2){
                            case 1:
                                int resp=JOptionPane.showConfirmDialog(null, "Desea usar los datos asignados por defecto", "Encolando", JOptionPane.YES_NO_OPTION);
                                if(resp==JOptionPane.YES_OPTION)
                                    objP=objMP.PruebaEscritorio(objP);
                                else
                                    objP=objMP.ingresarDatos(objP);
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "La Pila de neveras es:"+objMP.juntarDatos(objP, objPA));
                                break;
                            case 3:
                                if(objP.IsEmpty()==false)//validar que la pila tenga datos
                                {
                                   JOptionPane.showMessageDialog(null, "El promedio de precios de los refrigeradores es: $ "+objMP.promediaPrecio(objP, objPA)); 
                                }
                                break;
                        }
                    }while(option2<4);
                break;
                    
                case 3:
                    int option3;//opcion lista
                    do{//repetir el menu mientras sea solicitado
                        option3=Validaciones.leerEntero("Menu\n"
                        + "1. Ingresar Datos de lista de Refrigeradores\n"
                        + "2. Mostrar lista de refrigeradores por inicio\n"
                        + "3. Mostrar lista de refrigeradores por final\n"
                        + "4. Liberar el dato de inicio\n"
                        + "5. Liberar el dato de final\n"
                        + "6. Liberar el dato especifico por id\n"
                        + "7. Insertar dato al inicio\n"
                        + "8. Insertar dato al final\n"
                        + "9. Insertar dato nuevo antes de un dato referencia\n"
                        + "10. Insertar dato nuevo despues de un dato referencia\n"
                        + "15. Regresar al menu principal");

                        switch (option3){
                            case 1: //de que forma desea ingresar los datos
                                objLD = new ListaDoble();
                                int resp=Validaciones.leerEntero( "Ingresar los datos\n"
                                        + "1. Por inicio\n"
                                        + "2. Por final\n");
                                objLD=objML.ingresarDatos(objLD, resp);                                
                                break;
                                
                            case 2:
                                if(objLD.EstaVacia()==false)
                                    JOptionPane.showMessageDialog(null, "La Lista de refrigeradores desde inicio es: "+objLD.ImprimirDesdeCabeza());
                                else 
                                    JOptionPane.showMessageDialog(null, "La Lista de refrigeradores esta vacia");
                                break;
                                
                            case 3:
                                 if(objLD.EstaVacia()==false)
                                    JOptionPane.showMessageDialog(null, "La Lista de refrigeradores desde final es: "+objLD.ImprimirDesdeFinal());
                                else 
                                    JOptionPane.showMessageDialog(null, "La Lista de refrigeradores esta vacia");
                                break;
                                
                            case 4:
                                if(objLD.EstaVacia()==false)//hay datos
                                    JOptionPane.showMessageDialog(null,"Se eliminó el primer dato: \n"+objLD.LiberarCabeza());
                                else
                                    JOptionPane.showMessageDialog(null,"La lista de ponentes esta vacia");
                                break;
                                
                            case 5:
                                if(objLD.EstaVacia()==false)//hay datos
                                    JOptionPane.showMessageDialog(null,"Se eliminó el ultimo dato: \n"+objLD.LiberarUltimo());
                                else
                                    JOptionPane.showMessageDialog(null,"La lista de ponentes esta vacia");
                                break;
                                
                            case 6:
                               if(objLD.EstaVacia()==false){
                                   serie=Validaciones.leerString("Numero de serie del refrigerador a eliminar");
                                   texto=objLD.LiberarDato(serie);
                                   if(!texto.equals(""))
                                       JOptionPane.showMessageDialog(null, texto);                                  
                               }else
                                   JOptionPane.showMessageDialog(null, "La lista de ponentes esta vacia");
                               break;              
                               
                            case 7:
                                if(objLD.EstaVacia()==false){
                                    ObjR=ObjR.ingresarDatos();
                                    objLD.InsertarComoCabeza(ObjR);
                                    JOptionPane.showMessageDialog(null, "Se insertó "+ObjR.getnSerie()+ " de primero en la lista de refrigeradores");
                                }else
                                    JOptionPane.showMessageDialog(null, "La lista de refrigeradores esta vacia");
                                break;
                                
                            case 8:
                                if(objLD.EstaVacia()==false){
                                    ObjR=ObjR.ingresarDatos();
                                    objLD.InsertarAlFinal(ObjR);
                                    JOptionPane.showMessageDialog(null, "Se insertó "+ObjR.getnSerie()+ " de ultimo en la lista de refrigeradores");
                                }else
                                    JOptionPane.showMessageDialog(null, "La lista de refrigeradores esta vacia");
                                break; 
                                
                            case 9:
                                if(objLD.EstaVacia()==false){
                                    serie=Validaciones.leerString("Ingrese el numero de serie del refrigerador para insertar antes de esta serie: ");
                                    if(objLD.Buscar(serie)==true){
                                        
                                        ObjR=ObjR.ingresarDatos();
                                        objLD.InsertarAntes(serie, ObjR);
                                        JOptionPane.showMessageDialog(null,"Se insertó "+ObjR.getnSerie()+" antes del refrigerador con serie: "+serie);
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null, "Numero de serie NO se encuentra en la lista, NO se inserta");
                                } else
                                    JOptionPane.showMessageDialog(null, "La lista de refrigeradores esta vacia");
                                break;
                                
                            case 10:
                                if(objLD.EstaVacia()==false){
                                    serie=Validaciones.leerString("Ingrese serie de refrigerador y asi insertar nuevo refrigerador despues de esta serie");
                                    if(objLD.Buscar(serie)==true){
                                        
                                        ObjR=ObjR.ingresarDatos();
                                        objLD.InsertarDespues(serie, ObjR);
                                        JOptionPane.showMessageDialog(null,"Se inserto "+ObjR.getnSerie()+" despues del numero de serie: "+ serie);
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null, "Numero de serie NO se encuentra en la lista, NO se inserta");
                                } else
                                    JOptionPane.showMessageDialog(null, "La lista de refrigeradores esta vacia");
                                break;

                        }//fin caso 3
                    }while(option3<15);
                    break;
                    
                
                case 4:
                    break;
                    
                case 5:
                    break;
            }
        }while(opt<4);
    }
}
