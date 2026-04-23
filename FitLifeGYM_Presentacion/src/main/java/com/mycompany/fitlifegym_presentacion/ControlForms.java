/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.EstadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaCompradaDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import com.mycompany.fitlifegym_negocio.ClientesBO;
import com.mycompany.fitlifegym_negocio.IClientesBO;
import com.mycompany.fitlifegym_negocio.ILoginBO;
import com.mycompany.fitlifegym_negocio.IMembresiaBO;
import com.mycompany.fitlifegym_negocio.IRenovarMembresiaBO;
import com.mycompany.fitlifegym_negocio.LoginBO;
import com.mycompany.fitlifegym_negocio.MembresiaBO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import com.mycompany.fitlifegym_negocio.RenovarMembresiaBO;
import com.mycompany.fitlifegym_persistencia.ClientesListDAO;
import com.mycompany.fitlifegym_persistencia.IClientesDAO;
import com.mycompany.fitlifegym_persistencia.IMembresiaDAO;
import com.mycompany.fitlifegym_persistencia.MembresiaListDAO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.Membresia;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.FuncionalidadRegistroUsuario;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.IFuncionalidadRegistrarUsuario;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.FuncionalidadIniciarSesionRenovarMembresia;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.IFuncionalidadIniciarSesionRenovarMembresia;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControlForms {

    private JFrame frameActual;
    private NuevoClienteDTO cliente;
    private ClienteLogueadoDTO clienteActual;
    private IFuncionalidadRegistrarUsuario funcionalidadCU;
    private IFuncionalidadIniciarSesionRenovarMembresia funcionalidad;

    public ControlForms() {
        this.cliente = new NuevoClienteDTO();
        IClientesDAO dao = new ClientesListDAO();
        IClientesBO negocio = new ClientesBO(dao);
        IMembresiaDAO membresiaDAO = new MembresiaListDAO();
        IMembresiaBO membresiaBO = new MembresiaBO(membresiaDAO);
        ILoginBO loginBO = new LoginBO(dao);
        IRenovarMembresiaBO renovarBO = new RenovarMembresiaBO(dao);
        this.funcionalidadCU = new FuncionalidadRegistroUsuario(negocio);
        this.funcionalidadCU = new FuncionalidadRegistroUsuario(negocio);
        this.funcionalidad = new FuncionalidadIniciarSesionRenovarMembresia(loginBO, membresiaBO, renovarBO);
    }

    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }

        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        frameActual.setVisible(true);
    }

    private void mostrarDialogo(JDialog nuevoDialogo) {
        nuevoDialogo.setResizable(false);
        nuevoDialogo.setLocationRelativeTo(this.frameActual);
        nuevoDialogo.setVisible(true);
    }

    //frames
    public void navegarMenuPrincipal() {
        mostrarPantalla(new MainFitLifeFORM(this));
    }

    public void navegarBenificios() {
        mostrarPantalla(new BeneficiosFORM(this));
    }

    public void navegarBienvenida(ClienteLogueadoDTO cliente) {
        mostrarPantalla(new BienvenidaFORM(this, cliente));
    }

    public void navegarMetodosPago(TipoMembresiaDTO membresia) {
        mostrarPantalla(new SuscribirseFORM(this,membresia));
    }

    //Dialogs
    public void navegarRegistrarse() {
        mostrarDialogo(new RegistrarseFORM(this.frameActual, true, this));
    }

    public void navegarIniciarSesion() {
        mostrarDialogo(new IniciarSesionFORM(this.frameActual, true, this));
    }

    public void navegarTransferenciaMetodo(TipoMembresiaDTO membresia) {
        mostrarDialogo(new TransferenciaFORM(this.frameActual, true, this,membresia));
    }

    public void navegarTarjetaMetodo(TipoMembresiaDTO membresia) {
        mostrarDialogo(new TarjetaFORM(this.frameActual, true, this,membresia));
    }

    public void navegarIniciarSesionPaypal(TipoMembresiaDTO membresia) {
        mostrarDialogo(new IniciarSesionPaypalFORM(this.frameActual, true, this,membresia));
    }

    //control
    public TipoMembresiaDTO seleccionarMembresia(String tipo) {
        TipoMembresiaDTO tipoMembresiaDTO;
        switch (tipo) {
            case "Oro":
                tipoMembresiaDTO = TipoMembresiaDTO.ORO;
                break;
            case "Plata":
                tipoMembresiaDTO = TipoMembresiaDTO.PLATA;
                break;
            default:
                tipoMembresiaDTO = TipoMembresiaDTO.BRONCE;
        }
        
        
        return tipoMembresiaDTO;
        //System.out.println("Membresia asignada antes del pago");
    }
    
    public void asignarMembresiaCliente(TipoMembresiaDTO membresia){
        double precio;
        switch (membresia.toString()) {
            case "Oro":
                precio = 750.0;
                break;
            case "Plata":
                precio = 500.0;
                break;
            default:
                precio = 300.0;
        }
        NuevaMembresiaDTO membresiaDTO = new NuevaMembresiaDTO(membresia,
                precio, LocalDate.now().plusMonths(1));

        NuevaMembresiaCompradaDTO membresiaCompradaDTO = new NuevaMembresiaCompradaDTO(
                membresiaDTO,
                LocalDate.now(),
                LocalDate.now().plusMonths(1),
                precio,
                EstadoDTO.ACTIVO
        );
        this.cliente.setMembresíaComprada(membresiaCompradaDTO);
    }

    public void registrarCliente(NuevoClienteDTO clienteDTO) throws NegocioException {
        funcionalidadCU.RegistrarUsuario(clienteDTO);
        this.cliente = clienteDTO;
    }

    public void procesarPagoTarjeta(String numeroTarjeta, String cvv, String fechaVencimiento) throws NegocioException {
//            LocalDate hoy = LocalDate.now();
//            NuevaMembresiaCompradaDTO compraDTO = this.cliente.getMembresíaComprada();
//            
//            compraDTO.setFechaInicio(hoy);
//            compraDTO.setFechaFin(hoy.plusMonths(1));
//            compraDTO.setEstado(EstadoDTO.ACTIVO);
//            
//            this.cliente.setTarjeta(numeroTarjeta);
//            funcionalidadCU.RegistrarUsuario(this.cliente);
        //System.out.println(" Membresía asignada a: " + this.cliente.getNombre());
    }

    public NuevoClienteDTO getCliente() {
        return cliente;
    }

    public ClienteLogueadoDTO getClienteActual() {
        return clienteActual;
    }

    public List<Cliente> consultarClientes() throws NegocioException {
        return funcionalidadCU.obtenerTodas();
    }

    //Modificado
    public ClienteLogueadoDTO iniciarSesion(String pin, String contrasenia) throws NegocioException {
        LoginDTO loginDTO = new LoginDTO(pin, contrasenia);
        this.clienteActual = funcionalidad.iniciarSesion(loginDTO);
        return this.clienteActual;
    }

    //Nuevo Para consultar las Membresia o Los Tipos Mas bien
    public List<Membresia> consultarMembresias() throws NegocioException {
        return funcionalidad.consultarMembresias();
    }

    //Nuevo(lo agregrege para la renovacion)
    public void renovarMembresia(String tipoMembresia) throws NegocioException {
        if (this.clienteActual == null) {
            throw new NegocioException("No hay un cliente logueado para renovar membresía.");
        }

        TipoMembresiaDTO tipoDTO;
        switch (tipoMembresia) {
            case "Oro":
                tipoDTO = TipoMembresiaDTO.ORO;
                break;
            case "Plata":
                tipoDTO = TipoMembresiaDTO.PLATA;
                break;
            default:
                tipoDTO = TipoMembresiaDTO.BRONCE;
                break;
        }

        RenovarMembresiaDTO dto = new RenovarMembresiaDTO(clienteActual.getIdCliente(), tipoDTO);
        funcionalidad.renovarMembresia(dto);
    }

}
