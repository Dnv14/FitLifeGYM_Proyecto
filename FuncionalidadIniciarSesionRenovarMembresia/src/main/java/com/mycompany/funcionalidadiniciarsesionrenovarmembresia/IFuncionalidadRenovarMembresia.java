/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia;

import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_negocio.NegocioException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IFuncionalidadRenovarMembresia {
     public abstract void renovarMembresia(RenovarMembresiaDTO dto) throws NegocioException;
}
