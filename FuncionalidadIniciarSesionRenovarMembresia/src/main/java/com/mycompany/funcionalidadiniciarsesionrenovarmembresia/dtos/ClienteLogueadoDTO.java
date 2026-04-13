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
public class ClienteLogueadoDTO {
    
    private final Long idCliente;
    
    private final String nombreCompleto;
    
    private final TipoMembresia membresiaActiva;

    public ClienteLogueadoDTO(Long idCliente, String nombreCompleto, TipoMembresia membresiaActiva) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.membresiaActiva = membresiaActiva;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public TipoMembresia getMembresiaActiva() {
        return membresiaActiva;
    }
    
    
    
}
