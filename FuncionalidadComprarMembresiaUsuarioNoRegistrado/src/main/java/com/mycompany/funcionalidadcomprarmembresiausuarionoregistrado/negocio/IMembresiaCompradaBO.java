
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.negocio;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.MembresiaComprada;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.MembresiaCompradaDTO;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IMembresiaCompradaBO {
    public abstract void guardar(MembresiaCompradaDTO compra);
    public abstract List<MembresiaComprada> obtenerTodas();
}
