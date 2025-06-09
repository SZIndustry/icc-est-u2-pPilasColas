package materia;

import java.util.NoSuchElementException;
import models.Persona;

public class QueueG<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public QueueG() {
        primero = null;
        ultimo = null;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public void add(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        T valor = primero.valor;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        return valor;
    }

    public void printCola() {
        Nodo<T> aux = primero;
        System.out.print("Cola: ");
        while (aux != null) {
            System.out.print(aux.valor + " | ");
            aux = aux.siguiente;
        }
        System.out.println();
    }

    public Persona findByName(String nombre) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.valor instanceof Persona) {
                Persona persona = (Persona) actual.valor;
                if (persona.getNombre().equalsIgnoreCase(nombre)) {
                    return persona;
                }
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public Persona deleteByName(String nombre) {
        Nodo<T> actual = primero;
        Nodo<T> anterior = null;

        while (actual != null) {
            if (actual.valor instanceof Persona) {
                Persona persona = (Persona) actual.valor;
                if (persona.getNombre().equalsIgnoreCase(nombre)) {
                    if (anterior == null) {
                        primero = actual.siguiente;
                        if (primero == null) {
                            ultimo = null;
                        }
                    } else {
                        anterior.siguiente = actual.siguiente;
                        if (actual == ultimo) {
                            ultimo = anterior;
                        }
                    }
                    return persona;
                }
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return null;
    }
}
