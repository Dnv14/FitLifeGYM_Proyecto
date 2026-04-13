
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.negocio;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Membresia;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.MembresiaDTO;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.IMembresiaDAO;
import java.util.List;

/**
 *
 * @author Julian
 */
public class MembresiaBOMock implements IMembresiaBO{
    private IMembresiaDAO membresiaDAO;

    public MembresiaBOMock(IMembresiaDAO membresiaDAO) {
        this.membresiaDAO = membresiaDAO;
    }
    
    @Override
    public void guardar(MembresiaDTO membresia) {
        membresiaDAO.guardar(membresia);
    }

    @Override
    public List<Membresia> obtenerTodas() {
        return membresiaDAO.obtenerTodas();
    }

    @Override
    public Membresia obtenerPorId(Long id) {
        return membresiaDAO.obtenerPorId(id);
    }
    
}
