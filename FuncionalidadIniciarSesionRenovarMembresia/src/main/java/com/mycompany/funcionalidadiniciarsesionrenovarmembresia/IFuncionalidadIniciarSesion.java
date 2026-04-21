/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_negocio.NegocioException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IFuncionalidadIniciarSesion {
    public abstract ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException;
}
