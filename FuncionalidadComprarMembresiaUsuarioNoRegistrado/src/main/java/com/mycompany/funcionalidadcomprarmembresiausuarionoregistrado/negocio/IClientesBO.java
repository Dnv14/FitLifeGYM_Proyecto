
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.negocio;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IClientesBO {
    public abstract Cliente registrarCliente(NuevoClienteDTO cliente);
    public abstract Cliente buscarClientePorId(Long id);
    public abstract List<Cliente> consultarClientes();
}
