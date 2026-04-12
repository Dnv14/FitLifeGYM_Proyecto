
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.negocio;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.NuevoClienteDTO;

/**
 *
 * @author Julian
 */
public interface IClientesBO {
    public abstract Cliente registrarCliente(NuevoClienteDTO cliente);
}
