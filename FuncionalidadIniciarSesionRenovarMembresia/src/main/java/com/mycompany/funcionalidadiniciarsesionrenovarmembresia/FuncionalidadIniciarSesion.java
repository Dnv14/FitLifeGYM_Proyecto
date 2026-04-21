package com.mycompany.funcionalidadiniciarsesionrenovarmembresia;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_negocio.ILoginBO;
import com.mycompany.fitlifegym_negocio.NegocioException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class FuncionalidadIniciarSesion implements IFuncionalidadIniciarSesion {
    private final ILoginBO loginBO;
     
    public FuncionalidadIniciarSesion(ILoginBO loginBO) {
        this.loginBO = loginBO;
    }

    @Override
    public ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException {
        if (login == null) {
            throw new NegocioException("Los datos de inicio de sesión no pueden ser nulos.");
        }

        if (login.getPin() == null || login.getPin().isBlank()) {
            throw new NegocioException("El PIN no puede estar vacío.");
        }

        if (!login.getPin().matches("\\d{4}")) {
            throw new NegocioException("El PIN debe ser de 4 dígitos numéricos.");
        }

        if (login.getContrasenia() == null || login.getContrasenia().isBlank()) {
            throw new NegocioException("La contraseña no puede estar vacía.");
        }

        return loginBO.iniciarSesion(login);
        
    }
    
}
