/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos;

/**
 *
 * @author Luis
 */
public class LoginDTO {
    private final String pin;

    public LoginDTO(String pin) {
        this.pin = pin;
    }

    public String getPin() { 
        return pin; 
    }
    
}
