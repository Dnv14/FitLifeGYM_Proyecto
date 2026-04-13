
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.presentacion;


import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.TipoMembresia;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.negocio.ObjetosBO;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Julian
 */
public class ControlForms {
    private JFrame frameActual;
    private ObjetosBO objetosBO;

    public ControlForms() {
        objetosBO = new ObjetosBO();
    }
    
    private void mostrarPantalla(JFrame nuevoFrame){
        if(this.frameActual != null){
            this.frameActual.dispose();
        }
        
        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        frameActual.setLocationRelativeTo(null);
        frameActual.setVisible(true);
    }
    
    
    private void mostrarDialogo(JDialog nuevoDialogo) {
        nuevoDialogo.setResizable(false);
        nuevoDialogo.setLocationRelativeTo(this.frameActual);
        nuevoDialogo.setVisible(true);
    }
    
    //frames
    public void navegarMenuPrincipal(){
        mostrarPantalla(new MainFitLifeFORM(this));
    }
    
    public void navegarBenificios(){
        mostrarPantalla(new BeneficiosFORM(this));
    }
    
    public void navegarBienvenida(){
        mostrarPantalla(new BienvenidaFORM(this));
    }
    
    public void navegarMetodosPago(){
        mostrarPantalla(new SuscribirseFORM(this));
    }
    
    //Dialogs
    public void navegarRegistrarse(){
        mostrarDialogo(new RegistrarseFORM(this.frameActual, true, this));
    }
    
    
    public void navegarTransferenciaMetodo(){
        mostrarDialogo(new TransferenciaFORM(this.frameActual,true));
    }
    
    public void navegarTarjetaMetodo(){
        mostrarDialogo(new TarjetaFORM(this.frameActual, true,this));
    }
    
    
    //logica de botones }

    public void registrarCliente(NuevoClienteDTO cliente){
        objetosBO.getClientesBO().registrarCliente(cliente);
    }
    
    
    //utileria
    public void buscarClientePorId(Long id){
        objetosBO.getClientesBO().buscarClientePorId(id);
    }
    
    public List<Cliente> consultarClientes(){
        return objetosBO.getClientesBO().consultarClientes();
    }
    
    public void seleccinarMembresia(String tipo){
        double precio;
        TipoMembresia tipoMembresia;
        
        switch(tipo){
            case "Oro":
                tipoMembresia = TipoMembresia.ORO;
                precio = 750.0;
                break;
            case "Plata":
                tipoMembresia = TipoMembresia.PLATA;
                precio = 500.0;
                break;
            default:
                tipoMembresia = TipoMembresia.BRONCE;
                precio = 300.0;        
        }        
    }
}
