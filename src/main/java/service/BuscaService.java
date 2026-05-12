package service;

import sm.Produto;
import sm.Supermercado;

public class BuscaService {

    public Produto buscarMaisBarato(
            Supermercado mercado,
            String nomeProduto
    ) {

        // faz a busca
        Supermercado.Resultado resultado =
                mercado.busca(
                        nomeProduto.toLowerCase()
                );

        // se não encontrou nada
        if (resultado == null) {
            return null;
        }

        Produto maisBarato = null;

        // percorre os produtos encontrados
        for (Produto p : resultado) {

            // ignora indisponiveis
            if (!p.isDisponivel()) {
                continue;
            }

            // pega o menor preco
            if (maisBarato == null ||
                    p.getPreco() <
                            maisBarato.getPreco()) {

                maisBarato = p;
            }
        }

        return maisBarato;
    }
}