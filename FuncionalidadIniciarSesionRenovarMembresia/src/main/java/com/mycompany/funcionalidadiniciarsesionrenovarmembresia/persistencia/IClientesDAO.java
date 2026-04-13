/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.persistencia;

import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio.Cliente;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio.TipoMembresia;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface IClientesDAO {
    public abstract Cliente buscarPorPin(String pin);
    
    public abstract Cliente buscarPorId(Long id);
    
    public abstract void actualizarMembresia(Long idCliente, TipoMembresia nuevaMembresia);
    
    public abstract List<Cliente> obtenerTodos();
    
}
