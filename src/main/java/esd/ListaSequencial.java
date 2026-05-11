package esd;

import java.util.Random;

public class ListaSequencial<T> {

    T[] area;
    int len = 0;
    final int defcap = 8;

    @SuppressWarnings("unchecked")
    public ListaSequencial() {
        area = (T[])new Object[defcap];
    }

    private void expandir() {

        T[] novo = (T[]) new Object[area.length * 2];

        for (int i = 0; i < len; i++) {
            novo[i] = area[i];
        }

        area = novo;
    }

    public boolean esta_vazia() {
        // retorna tue se lista estiver vazia, ou false caso contrário
        return len == 0;
    }

    public int capacidade() {
        // retorna um inteiro que representa a capacidade da lista
        return area.length;
    }

    public void adiciona(T elemento) {
        // adiciona um valor ao final da lista

        if (len == area.length) {
            expandir();
        }

        area[len] = elemento;

        len++;

    }

    public void insere(T elemento) {
        // insere um valor no início (posição 0)
        // move uma posição para frente os valores a partir dessa posição
        // dispara IndexOutOfBoundsException se "indice" for inválido

        insere(0, elemento);

    }

    public void insere(int indice, T elemento) {
        // insere um valor na posição indicada por "indice"
        // move uma posição para frente os valores a partir dessa posição
        // dispara IndexOutOfBoundsException se "indice" for inválido
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }

        if (len == area.length) {
            expandir();
        }

        for (int i = len; i > indice; i--) {
            area[i] = area[i - 1];
        }

        area[indice] = elemento;

        len++;

    }

    public void insere_ordenado(Comparable valor) {
        // procura a posição onde inserir o valor
        int pos = 0;

        while (pos < len &&
                valor.compareTo(area[pos]) > 0) {

            pos++;
        }

        insere(pos, (T) valor);
    }

    public T remove(int indice) {
        // remove um valor da posição indicada pelo parâmetro "indice"
        // move uma posição para trás os valores das próximas posições
        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
        // retorna o valor que foi removido da lista
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        T algo = area[indice];

        for (int i = indice; i < len - 1; i++) {
            area[i] = area[i + 1];
        }

        area[len - 1] = null;

        len--;

        return algo;
    }

    public T remove_rapido(int indice) {
        // remove um valor da posição indica pelo parãmetro índice
        // move o último dado da lista para essa posição
        // dispara IndexOutOfBoundsException se indice for inválido
        // retorna o valor que ofi removido da lista
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        T algo = area[indice];

        area[indice] = area[len - 1];

        area[len - 1] = null;

        len--;

        return algo;
    }

    public T remove_ultimo() {
        // remove o último valor da lista
        // disparar uma exceção IndexOutOfBoundsException caso lista vazia
        // retorna o valor que foi removido da lista
        if (esta_vazia()) {
            throw new IndexOutOfBoundsException(
                    "Lista vazia"
            );
        }

        T algo = area[len - 1];

        area[len - 1] = null;

        len--;

        return algo;
    }

    public void remove(T valor) {
        // todo

        int indice = procura(valor);

        if (indice != -1) {
            remove(indice);
        }
    }

    public int procura(T valor) {
        // retorna um inteiro que representa aposição onde valor foi encontrado pela primeira vez (contando do início da lista)
        // retorna -1 se não o encontrar !
        for (int i = 0; i < len; i++) {

            if (area[i].equals(valor)) {
                return i;
            }
        }

        return -1;
    }

    public boolean esta_ordenada() {
        // implemente aqui o método
        for (int i = 0; i < len - 1; i++) {

            Comparable atual = (Comparable) area[i];

            if (atual.compareTo(area[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    public T obtem(int indice) {
        // retorna o valor armazenado na posição indica pelo parâmetro "indice"
        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        return area[indice];
    }

    public T primeiro() {
        // retorna o valor armazenado no início da lista
        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
        if (esta_vazia()) {
            throw new IndexOutOfBoundsException(
                    "Lista vazia"
            );
        }

        return area[0];
    }

    public T ultimo() {
        // retorna o valor armazenado no final da lista
        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
        if (esta_vazia()) {
            throw new IndexOutOfBoundsException(
                    "Lista vazia"
            );
        }

        return area[len - 1];
    }

    public void substitui(int indice, T valor) {
        // armazena o valor na posição indicada por "indice", substituindo o valor lá armazenado atualmente
        // disparar uma exceção IndexOutOfBoundsException caso posição seja inválida
        if (indice < 0 || indice >= len) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        area[indice] = valor;
    }

    public int comprimento() {
        // retorna um inteiro que representa o comprimento da lista (quantos valores estão armazenados)
        return len;
    }

    public void limpa() {
        // esvazia a lista
        for (int i = 0; i < len; i++) {
            area[i] = null;
        }

        len = 0;
    }

    public int busca_binaria(Comparable valor) {
        int inicio = 0;
        int fim = len - 1;

        while (inicio <= fim) {

            int meio = (inicio + fim) / 2;

            Comparable atual =
                    (Comparable) area[meio];

            int comp = atual.compareTo(valor);

            if (comp == 0) {
                return meio;
            }

            if (comp < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    public void ordena() {
        for (int i = 0; i < len - 1; i++) {

            for (int j = 0; j < len - 1 - i; j++) {

                Comparable atual =
                        (Comparable) area[j];

                if (atual.compareTo(area[j + 1]) > 0) {

                    T temp = area[j];

                    area[j] = area[j + 1];

                    area[j + 1] = temp;
                }
            }
        }

    }

    public void embaralha() {
        Random random = new Random();

        for (int i = 0; i < len; i++) {

            int j = random.nextInt(len);

            T temp = area[i];

            area[i] = area[j];

            area[j] = temp;
        }

    }

}