package com.mycompany.fitlifegym_persistencia;

import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class ClientesListDAO implements IClientesDAO {

    private List<Cliente> clientes = new ArrayList<>();
    private static Long contadorID = 1L;

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        contadorID++;
        this.clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente consultarClientePorId(Long id) {
        return this.clientes.stream()
                .filter(m -> m.getIdCliente().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cliente> consultarClientes() {
        return this.clientes;
    }

    @Override
    public Cliente buscarPorPin(String pin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente actualizarMembresia(Long idCliente, TipoMembresia nuevaMembresia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
