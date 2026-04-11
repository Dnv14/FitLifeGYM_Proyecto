/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

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
    
    
    public void navegarMenuPrincipal(){
        mostrarPantalla(new MainFitLifeFORM(this));
    }
    
    public void navegarRegistrarse(){
        RegistrarseFORM registroForm = new RegistrarseFORM(frameActual, true, this);
        registroForm.setLocationRelativeTo(this.frameActual);
        registroForm.setVisible(true);
    }
}
