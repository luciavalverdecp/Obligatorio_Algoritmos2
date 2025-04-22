package dominio;

import interfaz.Categoria;

import java.util.Comparator;

public class Viajero implements Comparable<Viajero> {
    private String cedula;
    private String nombre;
    private String correo;
    private int edad;
    private Categoria categoria;

    public Viajero() {
    }

    public Viajero(String cedula, String nombre, String correo, int edad, Categoria categoria) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.categoria = categoria;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int compareTo(Viajero o) {
        return this.cedula.compareTo(o.cedula);
    }

    public boolean validarCedula(String cedula){
        int length = cedula.length();
        // Validar largo total posible
        if (length != 9 && length != 11) {
            return false;
        }
        // Validar que haya guion en la penúltima posición
        if (cedula.charAt(length - 2) != '-') {
            return false;
        }
        // Validar último carácter sea un dígito
        if (!Character.isDigit(cedula.charAt(length - 1))) {
            return false;
        }
        if (length == 9) {
            return Character.isDigit(cedula.charAt(0)) &&
                    Character.isDigit(cedula.charAt(1)) &&
                    Character.isDigit(cedula.charAt(2)) &&
                    cedula.charAt(3) == '.' &&
                    Character.isDigit(cedula.charAt(4)) &&
                    Character.isDigit(cedula.charAt(5)) &&
                    Character.isDigit(cedula.charAt(6)) &&
                    cedula.charAt(7) == '.';
        } else {
            return Character.isDigit(cedula.charAt(0)) &&
                    cedula.charAt(1) == '.' &&
                    Character.isDigit(cedula.charAt(2)) &&
                    Character.isDigit(cedula.charAt(3)) &&
                    Character.isDigit(cedula.charAt(4)) &&
                    cedula.charAt(5) == '.' &&
                    Character.isDigit(cedula.charAt(6)) &&
                    Character.isDigit(cedula.charAt(7)) &&
                    Character.isDigit(cedula.charAt(8));
        }
    }

    public boolean validarCorreo(String correo) {
        if (correo == null || correo.isEmpty()) return false;

        int arroba = correo.indexOf('@');
        int punto = correo.lastIndexOf('.');

        return arroba > 0 &&
                punto > arroba + 1 &&
                punto < correo.length() - 1;
    }
}
