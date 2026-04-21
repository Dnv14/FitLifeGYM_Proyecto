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
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import com.mycompany.fitlifegym_negocio.ClientesBO;
import com.mycompany.fitlifegym_negocio.IClientesBO;
import com.mycompany.fitlifegym_negocio.ILoginBO;
import com.mycompany.fitlifegym_negocio.LoginBO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import com.mycompany.fitlifegym_persistencia.ClientesListDAO;
import com.mycompany.fitlifegym_persistencia.IClientesDAO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.FuncionalidadRegistroUsuario;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.IFuncionalidadRegistrarUsuario;
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
    private IFuncionalidadRegistrarUsuario funcionalidadCU;
    private ClienteLogueadoDTO clienteActual;
    private ILoginBO loginBO;

    public ControlForms() {
        this.cliente = new NuevoClienteDTO();
        IClientesDAO dao = new ClientesListDAO();
        IClientesBO negocio = new ClientesBO(dao);
        this.loginBO = new LoginBO(dao);
        this.funcionalidadCU = new FuncionalidadRegistroUsuario(negocio);
    }

    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }

        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        frameActual.setLocationRelativeTo(null);
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
        BienvenidaFORM form = new BienvenidaFORM(this, cliente);
        form.setVisible(true);
    }

    public void navegarMetodosPago() {
        mostrarPantalla(new SuscribirseFORM(this));
    }

    //Dialogs
    public void navegarRegistrarse() {
        mostrarDialogo(new RegistrarseFORM(this.frameActual, true, this));
    }

    public void navegarIniciarSesion() {
        mostrarDialogo(new IniciarSesionFORM(this.frameActual, true, this));
    }

    public void navegarTransferenciaMetodo() {
        mostrarDialogo(new TransferenciaFORM(this.frameActual, true, this));
    }

    public void navegarTarjetaMetodo() {
        mostrarDialogo(new TarjetaFORM(this.frameActual, true, this));
    }

    public void navegarIniciarSesionPaypal() {
        mostrarDialogo(new IniciarSesionPaypalFORM(this.frameActual, true, this));
    }

    //control
    public void seleccionarMembresia(String tipo) {
        double precio;

        TipoMembresiaDTO tipoMembresiaDTO;
        switch (tipo) {
            case "Oro":
                tipoMembresiaDTO = TipoMembresiaDTO.ORO;
                precio = 750.0;
                break;
            case "Plata":
                tipoMembresiaDTO = TipoMembresiaDTO.PLATA;
                precio = 500.0;
                break;
            default:
                tipoMembresiaDTO = TipoMembresiaDTO.BRONCE;
                precio = 300.0;
        }

        NuevaMembresiaDTO membresiaDTO = new NuevaMembresiaDTO(tipoMembresiaDTO,
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
    


    public void registrarCliente(NuevoClienteDTO clienteDTO) {
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

    public List<Cliente> consultarClientes() throws NegocioException {
        return funcionalidadCU.obtenerTodas();
    }
    
     public ClienteLogueadoDTO iniciarSesion(String pin) throws NegocioException {
        LoginDTO loginDTO = new LoginDTO(pin);
        this.clienteActual = loginBO.iniciarSesion(loginDTO);
        return this.clienteActual;
    }

}
