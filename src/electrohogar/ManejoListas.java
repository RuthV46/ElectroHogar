package electrohogar;

import javax.swing.JOptionPane;

public class ManejoListas {
    
    public ListaDoble ingresarDatos(ListaDoble objLD, int op){
        
        int resp;
        Refrigerador objR;
        resp=JOptionPane.showConfirmDialog(null, "Ingresar datos en la lista", "INGRESO", JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_OPTION){
            
            objR=new Refrigerador();
            objR=objR.ingresarDatos();
            if(op==1){
                objLD.CrearNodoPorInicio(objR);
            }
            else if(op==2){
                objLD.CrearNodoPorFinal(objR);
            }
            resp=JOptionPane.showConfirmDialog(null, "Ingresar mas datos en la lista", "INGRESO", JOptionPane.YES_NO_OPTION);  
            
        }//fin mientras
        return objLD;
    } //fin ingresarDatos   
}
