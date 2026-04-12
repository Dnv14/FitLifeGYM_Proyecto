
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.TipoMembresia;
import java.time.LocalDate;

/**
 *
 * @author Julian
 */
public class MembresiaDTO {
    private  Long idMembresia;
    private final TipoMembresia tipoMembresia;
    private final Double precio;
    private final LocalDate vigencia;   
    
    public MembresiaDTO(Long idMembresia, TipoMembresia tipoMembresia, Double precio, LocalDate vigencia) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.vigencia = vigencia;
        this.idMembresia = idMembresia;
    }
    
    public MembresiaDTO(TipoMembresia tipoMembresia, Double precio, LocalDate vigencia) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.vigencia = vigencia;
    }
    public Long getIdMembresia() {
        return idMembresia;
    }
    
    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public Double getPrecio() {
        return precio;
    }

    public LocalDate getVigencia() {
        return vigencia;
    }
    
}
