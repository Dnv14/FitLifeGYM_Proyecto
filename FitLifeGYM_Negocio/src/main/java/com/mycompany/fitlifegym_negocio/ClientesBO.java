/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_persistencia.IClientesDAO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class ClientesBO implements IClientesBO {

    private final IClientesDAO clientesDAO;

    public ClientesBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    @Override
    public Cliente registrarCliente(NuevoClienteDTO clienteDTO) {
        Cliente cliente = DtosAEntidadesAdapter.adaptarClienteDTO(clienteDTO);
        
        if(clienteDTO.getNombre().isEmpty() || clienteDTO.getNombre() == null){
            throw new IllegalArgumentException("El nombre del cliente no puede ser nulo.");
        }
        
        if(clienteDTO.getApellidos().isEmpty() || clienteDTO.getApellidos() == null){
            throw new IllegalArgumentException("El appelido del cliente no puede ser nulo.");
        }
        
        if(clienteDTO.getCorreo() == null || clienteDTO.getCorreo().contains("@")){
            throw new IllegalArgumentException("El formato del correo no es válido.");
        }
        
        if(clienteDTO.getTelefono().isEmpty() || !clienteDTO.getTelefono().matches("\\d{10}")){
            throw new IllegalArgumentException("Ingrese el formato válido del teléfono.");
        }
        
        if(clienteDTO.getPin() == null || !clienteDTO.getPin().matches("\\d{5}")){
            throw new IllegalArgumentException("Ingrese un PIN con al menos 5 números.");
        }
        
        if(clienteDTO.getTarjeta() == null || clienteDTO.getTarjeta().isBlank()){
            throw new IllegalArgumentException("La tarjeta no puede estar vacía.");
        }
        
        if(clienteDTO.getMembresíaComprada() == null){
            throw new IllegalArgumentException("Se debe de elegir una membresia.");
        }
      
        return clientesDAO.registrarCliente(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {

        if(id == null){
            throw new IllegalArgumentException("Se debe de colocar un ID.");
        }



        return clientesDAO.consultarClientePorId(id);
    }

    @Override
    public List<Cliente> consultarClientes() {
        return clientesDAO.consultarClientes();
    }

}
