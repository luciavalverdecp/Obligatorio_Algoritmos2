package abb;

import java.util.Comparator;

public class ABB<T extends Comparable<T>> {
    private Nodo<T> raiz;
    private final Comparator<T> comparador;

    public ABB() {
        this.raiz = null;
        this.comparador = null;
    }

    public ABB(Comparator<T> comparador) {
        this.raiz = null;
        this.comparador = comparador;
    }

    public void agregar(T dato){
        if(raiz == null){
            raiz = new Nodo<>(dato);
        }else{
            agregar(raiz, dato);
        }
    }

    private void agregar(Nodo<T> nodo, T dato) {
        if(comparar(nodo.getDato(), dato) < 0){
            //Derecha
            if(nodo.getDer() == null){
                //Tengo que agregarlo
                nodo.setDer(new Nodo<>(dato));
            }else{
                //Llamar rec
                agregar(nodo.getDer(), dato);
            }
        }else{
            //Izquierda
            if(nodo.getIzq() == null){
                //Tengo que agregarlo
                nodo.setIzq(new Nodo<>(dato));
            }else{
                //Llamar rec
                agregar(nodo.getIzq(), dato);
            }
        }
    }

    public boolean existe(T dato){
        return obtener(dato) != null;
    }

    public T obtener(T dato){
        return obtener(raiz, dato);
    }

    private T obtener(Nodo<T> n, T dato) {
        if(n == null){
            return null;
        }else if(n.getDato().equals(dato)){
            return n.getDato();
        }else if(comparar(n.getDato(), dato) > 0){
            return obtener(n.getIzq(), dato);
        }else{
            return obtener(n.getDer(), dato);
        }
    }

    public void mostrarCreciente(){
        System.out.println("ARBOL IMPRESO CRECIENTEMENTE");
        mostrarCreciente(raiz);
        System.out.println();
    }

    private void mostrarCreciente(Nodo<T> n) {
        if(n != null){
            if(n.getIzq() != null){
                mostrarCreciente(n.getIzq());
            }
            System.out.print(n.getDato() + " - ");
            if(n.getDer() != null){
                mostrarCreciente(n.getDer());
            }
        }
    }

    public void mostrarDecreciente(){
        System.out.println("ARBOL IMPRESO DECRECIENTEMENTE");
        mostrarDecreciente(raiz);
        System.out.println();
    }

    private void mostrarDecreciente(Nodo<T> n) {
        if(n != null) {
            if (n.getDer() != null) {
                mostrarDecreciente(n.getDer());
            }
            System.out.print(n.getDato() + " - ");
            if (n.getIzq() != null) {
                mostrarDecreciente(n.getIzq());
            }
        }
    }

    private int comparar(T dato1, T dato2){
        if(comparador != null){
            return comparador.compare(dato1, dato2);
        }
        return dato1.compareTo(dato2);
    }
}
