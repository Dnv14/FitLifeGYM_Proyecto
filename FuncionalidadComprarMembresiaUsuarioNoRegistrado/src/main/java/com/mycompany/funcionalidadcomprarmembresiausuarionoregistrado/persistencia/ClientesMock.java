
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class ClientesMock implements IClientesDAO{
    private List<Cliente> clientes = new ArrayList<>();
    
    @Override
    public Cliente registrarCliente(NuevoClienteDTO cliente) {
        Cliente clienteNuevo = new Cliente(cliente.getIdCliente(),cliente.getNombre(),cliente.getApellidos(),cliente.getCorreo(),cliente.getTelefono(),cliente.getPin());
        clientes.add(clienteNuevo);
        return clienteNuevo;
    }
    
}
