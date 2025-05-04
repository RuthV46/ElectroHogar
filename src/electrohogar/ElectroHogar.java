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
        //Instaciar clases de manejo
        ManejoPila objMP=new ManejoPila();
        ManejoCola objMC=new ManejoCola();
        
        int opt;
        do{
            opt=Integer.parseInt(JOptionPane.showInputDialog("Menu\n"
                + "1. Manejo de Cola de Refrigerador\n"
                + "2. Manejo de Pila de Lavadora\n"
                + "3. Manejo de otras historias o requisitos de usuario\n"
                + "4. Salir"));
            switch(opt){                
                case 1:
                    int option1;
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
                    int option2;
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
                    
                case 3:
                    break;
            }
        }while(opt<3);
    }
}
