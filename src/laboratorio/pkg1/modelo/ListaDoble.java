/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkg1.modelo;

/**
 *
 * @author Casa
 */
public class ListaDoble {

    private Nodo cabeza;
    private Nodo cola;
    private int cantidad;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.cantidad = 0;
    }

    public ListaDoble(String valor) {
        inicializar(valor);
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public Nodo getCola() {
        return cola;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Metodo para ver inicializar la lista
     *
     * @param valor
     */
    private void inicializar(String valor) {
        this.cabeza = new Nodo();
        this.cabeza.setAnterior(null);
        this.cabeza.setSiguiente(null);
        this.cabeza.setValor(valor);
        this.cola = null;
        this.cantidad = 1;
    }

    /**
     * Metodo para contar los elementos de la lista
     *
     * @return int cantidad de elementos en la lista
     */
    public int contar() throws Exception {
        if (this.cabeza == null) {
            throw new Exception("[ La lista esta vacia. ]");
        }
        int suma = 0;
        Nodo nodo = this.cabeza;
        while (nodo != null) {
            suma++;
            nodo = nodo.getSiguiente();
        }
        return suma;
    }

    /**
     * Metodo para ver todos los elementos de la lista
     *
     * @return String nodos de la lista
     * @throws Exception
     */
    public String elementos() throws Exception {
        if (this.cabeza == null) {
            throw new Exception("[ La lista esta vacia. ]");
        }
        Nodo nodo = this.cabeza;

        String resultado = "";
        while (nodo != null) {
            resultado += nodo.getValor() + "|";
            nodo = nodo.getSiguiente();
        }
        return resultado.substring(0, resultado.length() - 1);
    }

    /**
     * Metodo para devolver arreglo de nodos
     *
     * @return Nodo[] nodos de la lista
     * @throws Exception
     */
    public Nodo[] arreglo() throws Exception {
        if (this.cabeza == null) {
            throw new Exception("[ La lista esta vacia. ]");
        }
        Nodo nodo = this.cabeza;
        Nodo arreglo[] = new Nodo[this.cantidad];

        for (int i = 0; i < this.cantidad; i++) {
            arreglo[i] = nodo;
            nodo = nodo.getSiguiente();
        }
        return arreglo;
    }

    /**
     * Metodo para ver todos los elementos de la lista en reversa
     *
     * @return String nodos de la lista
     * @throws Exception
     */
    public String elementosReversa() throws Exception {
        if (this.cabeza == null) {
            throw new Exception("[ La lista esta vacia. ]");
        }
        Nodo nodo = this.cola;

        String resultado = "";
        while (nodo != null) {
            resultado += nodo.getValor() + "|";
            nodo = nodo.getAnterior();
        }
        return resultado.substring(0, resultado.length() - 1);
    }

    /**
     * Metodo para concatenar dos listas
     *
     * @param lista Lista que se va a concatenar
     * @throws Exception
     */
    public void concatenar(ListaDoble lista) throws Exception {
        if (lista.cabeza == null) {
            throw new Exception("[ La lista esta vacia. ]");
        }
        Nodo nodo = lista.cabeza;

        while (nodo != null) {
            insertar(nodo.getValor());
            lista.extraer(nodo);
            nodo = nodo.getSiguiente();
        }
    }

    /**
     * Metodo para reemplazar un valor en la lista con la posicion
     *
     * @param valor
     * @param posicion
     * @throws Exception
     */
    public void reemplazar(String valor, int posicion) throws Exception {
        Nodo nodo = buscar(posicion);
        if (nodo.getValor() == null) {
            throw new Exception("[ No se encontro el nodo para eliminar. ]");
        }
        nodo.setValor(valor);
    }

    /**
     * Metodo para extraer un nodo
     *
     * @param nodo
     * @throws Exception
     */
    public void extraer(Nodo nodo) throws Exception {
        if (nodo.equals(this.cabeza)) {
            if (this.cantidad == 1) {
                this.cabeza = null;
            } else {
                this.cabeza.getSiguiente().setAnterior(null);
                this.cabeza = this.cabeza.getSiguiente();
                if (this.cantidad == 2) {
                    this.cabeza = this.cola;
                    this.cabeza.setSiguiente(null);
                    this.cola = null;
                }
            }
        } else if (nodo.equals(this.cola)) {
            if (this.cantidad == 2) {
                this.cabeza.setSiguiente(null);
                this.cola = null;
            } else {
                this.cola.getAnterior().setSiguiente(null);
                this.cola = this.cola.getAnterior();
            }

        } else {
            Nodo anterior = nodo.getAnterior();
            Nodo siguiente = nodo.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            nodo = null;
        }
        this.cantidad--;
    }

    /**
     * Metodo para eliminar en la lista con la posicion
     *
     * @param posicion
     * @throws Exception
     */
    public void eliminar(int posicion) throws Exception {
        Nodo nodo = buscar(posicion);
        if (nodo.getValor() == null) {
            throw new Exception("[ No se encontro el nodo para eliminar. ]");
        }
        extraer(nodo);
    }

    /**
     * Metodo para eliminar en la lista con el valor
     *
     * @param valor
     * @throws Exception
     */
    public void eliminar(String valor) throws Exception {
        Nodo nodo = buscar(valor);
        if (nodo.getValor() == null) {
            throw new Exception("[ No se encontro el nodo para eliminar. ]");
        }
        extraer(nodo);
    }

    /**
     * Metodo para buscar en la lista con la posicion
     *
     * @param posicion
     * @return Nodo encontrado
     * @throws Exception
     */
    public Nodo buscar(int posicion) throws Exception {
        if (this.cabeza == null) {
            throw new Exception("[ La lista esta vacia. ]");
        }
        Nodo nodo = this.cabeza;

        if (this.cola == null) {
            if (posicion == 1) {
                return nodo;
            }
        }

        if (posicion < 1 || posicion > this.cantidad) {
            throw new Exception("[ La posición #" + posicion + " es invalida,"
                    + " debe ser mayor a 0 y menor a " + (this.cantidad+1) + ". ]");
        }

        //verificar si es mas cerca por la izquierda o por la derecha
        if (posicion <= (this.cantidad - posicion)) {
            int contador = 1;
            while (nodo != this.cola) {
                if (contador++ == posicion) {
                    return nodo;
                }
                nodo = nodo.getSiguiente();
            }
        } else {
            int contador = this.cantidad;
            nodo = this.cola;
            while (nodo != this.cabeza) {
                if (contador-- == posicion) {
                    return nodo;
                }
                nodo = nodo.getAnterior();
            }
        }

        return new Nodo();
    }

    /**
     * Metodo para comprobar si existe un elemento en la lista
     *
     * @param valor
     * @return boolean
     * @throws Exception
     */
    public boolean existe(String valor) throws Exception {
        return buscar(valor).getValor() != null;
    }

    /**
     * Metodo alternativo para buscar con sub-cadenas similares y no validar
     * valor exacto
     *
     * @param valor
     * @return Nodo encontrado
     * @throws Exception
     */
    public Nodo buscar_sub_cadena(String valor) throws Exception {
        if (this.cabeza == null) {
            throw new Exception("[ La lista esta vacia. ]");
        }
        Nodo nodo = this.cabeza;

        if (this.cola == null) {
            if (this.cabeza.getValor().toLowerCase().contains(valor.toLowerCase())) {
                return nodo;
            }
        }

        //verificar si solo hay un elemento en la lista
        if (nodo.getSiguiente() == null) {
            if (nodo.getValor().toLowerCase().contains(valor.toLowerCase())) {
                return nodo;
            }
        } else {
            Nodo nodo2 = this.cola;
            int mitad = (int) Math.ceil(this.cantidad / 2.0);
            int i = 1;
            while (i <= mitad) {
                if (nodo.getValor().toLowerCase().contains(valor.toLowerCase())) {
                    return nodo;
                }
                if (nodo2.getValor().toLowerCase().contains(valor.toLowerCase())) {
                    return nodo2;
                }
                nodo = nodo.getSiguiente();
                nodo2 = nodo2.getAnterior();
                i++;
            }
        }
        return new Nodo();
    }

    /**
     * Metodo para buscar en la lista con el valor
     *
     * @param valor
     * @return Nodo encontrado
     * @throws Exception
     */
    private Nodo buscar(String valor) throws Exception {
        if (this.cabeza == null) {
            throw new Exception("[ La lista esta vacia. ]");
        }
        Nodo nodo = this.cabeza;

        if (this.cola == null) {
            if (this.cabeza.getValor().equals(valor)) {
                return nodo;
            }
        }

        //verificar si solo hay un elemento en la lista
        if (nodo.getSiguiente() == null) {
            if (nodo.getValor().equals(valor)) {
                return nodo;
            }
        } else {
            Nodo nodo2 = this.cola;
            int mitad = (int) Math.ceil(this.cantidad / 2.0);
            int i = 1;
            while (i <= mitad) {
                if (nodo.getValor().equals(valor)) {
                    return nodo;
                }
                if (nodo2.getValor().equals(valor)) {
                    return nodo2;
                }
                nodo = nodo.getSiguiente();
                nodo2 = nodo2.getAnterior();
                i++;
            }
        }
        return new Nodo();
    }

    /**
     * Metodo para insertar en la lista
     *
     * @param valor
     */
    public void insertar(String valor) {
        //Si la lista esta vacia, se inicializa
        if (this.cabeza == null) {
            inicializar(valor);
        } else {
            Nodo nodo = new Nodo(valor);
            //Si no hay cola
            if (this.cola == null) {
                this.cabeza.setSiguiente(nodo);
                nodo.setAnterior(this.cabeza);
            } else {
                nodo.setAnterior(this.cola);
                this.cola.setSiguiente(nodo);
            }
            this.cola = nodo;
            this.cantidad++;
        }

    }

}
