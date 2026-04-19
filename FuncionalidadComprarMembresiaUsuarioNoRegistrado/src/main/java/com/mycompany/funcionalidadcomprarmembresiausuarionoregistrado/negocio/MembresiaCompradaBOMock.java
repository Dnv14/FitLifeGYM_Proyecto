package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.negocio;

import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dominio.MembresiaComprada;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos.MembresiaCompradaDTO;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.persistencia.IMembresiaCompradaDAO;
import java.util.List;

/**
 *
 * @author Julian
 */
public class MembresiaCompradaBOMock implements IMembresiaCompradaBO {

    private IMembresiaCompradaDAO membresiaComprada;

    public MembresiaCompradaBOMock(IMembresiaCompradaDAO membresiaComprada) {
        this.membresiaComprada = membresiaComprada;
    }

    @Override
    public MembresiaComprada guardar(MembresiaCompradaDTO compra) {
        return membresiaComprada.guardar(compra);
    }

    @Override
    public List<MembresiaComprada> obtenerTodas() {
        return membresiaComprada.obtenerTodas();
    }

}
