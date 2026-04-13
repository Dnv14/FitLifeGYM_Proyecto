/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.negocio;

import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos.ClienteLogueadoDTO;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos.LoginDTO;

/**
 *
 * @author Luis
 */
public interface ILoginBO {
    
    public abstract ClienteLogueadoDTO iniciarSesion(LoginDTO login);
    
}
