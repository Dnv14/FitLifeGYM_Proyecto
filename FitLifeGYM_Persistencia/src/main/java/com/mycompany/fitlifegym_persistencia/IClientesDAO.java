
package com.mycompany.fitlifegym_persistencia;

import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IClientesDAO {
    public abstract Cliente registrarCliente(Cliente cliente);
    
    public abstract Cliente consultarClientePorId(Long id);
    
    public abstract List<Cliente> consultarClientes();
    
    public abstract Cliente buscarPorPin(String pin);
    
    public abstract void actualizarMembresia(Long idCliente, TipoMembresia nuevaMembresia);
    
    
}
