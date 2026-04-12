
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.MembresiaComprada;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.MembresiaCompradaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class MembresiaCompradaMock implements IMembresiaCompradaDAO {
    private List<MembresiaComprada> compras = new ArrayList<>();

    @Override
    public void guardar(MembresiaCompradaDTO compra) {
        compras.add(new MembresiaComprada(compra.getIdMembresiaComprada(),compra.getMembresia(),compra.getFechaInicio(),compra.getFechaFin(),compra.getPrecioPagado(),compra.getEstado()));
    }

    @Override
    public List<MembresiaComprada> obtenerTodas() {
        return compras;
    }
}
