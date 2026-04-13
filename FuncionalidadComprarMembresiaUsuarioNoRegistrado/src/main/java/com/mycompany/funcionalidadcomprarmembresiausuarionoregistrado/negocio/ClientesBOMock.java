
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.negocio;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.IClientesDAO;
import java.util.List;

/**
 *
 * @author Julian
 */
public class ClientesBOMock implements IClientesBO{
    private final IClientesDAO clientesDAO;

    public ClientesBOMock(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }
    
    @Override
    public Cliente registrarCliente(NuevoClienteDTO cliente) {
        return clientesDAO.registrarCliente(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clientesDAO.consultarClientePorId(id);
    }

    @Override
    public List<Cliente> consultarClientes() {
        return clientesDAO.consultarClientes();
    }
    
}
