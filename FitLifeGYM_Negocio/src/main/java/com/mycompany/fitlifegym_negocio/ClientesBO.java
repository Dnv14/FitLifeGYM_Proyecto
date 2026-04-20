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
    private final List<Cliente> clientes = new ArrayList<>();
    private Long contadorID = 1L;

    public ClientesBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    @Override
    public Cliente registrarCliente(NuevoClienteDTO clienteDTO) {
        Cliente cliente = DtosAEntidadesAdapter.adaptarClienteDTO(clienteDTO);
        cliente.setIdCliente(contadorID++);
        clientes.add(cliente);
        return cliente;

    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clientes.stream().filter(c -> c.getIdCliente().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Cliente> consultarClientes() {
        return new ArrayList<>(clientes);
    }

}
