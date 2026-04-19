
package com.mycompany.fitlifegym_persistencia;

import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class MembresiaListDAO implements IMembresiaDAO{
    private List<Membresia> membresias = new ArrayList<>();
    @Override
    public Membresia guardar(Membresia membresia) {
        this.membresias.add(membresia);
        return membresia;
    }

    @Override
    public List<Membresia> obtenerTodas() {
        return this.membresias;
    }

    @Override
    public Membresia obtenerPorId(Long id) {
        return this.membresias.stream()
            .filter(m -> m.getIdMembresia().equals(id))
            .findFirst()
            .orElse(null);
    }
    
}
