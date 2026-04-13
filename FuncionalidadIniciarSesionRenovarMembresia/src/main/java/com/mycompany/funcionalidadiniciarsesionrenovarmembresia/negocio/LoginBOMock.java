/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.negocio;

import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio.Cliente;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos.ClienteLogueadoDTO;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dtos.LoginDTO;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.persistencia.IClientesDAO;

/**
 *
 * @author Luis
 */
public class LoginBOMock implements ILoginBO {
    
    private final IClientesDAO clientesDAO;
     
    public LoginBOMock(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }
     
    @Override
    public ClienteLogueadoDTO iniciarSesion(LoginDTO login) {
        Cliente cliente = clientesDAO.buscarPorPin(login.getPin());

        if (cliente == null) {
            return null;
        }

        String nombreCompleto = cliente.getNombre() + " " + cliente.getApellidos();
        return new ClienteLogueadoDTO(cliente.getIdCliente(), nombreCompleto, cliente.getMembresiaActiva());
    }
     

    


    
    
}
