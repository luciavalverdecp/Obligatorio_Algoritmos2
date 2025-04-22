package dominio;

import java.util.Objects;

public class ViajeroPorCorreoWrapper implements Comparable<ViajeroPorCorreoWrapper>{
    private Viajero viejero;

    public ViajeroPorCorreoWrapper(Viajero viejero) {
        this.viejero = viejero;
    }

    public Viajero getViejero() {
        return viejero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ViajeroPorCorreoWrapper that = (ViajeroPorCorreoWrapper) o;
        return Objects.equals(viejero.getCorreo(), that.viejero.getCorreo());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(viejero);
    }

    @Override
    public int compareTo(ViajeroPorCorreoWrapper o) {
        return this.viejero.getCorreo().compareTo(o.getViejero().getCorreo());
    }
}
