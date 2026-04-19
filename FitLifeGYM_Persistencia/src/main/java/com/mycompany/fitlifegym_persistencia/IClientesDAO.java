
package com.mycompany.fitlifegym_persistencia;

import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IClientesDAO {
    public abstract Cliente registrarCliente(Cliente cliente);
    public abstract Cliente consultarClientePorId(Long id);
    public abstract List<Cliente> consultarClientes();
}
