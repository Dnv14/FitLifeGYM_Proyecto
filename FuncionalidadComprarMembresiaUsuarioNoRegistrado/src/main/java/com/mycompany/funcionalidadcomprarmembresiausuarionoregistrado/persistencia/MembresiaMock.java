
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Membresia;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.MembresiaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class MembresiaMock implements IMembresiaDAO{
    private List<Membresia> lista = new ArrayList<>();

    @Override
    public void guardar(MembresiaDTO membresia) {
        
        lista.add(new Membresia(membresia.getIdMembresia(),membresia.getTipoMembresia(),membresia.getPrecio(),membresia.getVigencia()));
    }

    @Override
    public List<Membresia> obtenerTodas() {
        return lista;
    }

    @Override
    public Membresia obtenerPorId(Long id) {
        return lista.stream()
            .filter(m -> m.getIdMembresia().equals(id))
            .findFirst()
            .orElse(null);
    }
}
