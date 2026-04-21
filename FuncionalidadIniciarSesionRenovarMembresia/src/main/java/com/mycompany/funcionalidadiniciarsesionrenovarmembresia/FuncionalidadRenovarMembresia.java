/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia;

import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_negocio.IRenovarMembresiaBO;
import com.mycompany.fitlifegym_negocio.NegocioException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class FuncionalidadRenovarMembresia implements IFuncionalidadRenovarMembresia {
    private final IRenovarMembresiaBO renovarMembresiaBO;

    public FuncionalidadRenovarMembresia(IRenovarMembresiaBO renovarMembresiaBO) {
        this.renovarMembresiaBO = renovarMembresiaBO;
    }

    @Override
    public void renovarMembresia(RenovarMembresiaDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("Los datos de la renovación no pueden ser nulos.");
        }

        if (dto.getIdCliente() == null) {
            throw new NegocioException("El ID del cliente no puede ser nulo.");
        }

        if (dto.getIdCliente() <= 0) {
            throw new NegocioException("El ID del cliente debe ser mayor a 0.");
        }

        if (dto.getTipoMembresia() == null) {
            throw new NegocioException("Se debe de elegir un tipo de membresía.");
        }

        renovarMembresiaBO.renovarMembresia(dto);
    }
    
}
