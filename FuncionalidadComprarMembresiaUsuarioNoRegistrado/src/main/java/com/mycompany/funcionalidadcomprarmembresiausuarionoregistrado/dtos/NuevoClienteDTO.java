
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.dtos;

/**
 *
 * @author Julian
 */
public class NuevoClienteDTO {
    private final String nombre;
    private final String apellidos;
    private final String correo;
    private final String telefono;
    private final String pin;

    public NuevoClienteDTO(String nombre, String apellidos, String correo, String telefono, String pin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPin() {
        return pin;
    }
    
}
