/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia;

import com.mycompany.fitlifegym_negocio.IMembresiaBO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class FuncionalidadConsultarMembresias implements IFuncionalidadConsultarMembresias {
    private final IMembresiaBO membresiaBO;

    public FuncionalidadConsultarMembresias(IMembresiaBO membresiaBO) {
        this.membresiaBO = membresiaBO;
    }

    @Override
    public List<Membresia> consultarMembresias() throws NegocioException {
        List<Membresia> membresias = membresiaBO.obtenerTodas();

        if (membresias == null || membresias.isEmpty()) {
            throw new NegocioException("No hay tipos de membresía disponibles.");
        }

        return membresias;
    }
    
}
