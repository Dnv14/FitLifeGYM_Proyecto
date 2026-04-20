/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaCompradaDTO;
import com.mycompany.fitlifegym_persistencia.IMembresiaCompradaDAO;
import com.mycompany.fitlifegym_persistencia.entidades.MembresiaComprada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class MembresiaCompradaBO implements IMembresiaCompradaBO {

    private IMembresiaCompradaDAO membresiaComprada;
    private final List<MembresiaComprada> compras = new ArrayList<>();
    private Long contadorID = 1L;

    public MembresiaCompradaBO(IMembresiaCompradaDAO membresiaComprada) {
        this.membresiaComprada = membresiaComprada;
    }

    @Override
    public MembresiaComprada guardar(NuevaMembresiaCompradaDTO membresiaCompradaDTO) {
        MembresiaComprada mebresiaComprada = DtosAEntidadesAdapter.adaptarMembresiaCompradaDTO(membresiaCompradaDTO);
        mebresiaComprada.setIdMembresiaComprada(contadorID++);
        compras.add(mebresiaComprada);
        return mebresiaComprada;
    }

    @Override
    public List<MembresiaComprada> obtenerTodas() {
        return new ArrayList<>(compras);
    }
}
