/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.IFuncionalidadRegistrarUsuario;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Diego
 */
public class ControlForms {

    private JFrame frameActual;
    private NuevoClienteDTO cliente;
    private IFuncionalidadRegistrarUsuario funcionalidadCU;

    

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

    //frames
    public void navegarMenuPrincipal() {
        mostrarPantalla(new MainFitLifeFORM(this));
    }

    public void navegarBenificios() {
        mostrarPantalla(new BeneficiosFORM(this));
    }

    public void navegarBienvenida() {
        mostrarPantalla(new BienvenidaFORM(this));
    }

    public void navegarMetodosPago() {
        mostrarPantalla(new SuscribirseFORM(this));
    }

    //Dialogs
    public void navegarRegistrarse() {
        mostrarDialogo(new RegistrarseFORM(this.frameActual, true, this));
    }

    public void navegarIniciarSesion() {
        mostrarDialogo(new IniciarSesionFORM(this.frameActual, true, this));
    }

    public void navegarTransferenciaMetodo() {
        mostrarDialogo(new TransferenciaFORM(this.frameActual, true));
    }

    public void navegarTarjetaMetodo() {
        mostrarDialogo(new TarjetaFORM(this.frameActual, true));
    }

    public void navegarIniciarSesionPaypal() {
        mostrarDialogo(new IniciarSesionPaypalFORM(this.frameActual, true));
    }

}
