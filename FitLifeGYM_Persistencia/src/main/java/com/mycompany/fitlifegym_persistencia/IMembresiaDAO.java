
package com.mycompany.fitlifegym_persistencia;

import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IMembresiaDAO {
    public abstract Membresia guardar(Membresia membresia);
    public abstract List<Membresia> obtenerTodas();
    public abstract Membresia obtenerPorId(Long id);
}
