
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IClientesDAO {
    public abstract Cliente registrarCliente(NuevoClienteDTO cliente);
    public abstract Cliente consultarClientePorId(Long id);
    public abstract List<Cliente> consultarClientes();
}
