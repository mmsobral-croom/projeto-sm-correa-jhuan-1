package sm;

import esd.ListaSequencial;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        Supermercado[] mercados = {
            new Giassi(),
            new Bistek(),
            new Fort()
        };

        ListaSequencial<String> nomesProdutos = new ListaSequencial<>();
        System.out.println("-Sistema de Busca de Preços-");
        System.out.println("Digite o nome dos produtos (ou 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String entrada = leitor.nextLine();
            if (entrada.equalsIgnoreCase("fim")) break;
            nomesProdutos.adiciona(entrada);
        }

        ListaSequencial<ResultadoMercado> resultados = new ListaSequencial<>();

        for (Supermercado mercado : mercados) {
            float totalCesta = 0;

            for (int i = 0; i < nomesProdutos.comprimento(); i++) {
                String nomeBusca = nomesProdutos.obtem(i);
                
                ListaSequencial<Produto> buscaResult = mercado.busca(nomeBusca);
                
                Produto achado = null;
                for (int j = 0; j < buscaResult.comprimento(); j++) {
                    Produto p = buscaResult.obtem(j);
                    if (p.disponivel()) { 
                        achado = p;
                        break; 
                    }
                }

                if (achado != null) {
                    totalCesta += achado.preco(); 
                }
            }
            
            String nomeMercado = mercado.getClass().getSimpleName();
            resultados.adiciona(new ResultadoMercado(nomeMercado, totalCesta));
        }

        resultados.ordena();

        System.out.println("-Ranking de Preços-");
        for (int i = 0; i < resultados.comprimento(); i++) {
            System.out.println(resultados.obtem(i));
        }
    }
}
