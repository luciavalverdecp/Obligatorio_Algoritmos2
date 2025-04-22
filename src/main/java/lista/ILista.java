package lista;

public interface ILista<T> {
    void agregar(T t);
    void insertarFinal(T t);
    boolean existe(T t);
    int cantidad();
    int obtenerPorPos(int indice);
    boolean estaOrdenada();
}