/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos;

import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio.TipoMembresia;

/**
 *
 * @author Luis
 */
public class RenovarMembresiaDTO {
    private final Long idCliente;
    private final TipoMembresia tipoMembresia;

    public RenovarMembresiaDTO(Long idCliente, TipoMembresia tipoMembresia) {
        this.idCliente = idCliente;
        this.tipoMembresia = tipoMembresia;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }
    
    
}
