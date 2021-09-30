package com.in5bm.equipo3.models.domain;

/**
 *
 * @author Omar Chocojay
 */
public class Instructor {
    private int instructorId;
    private String apellidos;
    private String nombres;
    private String direccion;
    private String telefono;

    public Instructor() {
    }

    public Instructor(int instructorId) {
        this.instructorId = instructorId;
    }

        public Instructor(String apellidos, String nombres, String direccion, String telefono) {

        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Instructor(int instructorId, String apellidos, String nombres, String direccion, String telefono) {
        this.instructorId = instructorId;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Instructor{" + "instructorId=" + instructorId + ", apellidos=" + apellidos + ", nombres=" + nombres + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
}
