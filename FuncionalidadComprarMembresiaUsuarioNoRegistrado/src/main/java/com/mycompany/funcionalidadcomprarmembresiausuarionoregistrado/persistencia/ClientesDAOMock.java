package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class ClientesDAOMock implements IClientesDAO {

    private static List<Cliente> clientes = new ArrayList<>();
    private static Long idContador = 1L;

    @Override
    public Cliente registrarCliente(NuevoClienteDTO cliente) {
        Cliente clienteNuevo = new Cliente(idContador, cliente.getNombre(), cliente.getApellidos(), cliente.getCorreo(), cliente.getTelefono(), cliente.getPin());
        clientes.add(clienteNuevo);
        idContador++;
        return clienteNuevo;
    }

    @Override
    public Cliente consultarClientePorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getIdCliente().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cliente> consultarClientes() {
        List<Cliente> clientesConsultados = clientes.stream().toList();
        return clientesConsultados;
    }
}
