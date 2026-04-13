/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.persistencia;

import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio.Cliente;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio.TipoMembresia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class ClientesDAOMock implements IClientesDAO{
    
    private static List<Cliente> clientes = new ArrayList<>();
    
    static {
        clientes.add(new Cliente(1L, "Jorge", "Gonzalez", "jorge@gmail.com",
                "6441234567", "1234", TipoMembresia.ORO));
        clientes.add(new Cliente(2L, "Maria", "Lopez", "maria@gmail.com",
                "6449876543", "5678", TipoMembresia.PLATA));
        clientes.add(new Cliente(3L, "Carlos", "Ramirez", "carlos@gmail.com",
                "6441112233", "9999", TipoMembresia.BRONCE));
        clientes.add(new Cliente(4L, "Ana", "Torres", "ana@gmail.com",
                "6445554433", "1111", null));
    }

    @Override
    public Cliente buscarPorPin(String pin) {
        for(Cliente c: clientes){
            if(c.getPin().equals(pin)){
                return c;
            }
        }
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        for(Cliente c: clientes){
            if(c.getIdCliente().equals(id)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void actualizarMembresia(Long idCliente, TipoMembresia nuevaMembresia) {
        Cliente cliente = buscarPorId(idCliente);
        if(cliente != null){
            cliente.setMembresiaActiva(nuevaMembresia);
        }
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return new ArrayList<>(clientes);
    }
    
}
