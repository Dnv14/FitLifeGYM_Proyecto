/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_persistencia.IClientesDAO;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class RenovarMembresiaBO implements IRenovarMembresiaBO {
    private final IClientesDAO clientesDAO;

    public RenovarMembresiaBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    @Override
    public void renovarMembresia(RenovarMembresiaDTO dto) {
        TipoMembresia tipo = DtosAEntidadesAdapter.adaptarTipoMembresia(dto.getTipoMembresia());
        clientesDAO.actualizarMembresia(dto.getIdCliente(), tipo);
    }
    
}
