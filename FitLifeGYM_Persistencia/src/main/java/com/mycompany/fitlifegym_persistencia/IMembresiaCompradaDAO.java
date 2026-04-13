
package com.mycompany.fitlifegym_persistencia;

import com.mycompany.fitlifegym_persistencia.entidades.MembresiaComprada;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IMembresiaCompradaDAO {
    public abstract MembresiaComprada guardar(MembresiaComprada compra);
    public abstract List<MembresiaComprada> obtenerTodas();
}
