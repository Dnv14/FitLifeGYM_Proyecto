/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaCompradaDTO;
import com.mycompany.fitlifegym_persistencia.IMembresiaCompradaDAO;
import com.mycompany.fitlifegym_persistencia.entidades.MembresiaComprada;
import java.util.List;

/**
 *
 * @author Diego
 */
public class MembresiaCompradaBO implements IMembresiaCompradaBO {


    private IMembresiaCompradaDAO membresiaComprada;

    private IMembresiaCompradaDAO membresiaCompradaDAO;

    public MembresiaCompradaBO(IMembresiaCompradaDAO membresiaCompradaDAO) {
        this.membresiaCompradaDAO = membresiaCompradaDAO;
    }

    @Override
    public MembresiaComprada guardar(NuevaMembresiaCompradaDTO membresiaCompradaDTO) {
        if(membresiaCompradaDTO.getMembresia() == null){
            throw new IllegalArgumentException("La membresia no puede ser nula.");
        }
        
        if(membresiaCompradaDTO.getFechaInicio() == null){
            throw new IllegalArgumentException("La fecha de incio no puede ser nula.");
        }
        
        if(membresiaCompradaDTO.getFechaFin() == null){
            throw new IllegalArgumentException("La fecha final no puede ser nula.");
        }
        
        if(membresiaCompradaDTO.getFechaFin().isBefore(membresiaCompradaDTO.getFechaInicio())){
            throw new IllegalArgumentException("La fecha fianl no puede ser anterior a la fecha de inicio.");
        }
        
        if(membresiaCompradaDTO.getPrecioPagado() == null || membresiaCompradaDTO.getPrecioPagado()<= 0){
            throw new IllegalArgumentException("El precio que se va a pagar debe ser mayor a 0.");
        }
        
        if(membresiaCompradaDTO.getEstado() == null){
            throw new IllegalArgumentException("El estado de la membresía no puede ser nula.");
        }
        MembresiaComprada mebresiaComprada = DtosAEntidadesAdapter.adaptarMembresiaCompradaDTO(membresiaCompradaDTO);

        return membresiaComprada.guardar(mebresiaComprada);
    }

    @Override
    public List<MembresiaComprada> obtenerTodas() {

        return membresiaComprada.obtenerTodas();

    }
}
