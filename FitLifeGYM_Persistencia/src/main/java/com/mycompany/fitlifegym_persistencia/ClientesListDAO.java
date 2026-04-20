package com.mycompany.fitlifegym_persistencia;

import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Julian
 */
public class ClientesListDAO implements IClientesDAO {
    
    private static final Logger LOGGER = Logger.getLogger(ClientesListDAO.class.getName());
    private static List<Cliente> clientes = new ArrayList<>();
    private static Long contadorID = 1L;

    @Override
    public Cliente registrarCliente(Cliente cliente) throws PersistenciaException{
        contadorID++;
        this.clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente consultarClientePorId(Long id) throws PersistenciaException{
        return this.clientes.stream()
                .filter(m -> m.getIdCliente().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenciaException{
        return this.clientes;
    }

    @Override
    public Cliente buscarPorPin(String pin) throws PersistenciaException{
        for(Cliente c: clientes){
            if(c.getPin().equals(pin)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void actualizarMembresia(Long idCliente, TipoMembresia nuevaMembresia) throws PersistenciaException{
        try{
        Cliente cliente = consultarClientePorId(idCliente);
        if(cliente != null){
            cliente.setMembresiaActiva(nuevaMembresia);
        }
        }catch(PersistenciaException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al actualizar membresia",ex);  
        }
    }
    
    static {
        clientes.add(new Cliente(1L, "Jorge", "Gonzalez", "jorge@gmail.com",
                "6441234567", "1234", TipoMembresia.ORO));
        clientes.add(new Cliente(2L, "Maria", "Lopez", "maria@gmail.com",
                "6449876543", "5678", TipoMembresia.PLATA));
        clientes.add(new Cliente(3L, "Carlos", "Ramirez", "carlos@gmail.com",
                "6441112233", "9999", TipoMembresia.BRONCE));
        clientes.add(new Cliente(4L, "Ana", "Torres", "ana@gmail.com",
                "6445554433", "1111", null));
    }
}
