/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.presentacion;

import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio.Membresia;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio.TipoMembresia;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos.ClienteLogueadoDTO;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos.LoginDTO;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos.RenovarMembresiaDTO;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.negocio.ObjetosBO;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ControlForms {
    private JFrame frameActual;
    private final ObjetosBO objetosBO;
    private ClienteLogueadoDTO clienteActual;
    private Membresia membresia;

    public ControlForms() {
        this.objetosBO = new ObjetosBO();
    }

    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
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

    public void navegarMenuPrincipal() {
        this.clienteActual = null;
        mostrarPantalla(new MainFitLifeFORM(this));
    }

    public void navegarIniciarSesion() {
        mostrarDialogo(new IniciarSesionFORM(this.frameActual, true, this));
    }

    public void navegarBienvenida() {
        mostrarPantalla(new BienvenidaFORM(this));
    }

    public void navegarBeneficios() {
        mostrarPantalla(new BeneficiosFORM(this));
    }
    
    public void navegarMetodosPago() {
        mostrarPantalla(new SuscribirseFORM(this));
    }
    
    public void navegarRegistrarse(){
        mostrarDialogo(new RegistrarseFORM(this.frameActual, true, this));
    }

    public void navegarTarjetaMetodo() {
        mostrarDialogo(new TarjetaFORM(this.frameActual, true, this));
    }

    public void navegarTransferenciaMetodo() {
        mostrarDialogo(new TransferenciaFORM(frameActual, true));
    }

    public void navegarIniciarSesionPaypal() {
        mostrarDialogo(new IniciarSesionPaypalFORM(frameActual, true));
    }

    public ClienteLogueadoDTO iniciarSesion(String pin) {
        LoginDTO loginDTO = new LoginDTO(pin);
        this.clienteActual = objetosBO.getLoginBO().iniciarSesion(loginDTO);
        return this.clienteActual;
    }

    public void renovarMembresia(String tipoMembresia) {
        TipoMembresia tipo;
        switch (tipoMembresia) {
            case "Oro":
                tipo = TipoMembresia.ORO;
                break;
            case "Plata":
                tipo = TipoMembresia.PLATA;
                break;
            default:
                tipo = TipoMembresia.BRONCE;
                break;
        }
        RenovarMembresiaDTO dto = new RenovarMembresiaDTO(clienteActual.getIdCliente(), tipo);
        objetosBO.getRenovarMembresiaBO().renovarMembresia(dto);
    }

    public ClienteLogueadoDTO getClienteActual() {
        return clienteActual;
    }

    public JFrame getFrameActual() {
        return frameActual;
    }
    
    public Membresia getMembresiaSeleccionada(){
        return membresia;
    }
    
}
    
