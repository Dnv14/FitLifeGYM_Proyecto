/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IMembresiaBO {

    public abstract void guardar(NuevaMembresiaDTO membresia);

    public abstract List<Membresia> obtenerTodas();

    public abstract Membresia obtenerPorId(Long id);
}
