package model;

import esd.ListaSequencial;
import sm.Produto;

public class ResultadoMercado implements Comparable<ResultadoMercado> {

    private String nomeMercado;

    private double total;

    private ListaSequencial<Produto> produtos;

    private ListaSequencial<String> naoEncontrados;

    public ResultadoMercado(
            String nomeMercado,
            double total,
            ListaSequencial<Produto> produtos,
            ListaSequencial<String> naoEncontrados
    ) {

        this.nomeMercado = nomeMercado;
        this.total = total;
        this.produtos = produtos;
        this.naoEncontrados = naoEncontrados;
    }

    public String getNomeMercado() {
        return nomeMercado;
    }

    public double getTotal() {
        return total;
    }

    public ListaSequencial<Produto> getProdutos() {
        return produtos;
    }

    public ListaSequencial<String> getNaoEncontrados() {
        return naoEncontrados;
    }

    @Override
    public int compareTo(ResultadoMercado outro) {

        return Double.compare(
                this.total,
                outro.total
        );
    }
}