/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_persistencia.IMembresiaDAO;
import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
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
        Membresia membresia = DtosAEntidadesAdapter.adaptarMembresia(membresiaDTO);
        membresiaDAO.guardar(membresia);
    }

    @Override
    public List<Membresia> obtenerTodas() {
        return membresiaDAO.obtenerTodas();
    }

    @Override
    public Membresia obtenerPorId(Long id) {
        return membresiaDAO.obtenerPorId(id);
    }
}
