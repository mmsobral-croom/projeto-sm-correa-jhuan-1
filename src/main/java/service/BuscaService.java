package service;

import sm.Produto;
import sm.Supermercado;

public class BuscaService {

    public Produto buscarMaisBarato(
            Supermercado mercado,
            String nomeProduto
    ) {


        Supermercado.Resultado resultado =
                mercado.busca(
                        nomeProduto.toLowerCase()
                );


        if (resultado == null) {
            return null;
        }

        Produto maisBarato = null;


        for (Produto p : resultado) {


            if (!p.isDisponivel()) {
                continue;
            }


            if (maisBarato == null ||
                    p.getPreco() <
                            maisBarato.getPreco()) {

                maisBarato = p;
            }
        }

        return maisBarato;
    }
}