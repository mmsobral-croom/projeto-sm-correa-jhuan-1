package service;

import esd.ListaSequencial;
import model.ResultadoMercado;
import sm.Produto;
import sm.Supermercado;

import java.net.URISyntaxException;

public class ComparadorService {

    private BuscaService buscaService =
            new BuscaService();

    public ResultadoMercado comparar(
            String nomeMercado,
            Supermercado mercado,
            ListaSequencial<String> cesta
    ) throws URISyntaxException {

        double total = 0;

        ListaSequencial<Produto> produtos =
                new ListaSequencial<>();

        ListaSequencial<String> naoEncontrados =
                new ListaSequencial<>();


        for (int i = 0;
             i < cesta.comprimento();
             i++) {

            String nomeProduto =
                    cesta.obtem(i);

            Produto produto =
                    buscaService.buscarMaisBarato(
                            mercado,
                            nomeProduto
                    );


            if (produto != null) {

                produtos.adiciona(produto);

                total += produto.getPreco();

            } else {

                naoEncontrados.adiciona(
                        nomeProduto
                );
            }
        }

        return new ResultadoMercado(
                nomeMercado,
                total,
                produtos,
                naoEncontrados
        );
    }
}