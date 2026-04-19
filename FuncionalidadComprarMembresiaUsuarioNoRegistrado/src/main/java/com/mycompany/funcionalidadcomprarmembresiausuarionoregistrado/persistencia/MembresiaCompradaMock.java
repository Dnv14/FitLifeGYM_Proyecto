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
    private static Long contadorId = 1L;

    @Override
    public MembresiaComprada guardar(MembresiaCompradaDTO compra) {
        MembresiaComprada nueva = new MembresiaComprada(
                contadorId++, 
                compra.getMembresia(),
                compra.getFechaInicio(),
                compra.getFechaFin(),
                compra.getPrecioPagado(),
                compra.getEstado()
        );
        compras.add(nueva);
        return nueva;
    }

    @Override
    public List<MembresiaComprada> obtenerTodas() {
        return compras;
    }
}
