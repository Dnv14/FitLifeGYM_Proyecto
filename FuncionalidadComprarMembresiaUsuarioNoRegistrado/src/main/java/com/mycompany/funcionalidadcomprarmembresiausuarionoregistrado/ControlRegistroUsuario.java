/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado;

import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_negocio.IClientesBO;


/**
 *
 * @author Diego
 */
public class ControlRegistroUsuario implements IFuncionalidadRegistrarUsuario {

    private final IClientesBO clientesBO;

    public ControlRegistroUsuario(IClientesBO clientesBO) {
        this.clientesBO = clientesBO;
    }

    @Override
    public void RegistrarUsuario(NuevoClienteDTO clienteDTO) {
        clientesBO.registrarCliente(clienteDTO);
    }
}
