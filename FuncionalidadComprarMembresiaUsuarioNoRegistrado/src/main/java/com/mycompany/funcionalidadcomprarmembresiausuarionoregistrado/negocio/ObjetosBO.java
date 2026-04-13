/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.negocio;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.ClientesDAOMock;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.IClientesDAO;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.IMembresiaCompradaDAO;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.IMembresiaDAO;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.MembresiaCompradaMock;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.MembresiaMock;

/**
 *
 * @author Diego
 */
public class ObjetosBO {

    private IClientesBO clientesBO;
    private IMembresiaCompradaBO membresiaCompradaBO;
    private IMembresiaBO membresiaBO;

    public ObjetosBO() {
        this.clientesBO = new ClientesBOMock(new ClientesDAOMock());
        this.membresiaCompradaBO = new MembresiaCompradaBOMock(new MembresiaCompradaMock());
        this.membresiaBO = new MembresiaBOMock(new MembresiaMock());
    }

    public IClientesBO getClientesBO() {
        return clientesBO;
    }

    public IMembresiaCompradaBO getMembresiaCompradaBO() {
        return membresiaCompradaBO;
    }

    public IMembresiaBO getMembresiaBO() {
        return membresiaBO;
    }
    
    
}
