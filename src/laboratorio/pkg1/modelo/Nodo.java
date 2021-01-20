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
public class Nodo {

    private Nodo anterior;
    private String valor;
    private Nodo siguiente;

    public Nodo() {
        this.anterior = null;
        this.valor = null;
        this.siguiente = null;
    }

    public Nodo(String valor) {
        this.anterior = null;
        this.valor = valor;
        this.siguiente = null;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
