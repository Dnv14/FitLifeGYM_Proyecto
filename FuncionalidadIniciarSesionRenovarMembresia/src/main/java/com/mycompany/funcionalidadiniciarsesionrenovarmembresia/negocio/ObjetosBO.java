/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.negocio;

import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.persistencia.ClientesDAOMock;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.persistencia.IClientesDAO;

/**
 *
 * @author Luis
 */
public class ObjetosBO {
    
    private final ILoginBO loginBO;
    private final IRenovarMembresiaBO renovarMembresiaBO;

    public ObjetosBO() {
        IClientesDAO clientesDAO = new ClientesDAOMock();
        this.loginBO = new LoginBOMock(clientesDAO);
        this.renovarMembresiaBO = new RenovarMembresiaBOMock(clientesDAO);
    }
    
     public ILoginBO getLoginBO() {
        return loginBO;
    }

    public IRenovarMembresiaBO getRenovarMembresiaBO() {
        return renovarMembresiaBO;
    }
    
}
