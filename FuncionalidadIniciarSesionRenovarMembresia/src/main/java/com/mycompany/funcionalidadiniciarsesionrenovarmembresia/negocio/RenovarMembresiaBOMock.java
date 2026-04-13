/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.negocio;

import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos.RenovarMembresiaDTO;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.persistencia.IClientesDAO;

/**
 *
 * @author Luis
 */
public class RenovarMembresiaBOMock implements IRenovarMembresiaBO {
    
    private final IClientesDAO clientesDAO;

    public RenovarMembresiaBOMock(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    @Override
    public void renovarMembresia(RenovarMembresiaDTO dto) {
        clientesDAO.actualizarMembresia(dto.getIdCliente(), dto.getTipoMembresia());
    }
    
}
