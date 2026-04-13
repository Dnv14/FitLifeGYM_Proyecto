/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia.dominio;

/**
 *
 * @author Luis
 */
public class Cliente {
    private Long idCliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String pin;
    private TipoMembresia membresiaActiva; // "Bronce", "Plata", "Oro" o null si no tiene


    public Cliente() {
    
    }

    public Cliente(Long idCliente, String nombre, String apellidos, String correo, String telefono, String pin, TipoMembresia membresiaActiva) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.pin = pin;
        this.membresiaActiva = membresiaActiva;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public TipoMembresia getMembresiaActiva() {
        return membresiaActiva;
    }

    public void setMembresiaActiva(TipoMembresia membresiaActiva) {
        this.membresiaActiva = membresiaActiva;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", telefono=" + telefono + ", pin=" + pin + ", membresiaActiva=" + membresiaActiva + '}';
    }
    
}
