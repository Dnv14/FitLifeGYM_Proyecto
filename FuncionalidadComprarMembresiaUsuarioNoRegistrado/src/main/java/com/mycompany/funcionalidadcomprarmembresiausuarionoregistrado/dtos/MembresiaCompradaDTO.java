
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Estado;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Membresia;
import java.time.LocalDate;

/**
 *
 * @author Julian
 */
public class MembresiaCompradaDTO {
    private Long idMembresiaComprada;
    final private Membresia membresia;
    final private LocalDate fechaInicio;
    final private LocalDate fechaFin;
    final private Double precioPagado;
    final private Estado estado;

    public MembresiaCompradaDTO(Long idMembresiaComprada, Membresia membresia, LocalDate fechaInicio, LocalDate fechaFin, Double precioPagado, Estado estado) {
        this.idMembresiaComprada = idMembresiaComprada;
        this.membresia = membresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPagado = precioPagado;
        this.estado = estado;
    }

    public MembresiaCompradaDTO(Membresia membresia, LocalDate fechaInicio, LocalDate fechaFin, Double precioPagado, Estado estado) {
        this.membresia = membresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPagado = precioPagado;
        this.estado = estado;
    }

    public Long getIdMembresiaComprada() {
        return idMembresiaComprada;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Double getPrecioPagado() {
        return precioPagado;
    }

    public Estado getEstado() {
        return estado;
    }
    
}
