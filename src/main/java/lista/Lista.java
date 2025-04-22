package lista;

public class Lista<T> implements ILista<T>{

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidad;

    @Override
    public void agregar(T t) {
        Nodo nuevo = new Nodo(t);
        if(esVacia()){
            inicio = nuevo;
            fin = inicio;
        }else{
            nuevo.setSig(inicio);
            inicio = nuevo;
        }
        cantidad++;
    }

    @Override
    public void insertarFinal(T t) {
        Nodo aux = inicio;
        agregarRecursivamente(t, aux);
    }

    private void agregarRecursivamente(T t, Nodo aux) {
        if(aux.getSig() == null){
            aux.setSig(new Nodo(t, null));
        }else{
            aux = aux.getSig();
            agregarRecursivamente(t, aux);
        }
    }

    @Override
    public boolean existe(T t) {
        Nodo aux = inicio;
        while(aux.getSig() != null){
            if(aux.getDato() == t){
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }

    @Override
    public int cantidad() {
        return cantidad;
    }

    @Override
    public int obtenerPorPos(int indice) {
        return 0;
    }

    @Override
    public boolean estaOrdenada() {
        Nodo aux = inicio;
        return estaOrdenadaRec(aux);
    }

    private boolean estaOrdenadaRec(Nodo aux) {
        if(aux.getSig() == null){
            return true;
        }else{
//            if(aux.getDato() > aux.getSig().getDato()){
//                return false;
//            }
            aux = aux.getSig();
            return estaOrdenadaRec(aux);
        }
    }

    public boolean esVacia(){
        return inicio == null;
    }

    public void mostrarLista(){
        Nodo n = inicio;
        int p = 0;
        while(n != null){
            if(p == 0){
                System.out.print(n.getDato());
            }else{
                System.out.print(" - " + n.getDato());
            }
            p++;
            n = n.getSig();
        }
    }
}
