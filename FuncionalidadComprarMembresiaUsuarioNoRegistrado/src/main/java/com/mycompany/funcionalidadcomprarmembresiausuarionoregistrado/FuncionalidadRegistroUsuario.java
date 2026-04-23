/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado;

import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_negocio.IClientesBO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Diego
 */
public class FuncionalidadRegistroUsuario implements IFuncionalidadRegistrarUsuario {

    private final IClientesBO clientesBO;

    public FuncionalidadRegistroUsuario(IClientesBO clientesBO) {
        this.clientesBO = clientesBO;
    }

    @Override
    public void RegistrarUsuario(NuevoClienteDTO clienteDTO) throws NegocioException {
        validarDatosUsuario(clienteDTO);
        try {
            clientesBO.registrarCliente(clienteDTO);
        } catch (NegocioException ex) {
            throw new NegocioException("Error al registrar el cliente.", ex);
        }
    }

    @Override
    public List<Cliente> obtenerTodas() throws NegocioException {
        try {
            return clientesBO.consultarClientes();
        } catch (NegocioException ex) {
            throw new NegocioException("Error al obtener todos los clientes", ex);
        }
    }

    @Override
    public void validarDatosUsuario(NuevoClienteDTO clienteDTO) throws NegocioException {
        if (clienteDTO.getNombre() == null || clienteDTO.getNombre().isEmpty() ) {
            throw new NegocioException("El nombre del cliente no puede ser nulo.");
        }

        if (clienteDTO.getApellidos() == null || clienteDTO.getApellidos().isEmpty()) {
            throw new NegocioException("El appelido del cliente no puede ser nulo.");
        }

        if (clienteDTO.getCorreo() == null || !clienteDTO.getCorreo().contains("@")) {
            throw new NegocioException("El formato del correo no es válido.");
        }

        if (clienteDTO.getTelefono().isEmpty() || !clienteDTO.getTelefono().matches("\\d{10}")) {
            throw new NegocioException("Ingrese el formato válido del teléfono.");
        }

        if (clienteDTO.getPin() == null || !clienteDTO.getPin().matches("\\d{4}")) {
            throw new NegocioException("Ingrese un PIN con al menos 4 números.");
        }
        
        // Validar que el PIN y el correo no esten duplicados Dieguin
        List<Cliente> clientesExistentes = clientesBO.consultarClientes();
        if (clientesExistentes != null) {
            for (Cliente c : clientesExistentes) {
                if (c.getPin() != null && c.getPin().equals(clienteDTO.getPin())) {
                    throw new NegocioException("El PIN ya esta en uso por favor elige otro.");
                }
                if (c.getCorreo() != null && c.getCorreo().equalsIgnoreCase(clienteDTO.getCorreo())) {
                    throw new NegocioException("El correo ya está registrado por favor usa otro.");
                }
            }
        }
    

    }
}
