
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.Membresia;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.MembresiaDTO;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IMembresiaDAO {
    public abstract void guardar(MembresiaDTO membresia);
    public abstract List<Membresia> obtenerTodas();
    public abstract Membresia obtenerPorId(Long id);
}
