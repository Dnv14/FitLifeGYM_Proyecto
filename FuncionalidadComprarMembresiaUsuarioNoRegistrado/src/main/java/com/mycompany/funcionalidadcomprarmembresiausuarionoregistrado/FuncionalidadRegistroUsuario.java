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
    public void RegistrarUsuario(NuevoClienteDTO clienteDTO) throws NegocioException{
        if(clienteDTO.getNombre().isEmpty() || clienteDTO.getNombre() == null){
            throw new NegocioException("El nombre del cliente no puede ser nulo.");
        }
        
        if(clienteDTO.getApellidos().isEmpty() || clienteDTO.getApellidos() == null){
            throw new NegocioException("El appelido del cliente no puede ser nulo.");
        }
        
        if(clienteDTO.getCorreo() == null || clienteDTO.getCorreo().contains("@")){
            throw new NegocioException("El formato del correo no es válido.");
        }
        
        if(clienteDTO.getTelefono().isEmpty() || !clienteDTO.getTelefono().matches("\\d{10}")){
            throw new NegocioException("Ingrese el formato válido del teléfono.");
        }
        
        if(clienteDTO.getPin() == null || !clienteDTO.getPin().matches("\\d{5}")){
            throw new NegocioException("Ingrese un PIN con al menos 5 números.");
        }
        
        if(clienteDTO.getTarjeta() == null || clienteDTO.getTarjeta().isBlank()){
            throw new NegocioException("La tarjeta no puede estar vacía.");
        }
        
        if(clienteDTO.getMembresíaComprada() == null){
            throw new NegocioException("Se debe de elegir una membresia.");
        }

        try {
            clientesBO.registrarCliente(clienteDTO);
        } catch (NegocioException ex) {
            throw new NegocioException("Error al registrar el cliente.",ex);
        }
    }

    @Override
    public List<Cliente> obtenerTodas() throws NegocioException{
        try {
            return clientesBO.consultarClientes();
        } catch (NegocioException ex) {
            throw new NegocioException("Error al obtener todos los clientes",ex);
        }
    }
}
