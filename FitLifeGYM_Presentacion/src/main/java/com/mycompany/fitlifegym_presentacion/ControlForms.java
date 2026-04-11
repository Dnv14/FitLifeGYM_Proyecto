/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Diego
 */
public class ControlForms {
    private JFrame frameActual;
    
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
    
    //Dialogs
    public void navegarRegistrarse(){
        mostrarDialogo(new RegistrarseFORM(this.frameActual, true, this));
    }
    
    public void navegarIniciarSesion(){
        mostrarDialogo(new IniciarSesionFORM(this.frameActual, true, this));
    }
    
    
}
