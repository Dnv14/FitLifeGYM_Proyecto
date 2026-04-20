/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_persistencia.IMembresiaDAO;
import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class MembresiaBO implements IMembresiaBO {

    private IMembresiaDAO membresiaDAO;
   

    public MembresiaBO(IMembresiaDAO membresiaDAO) {
        this.membresiaDAO = membresiaDAO;
    }

    @Override
    public void guardar(NuevaMembresiaDTO membresiaDTO) {
        
        if(membresiaDTO.getTipoMembresia() == null){
            throw new IllegalArgumentException("El tipo de membresia no puede ser nulo.");
        }
        
        if(membresiaDTO.getPrecio() == null || membresiaDTO.getPrecio() <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        
        if(membresiaDTO.getVigencia() == null){
            throw new IllegalArgumentException("La vigencia no puede ser nula.");
        }
        
        if(membresiaDTO.getVigencia().isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La vigencia no puede ser una fecha pasada.");
        }
        Membresia membresia = DtosAEntidadesAdapter.adaptarMembresia(membresiaDTO);
        membresiaDAO.guardar(membresia);

        
    }

    @Override
    public List<Membresia> obtenerTodas() {
        return membresiaDAO.obtenerTodas();
    }

    @Override
    public Membresia obtenerPorId(Long id) {

        if(id == null){
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }

        return membresiaDAO.obtenerPorId(id);
    }
}
