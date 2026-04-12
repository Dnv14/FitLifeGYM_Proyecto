
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;

/**
 *
 * @author Julian
 */
public interface IClientesDAO {
    public abstract Cliente registrarCliente(NuevoClienteDTO cliente);
}
